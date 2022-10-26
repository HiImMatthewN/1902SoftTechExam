package com.nantesmatthew.a1902softwaretechexam.login.presentation;

import androidx.lifecycle.ViewModel;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.Credentials;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.use_cases.CheckCredentialUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@HiltViewModel
public class LoginViewModel extends ViewModel {
    private CheckCredentialUseCase checkCredentialUseCase;

    @Inject
    public LoginViewModel( CheckCredentialUseCase checkCredentialUseCase) {
        this.checkCredentialUseCase = checkCredentialUseCase;
    }
    public Single<Credentials> checkCredentials(String userName, String password){
        return checkCredentialUseCase.checkCredential(userName,password);
    }
}
