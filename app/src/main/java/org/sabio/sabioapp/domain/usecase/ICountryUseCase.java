package org.sabio.sabioapp.domain.usecase;

import android.telecom.Call;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.helpers.Callback;

import java.util.List;

/**
 * Created by diegocortes on 12/15/17.
 */

public interface ICountryUseCase {
    void insert(Country country, Callback<Country> callback);
    void update(Country country, Callback<Country> callback);
    void delete(Country country, Callback<Boolean> callback);
    void getAll(Callback<List<Country>> callback);
    void getById(Long id, Callback<List<Country>> callback);
}
