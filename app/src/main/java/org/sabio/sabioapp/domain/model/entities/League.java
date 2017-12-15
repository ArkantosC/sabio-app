package org.sabio.sabioapp.domain.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by dcortez on 12/14/2017.
 */
@Entity(foreignKeys = {
        @ForeignKey(
                entity = Country.class,
                parentColumns = "country_id",
                childColumns = "tbl_country_id"
        )
})
public class League {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="league_id")
    private int id;
    private int name;
    @ColumnInfo(name="tbl_country_id")
    private int countryId;

    public League(int name, int countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
