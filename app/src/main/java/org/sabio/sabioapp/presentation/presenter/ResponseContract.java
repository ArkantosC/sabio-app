package org.sabio.sabioapp.presentation.presenter;

import org.sabio.sabioapp.domain.model.Position;

import java.util.List;

/**
 * Created by jhonlp on 21/12/2017.
 */

public interface ResponseContract {

    interface View {

        void showMessageError(Exception error);
    }

    interface UserActionListener {

        void loadResponse();

        List<Position> listPositions(String codeLeague);
    }
}
