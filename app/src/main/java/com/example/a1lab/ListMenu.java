package com.example.a1lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class ListMenu extends AppCompatActivity {
    String[] Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDataForListView();
    }

    public void getDataForListView()
    {
        Bundle b = this.getIntent().getExtras();
        String[] data = b.getStringArray("key");
        Data = data;
        addToListView(data);
    }

    public void addToListView(String[] data)
    {
        ListView mListView = (ListView) findViewById(R.id.listView);
        ArrayList<result> resultsList = new ArrayList<>();
        for(int i = 0; i < data.length; i++)
        {
            result obj = new result(data[i]);
            resultsList.add(obj);
        }
        resultsListAdapter adapter = new resultsListAdapter(this, R.layout.adapter_view_layout, resultsList);
        mListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.mainActivity: {
                Bundle b = new Bundle();
                b.putStringArray("key", Data);
                Intent Intent = new Intent(this, MainActivity.class);
                Intent.putExtras(b);
                startActivity(Intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}