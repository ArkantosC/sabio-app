package org.sabio.sabioapp.repository.impl;

import android.util.Log;

import org.sabio.sabioapp.domain.model.Trivia;
import org.sabio.sabioapp.helpers.RetrofitSingleton;
import org.sabio.sabioapp.repository.IBaseRepository;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by diegocortes on 12/20/17.
 */

public class TriviaRepository implements IBaseRepository {

    public interface TriviaService {

        @PUT("trivias/{id}.json")
        Call<Trivia> insert(@Path("id") Long id, @Body Trivia trivia);

        @PATCH("trivias/{id}.json")
        Call<Trivia> update(@Path("id") Long id, @Body Trivia trivia);

        @DELETE("trivias/{id}.json")
        Call<Trivia> delete(@Path("id") Long id);

        @GET("trivias.json")
        Call<List<Trivia>> getAll();

    }


    @Override
    public Long insert(Object entity) {
        return null;
    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public List<Trivia> getAll() {

        try {
            Retrofit retrofit = RetrofitSingleton.getInstance();
            TriviaService service = retrofit.create(TriviaService.class);
            Call<List<Trivia>> call = service.getAll();
            Response<List<Trivia>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            Log.d(TriviaRepository.class.toString(), e.getMessage());
        }
        return null;

    }

    @Override
    public List getById(Long id) {
        return null;
    }
}
