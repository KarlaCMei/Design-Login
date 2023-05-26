package com.example.diseologin.mvvm_sign_up.view;

import static com.example.diseologin.utils.StrigUtils.validateEmail;
import static com.example.diseologin.utils.StrigUtils.validatePassword;
import static com.example.diseologin.utils.StrigUtils.validateSamePassword;

import androidx.annotation.NonNull;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.Toast;

import com.example.diseologin.databinding.ActivitySignUpBinding;
import com.example.diseologin.home.HomeActivity;
import com.example.diseologin.mvvm_sign_in.view.SignInActivity;
import com.example.diseologin.mvvm_sign_up.view_model.SignUpViewModel;
import com.example.diseologin.utils.BaseActivity;
import com.example.diseologin.webview.WebViewActivity;
import com.google.firebase.auth.FirebaseUser;


public class SignUpActivity extends BaseActivity<ActivitySignUpBinding, SignUpViewModel> {
    @NonNull
    @Override
    protected SignUpViewModel createViewModel() {
        return new ViewModelProvider(this).get(SignUpViewModel.class);
    }

    @NonNull
    @Override
    protected ActivitySignUpBinding createViewBinding(LayoutInflater layoutInflater) {
        return ActivitySignUpBinding.inflate(layoutInflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.btnPrivacyPoliticSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, WebViewActivity.class));

            }
        });

        binding.textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                onBackPressed();

            }
        });

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (validateEmail(binding.editTextEmail.getText().toString())) {
                    binding.editTextEmail.setError(null);

                    if (validatePassword(binding.editTextPassword.getText().toString()) ) {
                        binding.editTextPassword.setError(null);

                        if(validateSamePassword(binding.editTextPassword.getText().toString(), binding.editTextVerifyPassword.getText().toString())){
                            //Toast.makeText(SignUpActivity.this, "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                            binding.editTextVerifyPassword.setError("La contraseña no coincide");
                        }else{
                            viewModel.singUp(binding.editTextEmail.getText().toString(), binding.editTextPassword.getText().toString());
                        }
                    } else {
                        binding.editTextPassword.setError("La contraseña tiene que ser mayor a 6 digitos");
                    }

                } else {
                    binding.editTextEmail.setError("Email no valido");
                }
            }
        });


        viewModel.getfirebaseUser().observe(SignUpActivity.this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                Log.e("Email", firebaseUser.getEmail());

                startActivity(new Intent(SignUpActivity.this, HomeActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });

    }

}