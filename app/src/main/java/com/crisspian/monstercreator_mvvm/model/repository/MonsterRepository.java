package com.crisspian.monstercreator_mvvm.model.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.crisspian.monstercreator_mvvm.model.Monster;
import com.crisspian.monstercreator_mvvm.model.db.MonsterDao;
import com.crisspian.monstercreator_mvvm.model.db.MonsterDatabase;

import java.util.List;

public class MonsterRepository implements RepositoryInterface {

    private MonsterDao monsterDao;
    private LiveData<List<Monster>> monsterLivedataList;

    public MonsterRepository(Application application) {
        MonsterDatabase db = MonsterDatabase.getDatabase(application);
        monsterDao = db.monsterDao();
        monsterLivedataList = monsterDao.getAllMonster();
    }

    @Override
    public void saveMonster(final Monster monster) {
        MonsterDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                monsterDao.insertMonster(monster);
            }
        });
    }

    @Override
    public LiveData<List<Monster>> getAllMonster() {
        return monsterLivedataList;
    }

    @Override
    public void clearAllMonster() {
        MonsterDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                monsterDao.deleteAllMonster();
            }
        });
    }
}
