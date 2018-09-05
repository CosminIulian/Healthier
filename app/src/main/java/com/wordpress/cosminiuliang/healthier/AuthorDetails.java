package com.wordpress.cosminiuliang.healthier;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AuthorDetails extends AppCompatActivity {

    private TextView authorTv;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_details);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Autor");

        authorTv = findViewById(R.id.authorTv);
        authorTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String authorSite =
                        "https://cosminiuliang.wordpress.com/";
                Uri URL = Uri.parse(authorSite);

                Intent gotoSite = new Intent(Intent.ACTION_VIEW, URL);

                // daca rezolva activitatea ceruta se executa altfel nu se intampla nimic
                if (gotoSite.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoSite);
                }
            }
        });

    }


}

