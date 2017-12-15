package org.sabio.sabioapp.helpers;

/**
 * Created by dcortez on 12/14/2017.
 */

public interface Callback<T> {
    void success(T result);
    void error(Exception error);
}
