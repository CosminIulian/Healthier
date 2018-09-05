package com.wordpress.cosminiuliang.healthier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {

    private android.webkit.WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        // get extra intents
        Intent intent =  getIntent();
        String webSite = intent.getStringExtra("webview");
        String titleBar = intent.getStringExtra("titleBar");

        // set title bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(titleBar);

        // set website for webview
        webView = (android.webkit.WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(webSite);
        // enable javascript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    // back button webview
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
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
