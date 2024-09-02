package com.movi.volver;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.movi.volver.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

private MainActivityViewModel vm;
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        setContentView(binding.getRoot());


        vm.getmMensaje().observe(this, new Observer<String>() {
           @Override
           public void onChanged(String s) {
               binding.tvError.setText(s);
           }
       });


        binding.btBuscar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String titulo = binding.etIngresarLibro.getText().toString();
        vm.enviarTitulo(titulo);
    }
});



    }
}