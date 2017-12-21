package org.sabio.sabioapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.sabio.sabioapp.R;
import org.sabio.sabioapp.domain.model.Trivia;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.presentation.presenter.TriviaListContract;
import org.sabio.sabioapp.presentation.presenter.TriviaListPresenter;
import org.sabio.sabioapp.presentation.view.adapter.TriviaAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TriviaListFragment extends Fragment implements TriviaListContract.View, TriviaAdapter.OnTriviaItemStatusChangeListener, View.OnClickListener {

    private TriviaListContract.UserActionListener mActionListener;
    private RecyclerView rvTriviaList;
    private TextView tvQuestion;
    private TextView tvScore;
    private int contador;
    private Button btnNextQuestion;

    public TriviaListFragment() {
        // Required empty public constructor
    }

    public static TriviaListFragment getInstance() {
        return new TriviaListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_trivia, container, false);

        mActionListener = new TriviaListPresenter(this);

        rvTriviaList = view.findViewById(R.id.rvTriviaList);
        tvScore = view.findViewById(R.id.tvScore);
        tvQuestion = view.findViewById(R.id.tvQuestion);
        btnNextQuestion = view.findViewById(R.id.btnNextQuestion);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        rvTriviaList.setLayoutManager(layoutManager);

        mActionListener.loadTriviaAll();
        setupTrivia();
        contador = 0;

        btnNextQuestion.setOnClickListener(this);

        return view;
    }

    private void setupTrivia() {

        List<Trivia> triviaList = mActionListener.getListTrivia();
        Trivia trivia = triviaList.get(0);
        mActionListener.loadLeague(trivia.getCode());

        String question = String.format(trivia.getPregunta(), mActionListener.league().getName());
        tvQuestion.setText(question);
        mActionListener.loadTeamByLeague(trivia.getLeague());

        TriviaAdapter adapter = new TriviaAdapter(mActionListener.getListTeam(), trivia, this);

        rvTriviaList.setAdapter(adapter);
    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG);
    }

    @Override
    public void refreshTrivia() {
        rvTriviaList.getAdapter().notifyDataSetChanged();

        if (mActionListener.isCorrect()) {
            Toast.makeText(getContext(), "CORRECTO", Toast.LENGTH_LONG).show();
            contador = contador + 5;
            tvScore.setText(""+contador);
        } else {
            Toast.makeText(getContext(), "INCORRECTO", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onTriviaItemStatusChange(int position, boolean selected) {
        mActionListener.updateStatusTodo(position, selected);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNextQuestion:
                 mActionListener.nextQuestion();
                if (mActionListener.getListTrivia().size() > 0)
                {
                    setupTrivia();
                    rvTriviaList.getAdapter().notifyDataSetChanged();
                } else {
                    btnNextQuestion.setText("TERMINADO!");
                    btnNextQuestion.setEnabled(false);
                }
                break;

        }
    }
}
