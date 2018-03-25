package com.example.fauricio.topmovies;

import android.graphics.Bitmap;

/**
 * Created by fauricio on 24/03/18.
 */

public class Pelicula {
    private String titulo;
    private String estrella;
    private String metascore;
    private Bitmap imagen;

    public Pelicula(String titulo, String estrella, String metascore, Bitmap imagen) {
        this.titulo = titulo;
        this.estrella = estrella;
        this.metascore = metascore;
        this.imagen = imagen;
    }

    public Pelicula(String titulo, String estrella, String metascore) {
        this.titulo = titulo;
        this.estrella = estrella;
        this.metascore = metascore;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstrella() {
        return estrella;
    }

    public void setEstrella(String estrella) {
        this.estrella = estrella;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }
}
