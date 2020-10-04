package com.base.bawbaw.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.ImgExec;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;

public class OwnerPhotoActivity extends AppCompatActivity {
    ImageView mImageView;
    Button mBtnAdd;

    Context context;

    final int REQUEST_CODE_GALLERY = 999;
    public ImgExec imgExec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_photo);


        context = this;

        imgExec = new ImgExec(context);

        mImageView = findViewById(R.id.cameraOwner);
        mBtnAdd = findViewById(R.id.saveOwnerPhoto);


        //get owner image from gallery
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActivityCompat.requestPermissions(
                        OwnerPhotoActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );

            }
        });


        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    //check image exists
                    int exists = imgExec.checkImageExists();

                    if (exists == 0) {

                        //if no imgae insert to the database
                        imgExec.insertOwnerData(
                                imageViewToByte(mImageView));

                        startActivity(new Intent(context, ProfileActivity.class));
                        finish();

                    } else {

                        //if image is already in the database update it
                        imgExec.updateOwnerData(imageViewToByte(mImageView));
                    }


                    Toast.makeText(OwnerPhotoActivity.this, "Added sucessfully", Toast.LENGTH_SHORT).show();

                    //reset view
                    mImageView.setImageResource(R.drawable.addphotos);

                    startActivity(new Intent(context, ProfileActivity.class));
                    finish();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    //convert image data to byte to store in database
    public static byte[] imageViewToByte(ImageView mImageView) {

        Bitmap bitmap = ((BitmapDrawable) mImageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        return byteArray;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //galleray intent
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, REQUEST_CODE_GALLERY);

            } else {
                Toast.makeText(this, "Don't have permission to access file location", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)//enable image guidelines
                    .setAspectRatio(1, 1)//image will be square
                    .start(this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK) {

                Uri resultUri = result.getUri();
                mImageView.setImageURI(resultUri);

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);

    }


}