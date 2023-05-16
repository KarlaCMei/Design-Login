package com.example.diseologin.mvvm_sign_up.model;

import com.example.diseologin.firebase.CustomOnCompleteListener;
import com.example.diseologin.mvvm_sign_in.model.SignInModel;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpModel {

    private static SignUpModel instance;

    public static SignUpModel getInstance(){
        if(instance == null ) instance = new SignUpModel();
        return instance;
    }

    public void singUp(CustomOnCompleteListener<AuthResult> onCompleteListener, String email, String password){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(onCompleteListener);

    }


}
