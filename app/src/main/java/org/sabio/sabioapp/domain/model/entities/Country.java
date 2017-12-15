package org.sabio.sabioapp.domain.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by dcortez on 12/14/2017.
 */

@Entity
public class Country {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="country_id")
    private Long id;
    private String name;

    public Country(String name) {
        this.name = name;
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
}
