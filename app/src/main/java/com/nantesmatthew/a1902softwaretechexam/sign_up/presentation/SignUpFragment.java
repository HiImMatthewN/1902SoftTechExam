package com.nantesmatthew.a1902softwaretechexam.sign_up.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.Credentials;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;
import com.nantesmatthew.a1902softwaretechexam.databinding.FragmentSignUpBinding;
import com.nantesmatthew.a1902softwaretechexam.main.presentation.MainActivity;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


@AndroidEntryPoint
public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binder;
    private ImageButton btnBack;
    private EditText etFullName;
    private EditText etEmail;
    private EditText etUserName;
    private EditText etPassword;
    private EditText etRepeatPassword;
    private Button btnSignUp;

    private NavController navController;
    private SignUpViewModel viewModelSignUp;

    private static final String TAG = "SignUpFragment";

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = FragmentSignUpBinding.inflate(inflater, container, false);
        return binder.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        viewModelSignUp = new ViewModelProvider(this).get(SignUpViewModel.class);

        btnBack = binder.btnBack;
        etFullName = binder.etFullName;
        etEmail = binder.etEmail;
        etUserName = binder.etUserName;
        etPassword = binder.etPassword;
        etRepeatPassword = binder.etRepeatPassword;
        btnSignUp = binder.btnSignUp;


        btnBack.setOnClickListener(btn -> {
            navController.popBackStack();
        });

        btnSignUp.setOnClickListener(btn -> {
            if (isInputValid()) {
                User newUser = createUser();
                saveUser(newUser);
            }
        });
    }

    private void saveUser(User newUser) {
        Disposable disposable = viewModelSignUp.saveUser(newUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {

                    Credentials userCredentials = createCredentials();
                    saveCredentials(userCredentials);
                }, throwable -> {

                });

        mDisposable.add(disposable);
    }

    private void saveCredentials(Credentials credentials) {
        Disposable disposable = viewModelSignUp.saveCredentials(credentials)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
                    Log.d(TAG, "saveUser: Credentials Saved");
                    goToHomeScreen();
                }, throwable -> {

                });

        mDisposable.add(disposable);

    }

    private boolean isInputValid() {
        boolean hasNoFullName = etFullName.getText().toString().trim().isEmpty();
        if (hasNoFullName) {
            etFullName.setError("Empty Full Name field");
            return false;
        }
        boolean hasNoEmail = etEmail.getText().toString().trim().isEmpty();
        if (hasNoEmail) {
            etEmail.setError("Empty Email field");
            return false;
        }
        boolean hasNoUserName = etUserName.getText().toString().trim().isEmpty();
        if (hasNoUserName) {
            etUserName.setError("Empty User Name field");
            return false;
        }
        boolean hasNoPassword = etPassword.getText().toString().trim().isEmpty();
        if (hasNoPassword) {
            etPassword.setError("Empty Password field");
            return false;
        }

        String userPassword = etPassword.getText().toString().trim();
        String repeatedPassword = etRepeatPassword.getText().toString().trim();
        boolean isPasswordConfirmed = userPassword.equals(repeatedPassword);
        if (!isPasswordConfirmed) {
            etRepeatPassword.setError("Mismatch Password");
            return false;
        }
        return true;
    }

    private User createUser() {
        String fullName = etFullName.getText().toString().trim();
        String email = etEmail.getText().toString();
        String userName = etUserName.getText().toString();

        return new User(fullName, userName, email);
    }

    private Credentials createCredentials() {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        return new Credentials(userName, password);
    }
    private void goToHomeScreen(){
        Intent intent = new Intent(requireContext(), MainActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
    }
}
