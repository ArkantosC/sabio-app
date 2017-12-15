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
    private Long id;
    private String name;
    @ColumnInfo(name="tbl_country_id")
    private Long countryId;

    public League(String name, Long countryId) {
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

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
