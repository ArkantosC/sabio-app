package org.sabio.sabioapp.presentation.presenter;

import org.sabio.sabioapp.domain.model.Position;
import org.sabio.sabioapp.domain.usecase.IPositionUseCase;
import org.sabio.sabioapp.domain.usecase.impl.PositionUseCase;
import org.sabio.sabioapp.helpers.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhonlp on 21/12/2017.
 */

public class ResponsePresenter implements ResponseContract.UserActionListener {

    private ResponseContract.View view;
    private IPositionUseCase positionUseCase;
    private List<Position> positionList;
    private List<Position> allPositionList;

    public ResponsePresenter(ResponseContract.View view) {
        this.view = view;
        this.positionList = new ArrayList<>(0);
        this.allPositionList = new ArrayList<>(0);
        this.positionUseCase = new PositionUseCase();
    }

    @Override
    public void loadResponse() {

        positionUseCase.getAll(new Callback<List<Position>>() {
            @Override
            public void success(List<Position> result) {
                allPositionList.clear();
                allPositionList.addAll(result);
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }

    @Override
    public List<Position> listPositions(String codeLeague) {

        for (Position pos: allPositionList) {
            if (pos.getLeague().equals(codeLeague)) {
                positionList.add(pos);
            }
        }
        return positionList;
    }
}
