package com.example.diseologin.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.diseologin.R;
import com.example.diseologin.databinding.ActivityHomeBinding;
import com.example.diseologin.databinding.ActivitySignInBinding;
import com.example.diseologin.mvvm_sign_in.view_model.SignInViewModel;
import com.example.diseologin.utils.BaseActivity;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> {

    @NonNull
    @Override
    protected HomeViewModel createViewModel() {
        return new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @NonNull
    @Override
    protected ActivityHomeBinding createViewBinding(LayoutInflater layoutInflater) {
        return ActivityHomeBinding.inflate(layoutInflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}