package com.example.fauricio.topmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity{
    private GridView gridView;
    private ArrayList<Pelicula> ArrayItem = null;
    private GridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.LV_items);
        DownloadTask downloadTask = new DownloadTask();
        try {
            String html = downloadTask.execute("http://www.imdb.com/list/ls064079588/").get();
            Document doc = Jsoup.parse(html);
            Elements titulos = doc.select("div .lister-item-content h3 a");
            Elements estrellas = doc.select("div .inline-block strong");
            Elements metascores = doc.select("div .inline-block.ratings-metascore span");
            Elements portadas = doc.select("div .lister-item-image a img");
            for(int i = 0 ; i < 21;i++){
                Log.i("t->",titulos.get(i).text());
                Log.i("e->",estrellas.get(i).text());
                Log.i("m->",metascores.get(i).text());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }



}