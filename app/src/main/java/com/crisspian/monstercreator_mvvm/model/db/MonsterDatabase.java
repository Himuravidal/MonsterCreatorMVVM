package com.crisspian.monstercreator_mvvm.model.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.crisspian.monstercreator_mvvm.model.Monster;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Monster.class}, version = 1, exportSchema = false)
public abstract class MonsterDatabase extends RoomDatabase {

    public abstract MonsterDao monsterDao();

    public static volatile MonsterDatabase INSTANCE;
    public static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MonsterDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (MonsterDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MonsterDatabase.class, "monster_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
