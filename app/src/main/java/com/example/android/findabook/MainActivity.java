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
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Stubbed Book 1", "Author 1"));
        books.add(new Book("Stubbed Book 2", "Author"));
        books.add(new Book("Stubbed Book 3", "Author"));
        books.add(new Book("Stubbed Book 4", "Author"));
        books.add(new Book("Stubbed Book 5", "Author"));
        books.add(new Book("Stubbed Book 6", "Author"));
        books.add(new Book("Stubbed Book 7", "Author"));
        books.add(new Book("Stubbed Book 8", "Author"));
        books.add(new Book("Stubbed Book 9", "Author 9"));

        //Find our book list setup in the XML
        ListView bookListView = (ListView) findViewById(R.id.list);

        //Create a new adapter for our list of books
        mAdapter = new BookAdapter(this, QueryUtils.parseBooks(""));

        bookListView.setAdapter(mAdapter);
    }
}
