package com.persistent.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Map<String,String>> arrayList = getListViewResources();
        ListAdapter adapter = new ListAdapter(this, arrayList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private ArrayList<Map<String, String>> getListViewResources(){

        ArrayList<Map<String, String>> arrayList = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("title","Udemy");
        map.put("url","http://www.udemy.com");
        map.put("image","udemy.jpg");

        arrayList.add(map);
        arrayList.add(map);
        arrayList.add(map);

        return arrayList;
    }
}
