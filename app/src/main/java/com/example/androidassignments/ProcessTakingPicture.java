package com.example.androidassignments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.util.Date;

public class ProcessTakingPicture {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    AppCompatActivity anActivity ;
    View imageView ;


    public ProcessTakingPicture(AppCompatActivity anActivity, View imageView) {
        this.anActivity =anActivity ;
        this.imageView = imageView ;
        imageClicked(imageView);
    }


    public void imageClicked(View imageView) {

        ImageButton btnImg = anActivity.findViewById(R.id.camera_button);
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(anActivity.getPackageManager()) != null) {
            anActivity.startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void saveImage(Bitmap imageBitmap) {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        java.text.DateFormat dateFormat =
                new java.text.SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);

        try {
            FileOutputStream outputStream =
                    anActivity.openFileOutput(formattedDate, Context.MODE_PRIVATE);
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 80, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
        }
    }
}
