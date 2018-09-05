package com.wordpress.cosminiuliang.healthier;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class ListAliments extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter adapter;
    private String[] nameAliments;
    private String[] calories;
    private int[] icon;
    private ArrayList<Model> arrayList = new ArrayList<Model>();
    private String[] description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_aliments);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Aliments List");

        Resources res = getResources();
        nameAliments = res.getStringArray(R.array.alimentsName);
        calories = res.getStringArray(R.array.calories);
        icon = new int[]{ R.drawable.egg, R.drawable.beef, R.drawable.branza, R.drawable.fish,
                R.drawable.apple, R.drawable.potato, R.drawable.milk, R.drawable.turkey,
                R.drawable.lambandmutton, R.drawable.yaourt, R.drawable.banana };
        description = res.getStringArray(R.array.descriptionAliments);

        listView = findViewById(R.id.myListView);

        for (int i =0; i<nameAliments.length; i++){
            Model model = new Model(nameAliments[i], calories[i], icon[i], description[i]);
            //bind all strings in an array
            arrayList.add(model);
        }

        //pass results to listViewAdapter class
        adapter = new ListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
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
