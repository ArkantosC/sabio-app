package org.sabio.sabioapp.domain.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by diegocortes on 12/14/17.
 */

@Entity(foreignKeys = {
        @ForeignKey(
                entity = League.class,
                parentColumns = "league_id",
                childColumns = "tbl_league_id"
        )
})
public class Team {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="team_id")
    private Long id;
    private String name;
    @ColumnInfo(name="tbl_league_id")
    private Long legueId;

    public Team(String name, Long legueId) {
        this.name = name;
        this.legueId = legueId;
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

    public Long getLegueId() {
        return legueId;
    }

    public void setLegueId(Long legueId) {
        this.legueId = legueId;
    }
}
