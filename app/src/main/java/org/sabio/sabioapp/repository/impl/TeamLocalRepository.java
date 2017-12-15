package org.sabio.sabioapp.repository.impl;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.sabio.sabioapp.database.SabioDatabase;
import org.sabio.sabioapp.domain.model.entities.Team;
import org.sabio.sabioapp.repository.ITeamRepository;

import java.util.List;

/**
 * Created by dcortez on 12/15/2017.
 */

public class TeamLocalRepository implements ITeamRepository {

    @Dao
    public interface TeamDao {

        @Insert
        Long insert(Team team);

        @Update
        void update(Team team);

        @Delete
        void delete(Team team);

        @Query("select * from Team")
        List<Team> getAll();

        @Query("select * from Team where team_id = :id")
        List<Team> getById(Long id);

        @Query("select * from League where tbl_league_id = :leagueId")
        List<Team> getByLeague(Long leagueId);
    }

    @Override
    public Long insert(Object entity) {
        TeamLocalRepository.TeamDao sabioDao = SabioDatabase.getInstance().teamDao();
        return sabioDao.insert((Team)entity);
    }

    @Override
    public void update(Object entity) {
        TeamLocalRepository.TeamDao sabioDao = SabioDatabase.getInstance().teamDao();
        sabioDao.update((Team)entity);
    }

    @Override
    public void delete(Object entity) {
        TeamLocalRepository.TeamDao sabioDao = SabioDatabase.getInstance().teamDao();
        sabioDao.delete((Team)entity);
    }

    @Override
    public List<Team> getAll() {
        TeamLocalRepository.TeamDao sabioDao = SabioDatabase.getInstance().teamDao();
        return sabioDao.getAll();
    }

    @Override
    public List<Team> getById(Long id) {
        TeamLocalRepository.TeamDao sabioDao = SabioDatabase.getInstance().teamDao();
        return sabioDao.getById(id);
    }

    @Override
    public List<Team> getByLeague(Long leagueId) {
        TeamLocalRepository.TeamDao sabioDao = SabioDatabase.getInstance().teamDao();
        return sabioDao.getByLeague(leagueId);
    }
}
