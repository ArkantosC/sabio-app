package org.sabio.sabioapp.io;

import android.util.Log;


import org.sabio.sabioapp.model.Torneo;
import org.sabio.sabioapp.model.TorneoDetalle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by jhonlp on 15/12/2017.
 */

public class CallbackRest implements retrofit2.Callback<ArrayList<TorneoDetalle>>{


    @Override
    public void onResponse(Call <ArrayList<TorneoDetalle>> call, Response<ArrayList<TorneoDetalle>> response) {
        int id = 0;
        if(response.isSuccessful()){
            ArrayList<TorneoDetalle> torneos = response.body();

                TorneoDetalle torneo1 = torneos.get(1);
                id = torneo1.getTorneoDetalleId();
                Torneo tor =torneo1.getTorneo();
                id = tor.getTorneoId();



            Log.d("respuesta","tamaño de la respuesta"+ torneos.size() + "primer id del torneo 1 " + id );
        }

    }

    @Override
    public void onFailure(Call call, Throwable t) {



    }
}
