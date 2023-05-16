package com.example.diseologin.firebase;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.diseologin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public abstract class CustomOnCompleteListener<T> implements OnCompleteListener<T> {


    /*private AlertDialog builderCustom;

    public CustomOnCompleteListener(Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();

        View view = inflater.inflate(R.layout.lottie_error, null);

        builder.setView(view);

        builderCustom = builder.show();
    }*/


    @Override
    public void onComplete(@NonNull Task<T> task){
        if(task.isSuccessful()){
            onSuccess(task.getResult());

        }else{
            onFailure(task.getException());

        }


    }

    public abstract void onSuccess(T task);
    public abstract void onFailure(Throwable throwable);


}
