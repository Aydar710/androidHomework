package com.example.aydar.editingusersprofile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtName;
    TextView txtEmail;
    TextView txtPhone;

    Button btnEdit;
    Button btnShare;

    ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txt_name);
        txtEmail = findViewById(R.id.txt_email);
        txtPhone = findViewById(R.id.txt_phone);

        btnEdit = findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(onClickListener);
        btnShare = findViewById(R.id.btn_share);

        ivPhoto = findViewById(R.id.iv_photoMain);
    }

    View.OnClickListener onClickListener = view -> {
        Intent intent = new Intent(MainActivity.this, EditingActivity.class);
        intent.putExtra("EXTRA_NAME", txtName.getText());
        intent.putExtra("EXTRA_EMAIL", txtEmail.getText());
        intent.putExtra("EXTRA_PHONE", txtPhone.getText());

        ivPhoto.buildDrawingCache();
        Bitmap bitmap = ivPhoto.getDrawingCache();

        Bundle extrasCancel = new Bundle();
        extrasCancel.putParcelable("EXTRA_PHOTO", bitmap);
        intent.putExtras(extrasCancel);

        startActivityForResult(intent, 1);
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null)
            return;
        else {
            if (resultCode == RESULT_OK)
                Toast.makeText(this, "Успешно", Toast.LENGTH_SHORT).show();
            if (resultCode == RESULT_CANCELED)
                Toast.makeText(this, "Отменено", Toast.LENGTH_SHORT).show();
            txtName.setText(data.getStringExtra("EXTRA_NAME"));
            txtEmail.setText(data.getStringExtra("EXTRA_EMAIL"));
            txtPhone.setText(data.getStringExtra("EXTRA_PHONE"));

            Bundle extras = data.getExtras();
            Bitmap bitmap = extras.getParcelable("EXTRA_PHOTO");
            ivPhoto.setImageBitmap(bitmap);

        }
    }

    public void onShareClick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String message = "Имя: " + txtName.getText() + "\n"
                + "Email: " + txtEmail.getText() + "\n"
                + "Телефон: " + txtPhone.getText();
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivityForResult(intent, 1);
    }

}
