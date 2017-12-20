package org.sabio.sabioapp.domain.usecase;

import android.telecom.Call;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.helpers.Callback;

import java.util.List;

/**
 * Created by diegocortes on 12/18/17.
 */

public interface ICountryRestUseCase {
    void insert(Country country, Callback<Country> callback);
    void getAll(Callback<List<Country>> callback);
}
