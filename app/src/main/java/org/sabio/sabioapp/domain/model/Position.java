package org.sabio.sabioapp.domain.model;

import android.support.annotation.NonNull;

/**
 * Created by diegocortes on 12/21/17.
 */

public class Position {

    String id;
    String code;
    String league;
    String name;
    String position;
    String score;

    public Position(){}

    public Position(String code, String league, String name, String position, String score) {
        this.code = code;
        this.league = league;
        this.name = name;
        this.position = position;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
