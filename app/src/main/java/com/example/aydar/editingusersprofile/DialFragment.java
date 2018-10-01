package com.example.aydar.editingusersprofile;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class DialFragment extends DialogFragment {

    EditText etLogin;
    EditText etPassword;
    private MyListener listener;

    public DialFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener = (MyListener) context;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.dialog_edit, null);

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

    interface MyListener {
        void onClick(String login, String password);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
