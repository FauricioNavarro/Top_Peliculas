package com.example.fauricio.topmovies;

import android.os.AsyncTask;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by fauricio on 21/03/18.
 */

public class DownloadTask extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... urls) {
        try {
            String resultado="";
            URL url = new URL(urls[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            int i = 0;
            int data = inputStream.read();
            while(data != -1){
                if(i==210000){
                    break;
                }
                char caracter = (char)data;
                resultado += caracter;
                i++;
                data = inputStreamReader.read();
            }
            return resultado;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
