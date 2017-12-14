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
                parentColumns = "",
                childColumns = ""
        )
})
public class League {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="league_id")
    private int id;
    private int name;
    private int countryId;

}
