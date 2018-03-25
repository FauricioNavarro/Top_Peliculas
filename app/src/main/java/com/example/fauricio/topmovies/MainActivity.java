package com.example.fauricio.topmovies;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity{
    private GridView gridView;
    private ArrayList<Pelicula> ArrayItem = null;
    private GridViewAdapter adapter;
    private ImageDownloadTask imageDownloadTask;
    private String metascore_aux,estrella_aux;
    private DownloadTask downloadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.LV_items);
        ArrayItem = new ArrayList<>();
        downloadTask = new DownloadTask();
        try {
            String html = downloadTask.execute("http://www.imdb.com/list/ls064079588/").get();
            Document doc = Jsoup.parse(html);
            Elements titulos = doc.select("div .lister-item-content h3 a");
            Elements estrellas = doc.select("div .inline-block strong");
            Elements metascores = doc.select("div .inline-block.ratings-metascore span");
            Elements imagenes = doc.select("div .lister-item-image a img");
            for(int i = 0 ; i < 20;i++){
                estrella_aux = "★ "+ estrellas.get(i).text();
                metascore_aux = "Metascore: "+metascores.get(i).text();
                imageDownloadTask = new ImageDownloadTask();
                Bitmap imagen = imageDownloadTask.execute(imagenes.get(i).attr("loadlate")).get();
                ArrayItem.add(new Pelicula(titulos.get(i).text(),estrella_aux,metascore_aux,imagen));
                adapter = new GridViewAdapter(ArrayItem, this);
                gridView.setAdapter(adapter);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }



}