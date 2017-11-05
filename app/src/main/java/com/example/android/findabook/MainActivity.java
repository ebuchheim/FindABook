package com.example.android.findabook;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.BASE;

public class MainActivity extends AppCompatActivity {

    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton = (Button) findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText userInput = (EditText) findViewById(R.id.search_bar);
                String userInputString = userInput.getText().toString();
                new BookAsyncTask().execute(userInputString);
            }
        });
    }

    private class BookAsyncTask extends AsyncTask<String, Void, ArrayList<Book>> {

        @Override
        protected ArrayList<Book> doInBackground(String... urls) {

            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            return QueryUtils.FetchBookData(urls[0]);
        }

        @Override
        protected void onPostExecute(ArrayList<Book> books) {
            super.onPostExecute(books);

            //Create a new adapter for our list of books
            mAdapter = new BookAdapter(MainActivity.this, books);

            //Find our book list setup in the XML
            ListView bookListView = (ListView) findViewById(R.id.list);

            bookListView.setAdapter(mAdapter);

        }
    }
}
