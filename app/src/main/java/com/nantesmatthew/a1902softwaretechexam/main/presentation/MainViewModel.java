package com.nantesmatthew.a1902softwaretechexam.main.presentation;

import androidx.lifecycle.ViewModel;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.use_cases.DeleteAllCredentialUseCase;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.use_cases.DeleteCredentialUseCase;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.use_cases.DeleteAllUserUseCase;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.use_cases.DeleteUserUseCase;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.use_cases.GetUsersUseCase;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.use_cases.SaveUserUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private GetUsersUseCase getUsersUseCase;
    private SaveUserUseCase saveUserUseCase;
    private DeleteUserUseCase deleteUserUseCase;
    private DeleteCredentialUseCase deleteCredentialUseCase;

    private DeleteAllUserUseCase deleteAllUserUseCase;
    private DeleteAllCredentialUseCase deleteAllCredentialUseCase;
    @Inject
    public MainViewModel (GetUsersUseCase getUsersUseCase,
                          SaveUserUseCase saveUserUseCase,
                          DeleteUserUseCase deleteUserUseCase,
                          DeleteCredentialUseCase deleteCredentialUseCase,
                          DeleteAllUserUseCase deleteAllUserUseCase,
                          DeleteAllCredentialUseCase deleteAllCredentialUseCase
                          ){
        this.getUsersUseCase = getUsersUseCase;
        this.saveUserUseCase = saveUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.deleteCredentialUseCase = deleteCredentialUseCase;
        this.deleteAllCredentialUseCase = deleteAllCredentialUseCase;
        this.deleteAllUserUseCase = deleteAllUserUseCase;
    }
    public Completable saveUser(User user){
        return saveUserUseCase.saveUser(user);
    }
   public Flowable<List<User>> getUsers(){
        return getUsersUseCase.getUsers();
   }
   public Completable deleteUser(User user){
        return deleteUserUseCase.deleteUser(user);
   }
   public Completable deleteCredential(String userName){
        return deleteCredentialUseCase.delete(userName);
   }

   public Completable deleteAllUser(){
        return deleteAllUserUseCase.deleteAllUser();
    }
    public Completable deleteAllCredentials(){
        return deleteAllCredentialUseCase.deleteAll();
    }
}
