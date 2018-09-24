package com.example.aydar.editingusersprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnActionEdit;
    Button btnActionView;
    Button btnActionDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActionEdit = findViewById(R.id.btn_action_edit);
        btnActionEdit.setOnClickListener(onClickListener);

        btnActionView = findViewById(R.id.btn_action_view);
        btnActionView.setOnClickListener(onClickListener);

        btnActionDial = findViewById(R.id.btn_action_dial);
        btnActionDial.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = view -> {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_action_edit:
                intent = new Intent(Intent.ACTION_EDIT);
                startActivity(intent);
                break;
            case R.id.btn_action_view:
                intent = new Intent(Intent.ACTION_VIEW);
                startActivity(intent);
                break;
            case R.id.btn_action_dial:
                intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
                break;
        }
    };

}
