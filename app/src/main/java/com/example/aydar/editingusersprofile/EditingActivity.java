package com.example.aydar.editingusersprofile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EditingActivity extends AppCompatActivity {

    EditText etName;
    EditText etEmail;
    EditText etPhone;

    Button btnApply;
    Button btnCancel;
    Button btnMakePhoto;
    Button btnGallery;

    Bitmap bitmap;

    ImageView ivPhoto;

    final int REQUEST_CODE_PHOTO = 1;
    final int SELECT_PICTURE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_Email);
        etPhone = findViewById(R.id.et_Phone);

        btnApply = findViewById(R.id.btn_apply);
        btnCancel = findViewById(R.id.btn_cancel);
        btnMakePhoto = findViewById(R.id.btn_make_photo);
        btnGallery = findViewById(R.id.btn_gallery);

        ivPhoto = findViewById(R.id.iv_photo);

        btnMakePhoto.setOnClickListener(onClickListener);
        btnApply.setOnClickListener(onClickListener);
        btnGallery.setOnClickListener(onClickListener);
        btnCancel.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = view -> {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_apply:
                intent = new Intent();
                intent.putExtra("EXTRA_NAME", etName.getText().toString());
                intent.putExtra("EXTRA_EMAIL", etEmail.getText().toString());
                intent.putExtra("EXTRA_PHONE", etPhone.getText().toString());
                setResult(RESULT_OK, intent);

                Bundle extras = new Bundle();
                extras.putParcelable("EXTRA_PHOTO", bitmap);
                intent.putExtras(extras);

                finish();
                break;
            case R.id.btn_make_photo:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_PHOTO);
                break;

            case R.id.btn_gallery:
                intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(
                        intent, "Select Picture"), SELECT_PICTURE);
                break;
            case R.id.btn_cancel:
                intent = getIntent();
                setResult(RESULT_CANCELED, intent);
                finish();
                break;
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == REQUEST_CODE_PHOTO) {
                bitmap = (Bitmap) data.getExtras().get("data");
                ivPhoto.setImageBitmap(bitmap);
            } else if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                ivPhoto.setImageURI(selectedImageUri);
                ivPhoto.buildDrawingCache();
                bitmap = ivPhoto.getDrawingCache();
            }
        }
    }
}
