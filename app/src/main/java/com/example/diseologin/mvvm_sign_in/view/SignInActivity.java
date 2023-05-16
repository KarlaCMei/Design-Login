package com.example.diseologin.mvvm_sign_in.view;

import static com.example.diseologin.utils.StrigUtils.validateEmail;
import static com.example.diseologin.utils.StrigUtils.validatePassword;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import com.example.diseologin.databinding.ActivitySignInBinding;
import com.example.diseologin.home.HomeActivity;
import com.example.diseologin.mvvm_sign_in.view_model.SignInViewModel;
import com.example.diseologin.mvvm_sign_up.view.SignUpActivity;
import com.example.diseologin.utils.BaseActivity;
import com.example.diseologin.webview.WebViewActivity;
import com.google.firebase.auth.FirebaseUser;
public class SignInActivity extends BaseActivity<ActivitySignInBinding, SignInViewModel> {
    @NonNull
    @Override
    protected SignInViewModel createViewModel() {
        return new ViewModelProvider(this).get(SignInViewModel.class);
    }

    @NonNull
    @Override
    protected ActivitySignInBinding createViewBinding(LayoutInflater layoutInflater) {
        return ActivitySignInBinding.inflate(layoutInflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.btnPrivacyPoliticSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this, WebViewActivity.class));

            }
        });


        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validateEmail(binding.editTextEmail.getText().toString())) {
                    binding.editTextEmail.setError(null);
                    if (validatePassword(binding.editTextPassword.getText().toString())) {
                        binding.editTextPassword.setError(null);
                        viewModel.doLogin(binding.editTextEmail.getText().toString(), binding.editTextPassword.getText().toString());
                    } else {
                        binding.editTextPassword.setError("La contraseña tiene que ser mayor a 6 digitos");
                    }
                } else {
                    binding.editTextEmail.setError("Email no valido");
                }



            }
        });


        binding.textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, Datos.class);
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });

        createUserWithEmail();


    }


    private void createUserWithEmail() {
        viewModel.getFireBaseUser().observe(SignInActivity.this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                Log.e("Email", firebaseUser.getEmail());
                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                startActivity(intent);
                SignInActivity.this.finish();
            }
        });

    }

}