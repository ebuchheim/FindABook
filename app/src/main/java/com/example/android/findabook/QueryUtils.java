package com.example.android.findabook;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Emma Buchheim on 10/30/2017.
 */

public final class QueryUtils {

    private static String SAMPLE_JSON_RESPONSE = "";

    private static final String BASE_URL_STRING = "https://www.googleapis.com/books/v1/";

    private QueryUtils() {

    }

    public static ArrayList<Book> FetchBookData(String searchInputString) {
        URL url = createURL(searchInputString);
        String bookJSON = "";

        try {
            bookJSON = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e("QueryUtils", "An IOException was thrown in FetchBookData");
        }

        return parseBooks(bookJSON);
    }

    private static String makeHttpRequest(URL url) throws IOException{
        String jsonResponse = "";
        if (url == null){
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try{
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000/* milliseconds */);
            urlConnection.setConnectTimeout(15000/* milliseconds */);
            urlConnection.connect();
            if(urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e("QueryUtils", "The response code wasn't 200" + url.toString());
            }
        } catch (IOException e){
            Log.e("QueryUtils", "This threw an IOException");
        } finally {
            if(urlConnection != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }


    private static URL createURL(String searchInput) {
        URL url = null;
        try {
            URL base_url = new URL(BASE_URL_STRING);
            url = new URL(base_url, "volumes?q=" + searchInput);
        } catch (MalformedURLException exception) {
            Log.e("QueryUtils", "Error with creating URL", exception);
        }
        return url;
    }


    private static ArrayList<Book> parseBooks(String bookJSON) {


        //if the JSON string is empty or null, return early
        if (TextUtils.isEmpty(bookJSON)) {
            return null;
        }

        //Create an array list of books that we can add new books
        ArrayList<Book> books = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(bookJSON);
            JSONArray bookItems = root.getJSONArray("items");

            for (int i = 0; i < bookItems.length(); i++) {
                JSONObject bookItem = bookItems.getJSONObject(i);
                JSONObject bookVolumeInfo = bookItem.getJSONObject("volumeInfo");
                String bookTitle = bookVolumeInfo.getString("title");
                JSONArray bookAuthors = bookVolumeInfo.getJSONArray("authors");
                String bookURLString = bookVolumeInfo.getString("infoLink");
                String bookAuthorsString = "";
                for (int x = 0; x < bookAuthors.length() - 1; x++) {
                    bookAuthorsString += bookAuthors.getString(x) + ", ";
                }

                bookAuthorsString += bookAuthors.getString(bookAuthors.length() - 1);

                books.add(new Book(bookTitle, bookAuthorsString, bookURLString));
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the book JSON results", e);
        }

        return books;

    }

}
