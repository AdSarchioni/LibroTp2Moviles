package com.movi.volver;

import java.io.Serializable;
import java.util.List;

public class Libro implements Serializable {

    private String titulo;
    private String autor;
    private int nPaginas;
    private int anio_publicacion;
    private List<String>categoria ;
    private String descripcion;
    private int imagen;

    public Libro(String titulo, String autor, int nPaginas, int anio_publicacion, List<String> categoria, String descripcion, int imagen) {
        this.titulo = titulo;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.anio_publicacion = anio_publicacion;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public List<String> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<String> categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
