package com.example.diseologin.mvvm_sign_up.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.diseologin.firebase.CustomOnCompleteListener;
import com.example.diseologin.mvvm_sign_up.model.SignUpModel;
import com.example.diseologin.utils.BaseViewModel;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpViewModel extends BaseViewModel {
    private FirebaseAuth firebaseAuth;

    private MutableLiveData<FirebaseUser> firebaseUser;
    private SignUpModel repository;


    public SignUpViewModel() {
        this.repository = SignUpModel.getInstance();
        repository = SignUpModel.getInstance();
        this.firebaseUser = new MutableLiveData<>();
    }

    public void singUp(String email, String password){
        loading.postValue(true);
        firebaseAuth = FirebaseAuth.getInstance();

        repository.singUp(new CustomOnCompleteListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult task) {
                firebaseUser.postValue(firebaseAuth.getCurrentUser());
                loading.postValue(false);
            }

            @Override
            public void onFailure(Throwable throwable) {
                msgError.postValue(throwable.getMessage());
                loading.postValue(false);

            }
        },email,password);

    }


    public LiveData<FirebaseUser> getfirebaseUser(){
        return firebaseUser;
    }

}
