package org.sabio.sabioapp.presentation.view.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.sabio.sabioapp.R;
import org.sabio.sabioapp.presentation.presenter.AskContract;
import org.sabio.sabioapp.presentation.presenter.ResponseContract;

/**
 * Created by jhonlp on 21/12/2017.
 */

public class ResponseFragment extends BaseFragment implements ResponseContract.View, View.OnClickListener {


    TableLayout tabla;
    TableLayout cabecera;
    TableRow.LayoutParams layoutFila;
    TableRow.LayoutParams layoutPosicion;
    TableRow.LayoutParams layoutEquipo;
    TableRow.LayoutParams layoutPTOS;

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

        tabla = view.findViewById(R.id.cabecera) ;
        cabecera = (TableLayout) view.findViewById(R.id.cabecera);
        layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        layoutPosicion = new TableRow.LayoutParams(70,TableRow.LayoutParams.WRAP_CONTENT);
        layoutEquipo = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        layoutPTOS = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        agregarCabecera();
        agregarFilasTabla();
    return view;

    }


    public void agregarCabecera(){
        TableRow fila = new TableRow(getView().getContext());
        TextView txtPosicion;
        TextView txtPtos;
        TextView txtEquipo;

       // fila =
        fila.setLayoutParams(layoutFila);

        txtPosicion = new TextView(getView().getContext());
        txtEquipo = new TextView(getView().getContext());
        txtPtos = new TextView(getView().getContext());

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



        txtEquipo.setText("PTS");
        txtEquipo.setGravity(Gravity.CENTER_HORIZONTAL);
        // txtNombre.setTextAppearance(this,R.style.etiqueta);
        //txtNombre.setBackgroundResource(R.drawable.tabla_celda_cabecera);
        txtEquipo.setLayoutParams(layoutPTOS);

        fila.addView(txtPosicion);
        fila.addView(txtEquipo);
        fila.addView(txtPtos);
        cabecera.addView(fila);
    }


    public void agregarFilasTabla(){

        TableRow fila = new TableRow(getView().getContext());
        TextView txtPosicion;
        TextView txtPtos;
        TextView txtEquipo;
        int MAX_FILAS = 10; //este se lee de la cantidad de datos que tenga la tabla

        for(int i = 0;i<MAX_FILAS;i++){
            int posicion = i + 1;

            fila.setLayoutParams(layoutFila);

            txtPosicion = new TextView(getView().getContext());
            txtEquipo = new TextView(getView().getContext());
            txtPtos = new TextView(getView().getContext());

            txtPosicion.setText(String.valueOf(posicion));
            txtPosicion.setGravity(Gravity.CENTER_HORIZONTAL);
           // txtPosicion.setTextAppearance(this,R.style.etiqueta);
            //txtPosicion.setBackgroundResource(R.drawable.tabla_celda);
            txtPosicion.setLayoutParams(layoutPosicion);

            txtEquipo.setText("Texto "+posicion);
            txtEquipo.setGravity(Gravity.CENTER_HORIZONTAL);
           // txtEquipo.setTextAppearance(this,R.style.etiqueta);
            //txtEquipo.setBackgroundResource(R.drawable.tabla_celda);
            txtEquipo.setLayoutParams(layoutEquipo);

            txtPtos.setText("Texto puntos "+posicion);
            txtEquipo.setGravity(Gravity.CENTER_HORIZONTAL);
            // txtEquipo.setTextAppearance(this,R.style.etiqueta);
            //txtEquipo.setBackgroundResource(R.drawable.tabla_celda);
            txtEquipo.setLayoutParams(layoutPTOS);

            
            fila.addView(txtPosicion);
            fila.addView(txtEquipo);
            fila.addView(txtPtos);

            tabla.addView(fila);
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void showMessageError(Exception error) {

    }
}
