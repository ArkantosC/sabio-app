package org.sabio.sabioapp.domain.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by dcortez on 12/14/2017.
 */
@Entity
public class League {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String code;
    private String name;
    private String countryId;

    public League(String code, String name, String countryId) {
        this.code = code;
        this.name = name;
        this.countryId = countryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return name;
    }
}
