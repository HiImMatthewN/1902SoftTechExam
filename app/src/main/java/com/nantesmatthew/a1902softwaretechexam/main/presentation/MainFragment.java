package com.nantesmatthew.a1902softwaretechexam.main.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.nantesmatthew.a1902softwaretechexam.R;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;
import com.nantesmatthew.a1902softwaretechexam.common.user.presentation.OnUserSelect;
import com.nantesmatthew.a1902softwaretechexam.common.user.presentation.UserAdapter;
import com.nantesmatthew.a1902softwaretechexam.common.user_details.presentation.UserDetailsDialog;
import com.nantesmatthew.a1902softwaretechexam.core.util.SharedPrefHelper;
import com.nantesmatthew.a1902softwaretechexam.databinding.FragmentMainBinding;
import com.nantesmatthew.a1902softwaretechexam.login.presentation.LoginActivity;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

@AndroidEntryPoint
public class MainFragment extends Fragment {
    private FragmentMainBinding binder;
    private RecyclerView rvUsers;
    private UserAdapter adapterUser = new UserAdapter();

    private MainViewModel mainViewModel;
    private static final String TAG = "MainFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = FragmentMainBinding.inflate(inflater, container, false);
        return binder.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        rvUsers = binder.rvUsers;
        rvUsers.setAdapter(adapterUser);


        adapterUser.setOnUserSelect(new OnUserSelect() {
            @Override
            public void onSelect(User user) {
                showUserDetailsDialog(user);
            }

            @Override
            public void onDelete(User user) {
                Log.d(TAG, "onDelete: " + user.getUserName());
                mainViewModel.deleteUser(user).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
                            Log.d(TAG, "onDelete: Delete?");

                            mainViewModel.deleteCredential(user.getUserName()).subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
                                        Toast.makeText(requireContext(), "Deleted " + user.getFullName(), Toast.LENGTH_SHORT).show();

                                    }, throwable -> {

                                    });
                        }, throwable -> {
                            Toast.makeText(requireContext(), throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        });
                ;
            }
        });

        mainViewModel.getUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(users -> {
                    Log.d(TAG, "Getting Users " + users.size());
                    adapterUser.setUsers(users);
                }, throwable -> {
                    Toast.makeText(requireContext(), throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                });


    }

    private void addDummyUser() {
        int randomNumber = (int) (Math.random() * (400 - 200 + 1) + 200);
        String randomUserName = "JuanDelaCruz" + randomNumber;

        User dummyUser = new User("Juan Dela Cruz " + randomNumber, randomUserName, randomUserName, "Dummy Designation", "Dummy Information");
        mainViewModel.saveUser(dummyUser).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
                    Toast.makeText(requireContext(), "Dummy Data Added", Toast.LENGTH_SHORT).show();
                }, throwable -> {
                    Toast.makeText(requireContext(), throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                });

    }
    private void showUserDetailsDialog(User user){
        Bundle bundle = new Bundle();
        bundle.putString("FullName",user.getFullName());
        bundle.putString("Details",user.getInformation());

        UserDetailsDialog dialog = new UserDetailsDialog();
        dialog.setArguments(bundle);
        dialog.show(getChildFragmentManager(),"User Details");

    }
    private void goToLoginScreen() {
        Intent intent = new Intent(requireContext(), LoginActivity.class);
        requireActivity().startActivity(intent);
        requireActivity().finish();
    }

    private void signOut() {
        mainViewModel.deleteAllUser().subscribeOn(Schedulers.io())
                .subscribe(() -> {
                    mainViewModel.deleteAllCredentials()
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(this::goToLoginScreen, throwable -> {
                                Toast.makeText(requireContext(), throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            });
                }, throwable -> {
                    Toast.makeText(requireContext(), throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                });

        SharedPrefHelper.write(SharedPrefHelper.REMEMBER_ME,false);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_item: {
                addDummyUser();


                break;
            }
            case R.id.action_sign_out: {
                signOut();

                break;
            }


        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
}
