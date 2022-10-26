package com.nantesmatthew.a1902softwaretechexam.login.presentation;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nantesmatthew.a1902softwaretechexam.databinding.ActivityLoginBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());

    }
}
