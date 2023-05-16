package com.example.diseologin.mvvm_sign_in.model;

import com.example.diseologin.firebase.CustomOnCompleteListener;
import com.example.diseologin.mvvm_sign_in.view_model.SignInViewModel;
import com.example.diseologin.utils.BaseActivity;
import com.example.diseologin.utils.BaseViewModel;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInModel {

    private static SignInModel instance;

    public static SignInModel getInstance(){
        if(instance == null ) instance = new SignInModel();
        return instance;
    }

    public void login(CustomOnCompleteListener<AuthResult> onCompleteListener, String email, String password){

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(onCompleteListener);


    }

}
