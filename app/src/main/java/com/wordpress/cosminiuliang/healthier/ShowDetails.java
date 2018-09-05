package com.wordpress.cosminiuliang.healthier;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        ActionBar actionBar = getSupportActionBar();
        TextView mDetailTv = findViewById(R.id.descTextView);
        ImageView mImageView = findViewById(R.id.descImageView);

        //get data from previous activity when item of listview is clicked using intent
        Intent intent = getIntent();
        String mActionBarTitle = intent.getStringExtra("actionBarTitle");
        String mContent = intent.getStringExtra("contentTv");

        //set actionbar title
        actionBar.setTitle(mActionBarTitle);
        //set text in textview
        mDetailTv.setText(mContent);
        //set image in imageview
        int pic = getImage(mActionBarTitle);
        scaleImage(mImageView, pic);
    }

    // potriveste marimea imaginii in caz ca depaseste dimensiunea peste limite
    private void scaleImage(ImageView img, int pic) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round((float) imgWidth / (float) screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaleImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaleImg);
    }

    private int getImage(String name) {
        switch (name) {
            case "Ou":
                return R.drawable.egg;
            case "Carne de vita":
                return R.drawable.beef;
            case "Branza":
                return R.drawable.branza;
            case "Peste":
                return R.drawable.fish;
            case "Mar":
                return R.drawable.apple;
            case "Cartof":
                return R.drawable.potato;
            case "Lapte":
                return R.drawable.milk;
            case "Carne de curcan":
                return R.drawable.turkey;
            case "Carne de miel si de oaie":
                return R.drawable.lambandmutton;
            case "Iaurt":
                return R.drawable.yaourt;
            case "Banana":
                return R.drawable.banana;
            default:
                return -1;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id== R.id.action_author){
            Intent intent = new Intent(getApplicationContext(), AuthorDetails.class);
            this.startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

