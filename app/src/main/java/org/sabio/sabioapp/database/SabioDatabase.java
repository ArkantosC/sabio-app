package org.sabio.sabioapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import org.sabio.sabioapp.domain.model.entities.Country;
import org.sabio.sabioapp.domain.model.entities.League;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.repository.impl.CountryLocalRepository;
import org.sabio.sabioapp.repository.impl.LeagueLocalRepository;
import org.sabio.sabioapp.repository.impl.SabioLocalRepository;
import org.sabio.sabioapp.repository.impl.TeamLocalRepository;

/**
 * Created by dcortez on 12/14/2017.
 */

@Database(entities = {Country.class, League.class, Team.class}, version = 1)
public abstract class SabioDatabase extends RoomDatabase {

    private static SabioDatabase db;

    public static void init(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context.getApplicationContext(), SabioDatabase.class, "sabio-app").build();
        }
    }

    public static SabioDatabase getInstance() {
        return db;
    }

    public abstract CountryLocalRepository.CountryDao countryDao();

    public abstract LeagueLocalRepository.LeagueDao leagueDao();

    public abstract TeamLocalRepository.TeamDao teamDao();

    public static void setInjectedInstance(SabioDatabase injectedDb) {
        db = injectedDb;
    }

}
