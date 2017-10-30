package com.example.android.findabook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Stub in some book data to test with
        ArrayList<String> books = new ArrayList<String>();
        books.add("Stubbed Book 1");
        books.add("Stubbed Book 2");
        books.add("Stubbed Book 3");

        //Find our book list setup in the XML
        ListView bookListView = (ListView) findViewById(R.id.list);

        //Create a new adapter for our list of books
        mAdapter = new BookAdapter(this, new ArrayList<String>(books));

        bookListView.setAdapter(mAdapter);
    }
}
