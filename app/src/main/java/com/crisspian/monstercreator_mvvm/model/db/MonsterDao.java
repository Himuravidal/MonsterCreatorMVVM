package com.crisspian.monstercreator_mvvm.model.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.crisspian.monstercreator_mvvm.model.Monster;

import java.util.List;

@Dao
public interface MonsterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMonster(Monster monster);

    @Query("SELECT * FROM monster_table ORDER BY name ASC")
    LiveData<List<Monster>> getAllMonster();

    @Query("DELETE FROM monster_table")
    void deleteAllMonster();
}
