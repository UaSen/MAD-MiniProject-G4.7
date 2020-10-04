package com.base.bawbaw.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.base.bawbaw.R;
import com.base.bawbaw.exec.ImgExec;
import com.base.bawbaw.exec.OwnerExec;
import com.base.bawbaw.model.Image;
import com.base.bawbaw.model.Owner;

public class Header extends AppCompatActivity {

    private OwnerExec ownerExec;
    public ImgExec imgExec;

    Context context;

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.header);

        context = this;
        System.out.println("1");
        ownerExec = new OwnerExec(context);
        imgExec = new ImgExec(context);
        System.out.println("2");
        imageView.findViewById(R.id.ownerMenu);
        textView.findViewById(R.id.nameMenu);
        System.out.println("3");
        Image imgs = imgExec.viewOwnerImage();
        System.out.println("4");
        byte[] gImage = imgs.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(gImage,0,gImage.length);
        imageView.setImageBitmap(bitmap);
        System.out.println("5");
        Owner ownerExist = ownerExec.viewOnlyOwner();
        System.out.println("6");
        textView.setText(ownerExist.getName());
        System.out.println("7");
    }
}
