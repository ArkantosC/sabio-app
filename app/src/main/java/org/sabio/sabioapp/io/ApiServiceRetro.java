package org.sabio.sabioapp.io;



import org.sabio.sabioapp.model.TorneoDetalle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jhonlp on 15/12/2017.
 * esta clase hace los distintos llamados al servicio teniendo un metodo por cada url distitna asi completa la url dinamicamente
 * y le decimos que metodo debe usar para completar el llamado
 */
public interface ApiServiceRetro {

    @GET ("serviciosRest/torneos")
    Call <ArrayList<TorneoDetalle>> getTorneos();







}
