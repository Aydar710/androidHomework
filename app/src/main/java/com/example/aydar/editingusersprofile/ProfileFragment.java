package com.example.aydar.editingusersprofile;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements DialFragment.MyListener {
        TextView txtLogin;
        TextView txtPassword;
        Button btnEdit;

    public ProfileFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        txtLogin = view.findViewById(R.id.txt_login);
        txtPassword = view.findViewById(R.id.txt_password);
        btnEdit = view.findViewById(R.id.btn_edit);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnEdit.setOnClickListener(v -> {
            DialFragment dialFragment = new DialFragment();
            dialFragment.show(getActivity().getSupportFragmentManager(), "dialog");
        });
    }

    @Override
    public void onClick(String login, String password) {
        txtLogin.setText(login);
        txtPassword.setText(password);
    }
}
