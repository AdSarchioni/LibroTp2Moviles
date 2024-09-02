package com.movi.volver;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibroActivityViewModel extends AndroidViewModel {
    private List<Libro> libros = new ArrayList<>();
    private MutableLiveData<Libro> mLibro;
    private MutableLiveData<Libro>mMensaje;
    private Libro libro;

    public LibroActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Libro> getMutableLibro() {
        if (mLibro == null) {
            mLibro = new MutableLiveData<>();
        }
        return mLibro;
    }
    public LiveData<Libro> getMutableMmensaje() {
        if (mMensaje == null) {
            mMensaje = new MutableLiveData<>();
        }
        return mMensaje;
    }





    public void cargarLibro() {

        libros.add(new Libro("El Hobbit","JRR.Tolkien",300,1937, Arrays.asList("fantasia","aventura"),"un libro  en ingles ", R.drawable.hobbit));
        libros.add(new Libro("Orgullo y Prejuicio","Jane Austen",260,1813,Arrays.asList("Novela Rosa","Romance","Sátira"),"obra anonima en ingles", R.drawable.orgullo));
        libros.add(new Libro("My Policeman","Robert Bethan",342,1979,Arrays.asList("Romance","Drama","Novela Rosa"),"una novela de romance....en ingles", R.drawable.policeman));
    }

    public void buscarLibro(Intent intent) {
         String titulo =intent.getStringExtra("titulo");
         if(titulo!=null){
             for (Libro libro: libros){
                 if(libro.getTitulo().equals(titulo)){
                     mLibro.setValue(libro);
                     return;
                 }
             }
             mMensaje.setValue(new Libro("El Libro no Esta","",0,0, Arrays.asList("No","Esta"),"usted no podra leer este libro por que no esta  ", R.drawable.danger));
         }
    }

}
