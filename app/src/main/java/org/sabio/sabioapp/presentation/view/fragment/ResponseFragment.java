package org.sabio.sabioapp.presentation.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.sabio.sabioapp.R;
import org.sabio.sabioapp.domain.model.Position;
import org.sabio.sabioapp.presentation.presenter.AskContract;
import org.sabio.sabioapp.presentation.presenter.ResponseContract;
import org.sabio.sabioapp.presentation.presenter.ResponsePresenter;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jhonlp on 21/12/2017.
 */

public class ResponseFragment extends BaseFragment implements ResponseContract.View, View.OnClickListener {

    private ResponseContract.UserActionListener mActionListener;
    TableLayout tabla;
    TableLayout cabecera;
    TableRow.LayoutParams layoutFila;
    TableRow.LayoutParams layoutPosicion;
    TableRow.LayoutParams layoutEquipo;
    TableRow.LayoutParams layoutPTOS;
    private TextView tvQualificationMessage;

    private String leagueStr;
    private String teamStr;

    public ResponseFragment() {
        // Required empty public constructor
    }


    public static ResponseFragment getInstance() {
        return new ResponseFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_response, container, false);

        mActionListener = new ResponsePresenter(this);

        tabla = view.findViewById(R.id.cabecera) ;
        cabecera = (TableLayout) view.findViewById(R.id.cabecera);
        layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        layoutPosicion = new TableRow.LayoutParams(70,TableRow.LayoutParams.WRAP_CONTENT);
        layoutEquipo = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        layoutPTOS = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        tvQualificationMessage = view.findViewById(R.id.tvQualificationMessage);

        mActionListener.loadResponse();

        agregarCabecera();
        agregarFilasTabla();

        return view;
    }

    public void agregarCabecera(){
        TableRow fila = new TableRow(getActivity());
        TextView txtPosicion;
        TextView txtPtos;
        TextView txtEquipo;

       // fila =
        fila.setLayoutParams(layoutFila);

        txtPosicion = new TextView(getActivity());
        txtEquipo = new TextView(getActivity());
        txtPtos = new TextView(getActivity());

        txtPosicion.setText("Posición");
        txtPosicion.setGravity(Gravity.CENTER_HORIZONTAL);
        //txtId.setTextAppearance(this,R.style.etiqueta);
        //txtId.setBackgroundResource(R.drawable.tabla_celda_cabecera);
        txtPosicion.setLayoutParams(layoutPosicion);

        txtEquipo.setText("Equipo");
        txtEquipo.setGravity(Gravity.CENTER_HORIZONTAL);
       // txtNombre.setTextAppearance(this,R.style.etiqueta);
        //txtNombre.setBackgroundResource(R.drawable.tabla_celda_cabecera);
        txtEquipo.setLayoutParams(layoutEquipo);

        txtPtos.setText("PTS");
        txtPtos.setGravity(Gravity.CENTER_HORIZONTAL);
        // txtNombre.setTextAppearance(this,R.style.etiqueta);
        //txtNombre.setBackgroundResource(R.drawable.tabla_celda_cabecera);
        txtPtos.setLayoutParams(layoutPTOS);

        fila.addView(txtPosicion);
        fila.addView(txtEquipo);
        fila.addView(txtPtos);
        cabecera.addView(fila);
    }

    public void agregarFilasTabla(){

        List<Position> positionList = mActionListener.listPositions(getLeagueStr());
        willTeamQualification(positionList);


        int MAX_FILAS = positionList.size(); //este se lee de la cantidad de datos que tenga la tabla

        for(int i = 0;i<MAX_FILAS;i++){

            TableRow fila = new TableRow(getActivity());
            TextView txtPosicion;
            TextView txtPtos;
            TextView txtEquipo;

            Position position = positionList.get(i);

            int posicion = i + 1;

            fila.setLayoutParams(layoutFila);

            txtPosicion = new TextView(getActivity());
            txtEquipo = new TextView(getActivity());
            txtPtos = new TextView(getActivity());

            txtPosicion.setText(String.valueOf(posicion));
            txtPosicion.setGravity(Gravity.CENTER_HORIZONTAL);
           // txtPosicion.setTextAppearance(this,R.style.etiqueta);
            //txtPosicion.setBackgroundResource(R.drawable.tabla_celda);
            txtPosicion.setLayoutParams(layoutPosicion);

            txtEquipo.setText(position.getName());
            txtEquipo.setGravity(Gravity.CENTER_HORIZONTAL);
           // txtEquipo.setTextAppearance(this,R.style.etiqueta);
            //txtEquipo.setBackgroundResource(R.drawable.tabla_celda);
            txtEquipo.setLayoutParams(layoutEquipo);

            txtPtos.setText(position.getScore());
            txtEquipo.setGravity(Gravity.CENTER_HORIZONTAL);
            // txtEquipo.setTextAppearance(this,R.style.etiqueta);
            //txtEquipo.setBackgroundResource(R.drawable.tabla_celda);
            txtEquipo.setLayoutParams(layoutPTOS);

            
            fila.addView(txtPosicion);
            fila.addView(txtEquipo);
            fila.addView(txtPtos);

            /*
            if (fila.getParent() != null) {
                ((ViewGroup)fila.getParent()).removeView(fila);
            }
            */
            tabla.addView(fila);
        }
    }

    private void willTeamQualification(List<Position> positionList) {

        String message = null;
        for (Position pos: positionList)
        {
            if (pos.getCode().equals(teamStr))
            {
                if (pos.getPosition().equals("1")) {
                    message = String.format("El %s SI clasificará", pos.getName());
                    tvQualificationMessage.setTextColor(Color.WHITE);
                    tvQualificationMessage.setBackgroundColor(Color.GREEN);
                }else {
                    message = String.format("El %s NO clasificará", pos.getName());
                    tvQualificationMessage.setTextColor(Color.WHITE);
                    tvQualificationMessage.setBackgroundColor(Color.RED);
                }
            }
        }

        tvQualificationMessage.setText(message);


    }

    public String getLeagueStr() {
        return leagueStr;
    }

    public void setLeagueStr(String leagueStr) {
        this.leagueStr = leagueStr;
    }

    public String getTeamStr() {
        return teamStr;
    }

    public void setTeamStr(String teamStr) {
        this.teamStr = teamStr;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void showMessageError(Exception error) {

    }
}
