package com.nantesmatthew.a1902softwaretechexam.sign_up.presentation;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.Credentials;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.use_cases.SaveCredentialUseCase;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.use_cases.SaveUserUseCase;
import com.nantesmatthew.a1902softwaretechexam.core.util.Resource;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class SignUpViewModel extends ViewModel {
    private SaveUserUseCase saveUserUseCase;
    private SaveCredentialUseCase saveCredentialUseCase;
    private static final String TAG = "SignUpViewModel";

    @Inject
    public SignUpViewModel(SaveUserUseCase saveUserUseCase,SaveCredentialUseCase saveCredentialUseCase) {
        this.saveUserUseCase = saveUserUseCase;
        this.saveCredentialUseCase = saveCredentialUseCase;
    }

    public Completable saveUser(User user) {
       return saveUserUseCase.saveUser(user);
    }
    public Completable saveCredentials(Credentials credentials){
        return saveCredentialUseCase.saveCredential(credentials);
    }
}
