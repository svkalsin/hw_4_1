package ru.netology.lists;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    private final static String ATRIBUTE_TITLE = "title";
    private final static String ATRIBUTE_SUBTITLE = "subtitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        String[] from = {ATRIBUTE_TITLE, ATRIBUTE_SUBTITLE};
        int[] to = {R.id.tv_title,R.id.tv_subtitle};
        return new SimpleAdapter(this,values,R.layout.list_view,from,to);
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        String[] strings = getString(R.string.large_text).split("\n\n");
        List<Map<String, String>> values = new ArrayList<>();
        for (String str : strings) {
            Map<String, String> map = new HashMap<>();
            map.put(ATRIBUTE_TITLE, str);
            map.put(ATRIBUTE_SUBTITLE, ""+str.length());
            values.add(map);
        }
        return values;
    }
}
