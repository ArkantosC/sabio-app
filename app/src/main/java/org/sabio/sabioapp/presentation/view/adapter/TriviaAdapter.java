package org.sabio.sabioapp.presentation.view.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import org.sabio.sabioapp.R;
import org.sabio.sabioapp.domain.model.Trivia;
import org.sabio.sabioapp.domain.model.entities.Team;

import java.util.List;

/**
 * Created by diegocortes on 12/20/17.
 */

public class TriviaAdapter extends RecyclerView.Adapter<TriviaAdapter.TeamHolder> {

    public interface OnTriviaItemStatusChangeListener {
        void onTriviaItemStatusChange(int position, boolean selected);
    }

    private List<Team> dataSet;
    public Trivia trivia;
    private OnTriviaItemStatusChangeListener onTriviaItemStatusChangeListener;

    public TriviaAdapter(List<Team> dataSet, Trivia trivia, OnTriviaItemStatusChangeListener onTriviaItemStatusChangeListener) {
        this.dataSet = dataSet;
        this.trivia = trivia;
        this.onTriviaItemStatusChangeListener = onTriviaItemStatusChangeListener;
    }

    @Override
    public TeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_trivia_item, parent, false);
        return new TeamHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamHolder holder, int position) {
        Team team = dataSet.get(position);

        holder.cbAnswer.setText(team.getName());

        if (holder.cbAnswer.isChecked()) {

            if (trivia.getRespuesta().equals(team.getCode())) {
                holder.cbAnswer.setBackgroundColor(Color.GREEN);
                holder.cbAnswer.setTextColor(Color.WHITE);
            } else {
                holder.cbAnswer.setBackgroundColor(Color.RED);
                holder.cbAnswer.setTextColor(Color.WHITE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public class TeamHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public CheckBox cbAnswer;

        public TeamHolder(View itemView) {
            super(itemView);
            cbAnswer = itemView.findViewById(R.id.cbAnswer);

            if (onTriviaItemStatusChangeListener != null) {
                cbAnswer.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            onTriviaItemStatusChangeListener.onTriviaItemStatusChange(position, cbAnswer.isChecked());
        }
    }

}
