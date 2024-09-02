package com.movi.volver;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.movi.volver.databinding.ActivityLibroBinding;
import com.movi.volver.databinding.ActivityMainBinding;

public class LibroActivity extends AppCompatActivity {

    private LibroActivityViewModel viewModeLibro;
    private ActivityLibroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ImageView imagen = findViewById(R.id.imageView);
        binding = ActivityLibroBinding.inflate(getLayoutInflater());
        viewModeLibro = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LibroActivityViewModel.class);

        setContentView(binding.getRoot());

        viewModeLibro.cargarLibro();

        viewModeLibro.getMutableLibro().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {

                    binding.tvTitulo.setText(libro.getTitulo());
                    binding.tvAutor.setText(libro.getAutor());
                    binding.tvNPaginas.setText(libro.getnPaginas()+"");
                    binding.tvAnioP.setText(libro.getAnio_publicacion()+"");
                    binding.tvGenero.setText(libro.getCategoria().toString());
                    binding.tvDescripcion.setText(libro.getDescripcion());
                    binding.imageView.setImageResource(libro.getImagen());

            }
        });
        viewModeLibro.getMutableMmensaje().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {
                binding.tvTitulo.setText(libro.getTitulo());
                binding.tvAutor.setText(libro.getAutor());
                binding.tvNPaginas.setText(libro.getnPaginas()+"");
                binding.tvAnioP.setText(libro.getAnio_publicacion()+"");
                binding.tvGenero.setText(libro.getCategoria().toString());
                binding.tvDescripcion.setText(libro.getDescripcion());
                binding.imageView.setImageResource(libro.getImagen());


            }
        });

        Intent intent = getIntent();
        viewModeLibro.buscarLibro(intent);

    }
}