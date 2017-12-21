package org.sabio.sabioapp.domain.model;

import android.support.annotation.NonNull;

/**
 * Created by diegocortes on 12/20/17.
 */

public class Trivia implements Comparable<Trivia>{

    String id;
    String code;
    String league;
    String pregunta;
    String respuesta;

    public Trivia(){}

    public Trivia(String code, String league, String pregunta, String respuesta) {
        this.code = code;
        this.league = league;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(@NonNull Trivia anotherTrivia) {
        return anotherTrivia.getCode().compareTo(this.getCode());
    }
}
