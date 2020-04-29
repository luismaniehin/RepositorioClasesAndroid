package com.example.nh.lab009.utilities;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {

    final static String GITHUB_BASE_URL = "https://api.github.com/search/repositories";
    final static String PARAM_QUERY = "q";
    final static String PARAM_SORT = "sort";
    final static String sortBy = "stars";

    public static URL buildUrl(String query){
        Uri loBuiltUri = Uri.parse(GITHUB_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY, query)
                .appendQueryParameter(PARAM_SORT, sortBy)
                .build();

        URL loUrl = null;

        try {
            loUrl = new URL(loBuiltUri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        return loUrl;
    }

    public static String getResponseFromHttpUrl(URL toUrl) throws IOException{
        HttpURLConnection loURLConnection = (HttpURLConnection) toUrl.openConnection();

        try{
            InputStream loInput = loURLConnection.getInputStream();

            Scanner loScanner = new Scanner(loInput);
            loScanner.useDelimiter("\\A");

            boolean llHasInput = loScanner.hasNext();

            if(llHasInput){
                return loScanner.next();
            } else {
                return null;
            }
        } finally {
            loURLConnection.disconnect();
        }
    }
}
