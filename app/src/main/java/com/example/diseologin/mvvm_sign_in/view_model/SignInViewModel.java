package com.example.diseologin.mvvm_sign_in.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.diseologin.firebase.CustomOnCompleteListener;
import com.example.diseologin.mvvm_sign_in.model.SignInModel;
import com.example.diseologin.utils.BaseViewModel;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInViewModel extends BaseViewModel {
    private FirebaseAuth mAuth;
    private MutableLiveData<FirebaseUser> mutableLiveData;

    private SignInModel repository;

    public SignInViewModel() {
        this.repository = SignInModel.getInstance();
        repository = SignInModel.getInstance();
        this.mutableLiveData = new MutableLiveData<>();

    }

    public void doLogin(String email, String password){

        loading.postValue(true);

        mAuth = FirebaseAuth.getInstance();

        repository.login(new CustomOnCompleteListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult task) {
                mutableLiveData.postValue(mAuth.getCurrentUser());
                loading.postValue(false);

            }

            @Override
            public void onFailure(Throwable throwable) {
                msgError.postValue(throwable.getMessage());
                loading.postValue(false);

            }
        }, email,password);

    }



    public LiveData<FirebaseUser> getFireBaseUser(){
        return mutableLiveData;
    }


}
