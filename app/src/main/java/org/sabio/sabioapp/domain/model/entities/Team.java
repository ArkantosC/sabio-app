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
                parentColumns = "id",
                childColumns = "leagueId"
        )
})
public class Team {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    private Long leagueId;

    public Team(String name, Long leagueId) {
        this.name = name;
        this.leagueId = leagueId;
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

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long legueId) {
        this.leagueId = legueId;
    }
}
