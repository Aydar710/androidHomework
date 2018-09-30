package com.example.aydar.editingusersprofile;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.function.ToDoubleBiFunction;


//Не закончено

public class EditFragment extends DialogFragment {

    EditText etLogin;
    EditText etPassword;
    Button btnEdit;
    private MyListener listener;

    public EditFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener = (MyListener) context;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);

        //***
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_edit, null);

        etLogin = view.findViewById(R.id.et_login);
        etPassword = view.findViewById(R.id.et_password);

        AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity());

        adBuilder.setTitle("Edit")
                .setView(view)
                .setPositiveButton("Apply", (dialog, which) ->
                        listener.onClick(etLogin.getText().toString(), etPassword.getText().toString()))
                .setNegativeButton("No, Thanks", (dialog, which) -> {
                    dismiss();
                });

        return adBuilder.create();

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    interface MyListener{
        void onClick(String login, String password);
    }
}
