package com.movi.volver;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private List<String>titulos;
    private MutableLiveData<String>mMensaje;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<String>getmMensaje(){
        if(mMensaje==null){
            mMensaje=new MutableLiveData<>();
        }
        return mMensaje;
    }
    public void enviarTitulo(String titulo){
        if(titulo.isEmpty())
        {
        mMensaje.setValue("no escribio ningun titulo");
        }else {
            Intent intent = new Intent(getApplication(), LibroActivity.class);
            intent.putExtra("titulo",titulo);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
        }
}


}
