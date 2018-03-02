package com.example.himel.volleyappphpmysql;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.kosalgeek.android.photoutil.GalleryPhoto;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String TAG = this.getClass().getSimpleName();
    GalleryPhoto galleryPhoto;
    final int  GALAREY_REQUEST =1100;

    ImageView ivgalary,ivupload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        galleryPhoto = new GalleryPhoto(getApplicationContext());

       ivgalary = (ImageView)findViewById(R.id.galaryIV);
       ivupload = (ImageView)findViewById(R.id.uploadIV);
        ivgalary.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v==ivgalary) {

            Intent i = galleryPhoto.openGalleryIntent();
            startActivityForResult(i, GALAREY_REQUEST);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            if (requestCode == GALAREY_REQUEST){
                galleryPhoto.setPhotoUri(data.getData());
                Log.d(TAG, galleryPhoto.getPath());
            }
        }

    }
}
