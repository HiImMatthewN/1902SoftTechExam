package com.nantesmatthew.a1902softwaretechexam.login.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.nantesmatthew.a1902softwaretechexam.R;
import com.nantesmatthew.a1902softwaretechexam.core.util.SharedPrefHelper;
import com.nantesmatthew.a1902softwaretechexam.databinding.FragmentLoginBinding;
import com.nantesmatthew.a1902softwaretechexam.main.presentation.MainActivity;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

@AndroidEntryPoint
public class LoginFragment extends Fragment {
    private FragmentLoginBinding binder;
    private EditText etUserName;
    private EditText etPassword;
    private CheckBox cbRememberMe;
    private Button btnLogin;
    private TextView tvCreateAccount;

    private NavController navController;
    private LoginViewModel viewModelLogin;
    private static final String TAG = "LoginFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = FragmentLoginBinding.inflate(inflater, container, false);
        return binder.getRoot();
    }

    @Override   
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelLogin = new ViewModelProvider(this).get(LoginViewModel.class);
        navController = Navigation.findNavController(view);
        SharedPrefHelper.init(requireContext());

        etUserName = binder.etUserName;
        etPassword = binder.etPassword;
        cbRememberMe = binder.cbRememberMe;
        btnLogin = binder.btnLogIn;
        tvCreateAccount = binder.tvCreateAccount;
        btnLogin.setOnClickListener(btn -> {
            if (isInputValid()) {
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                Log.d(TAG, "onViewCreated: checking");
                viewModelLogin.checkCredentials(userName, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(credentials -> {

                            SharedPrefHelper.write(SharedPrefHelper.REMEMBER_ME,cbRememberMe.isChecked());

                                    goToHomeScreen();
                                },
                                throwable -> {
                                    Toast.makeText(requireContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                                });
            }


        });

        tvCreateAccount.setOnClickListener(tv -> {
            navController.navigate(R.id.action_loginFragment_to_signUpFragment);
        });

        boolean remembered = SharedPrefHelper.read(SharedPrefHelper.REMEMBER_ME,false);
        if (remembered){
            cbRememberMe.setChecked(true);
            goToHomeScreen();
        }else{
            cbRememberMe.setChecked(false);

        }

    }

    private boolean isInputValid() {

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

        return true;
    }

    private void goToHomeScreen() {
        Intent intent = new Intent(requireContext(), MainActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }
}
