package com.crisspian.monstercreator_mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.crisspian.monstercreator_mvvm.model.Monster;
import com.crisspian.monstercreator_mvvm.model.repository.MonsterRepository;
import com.crisspian.monstercreator_mvvm.model.repository.RepositoryInterface;

import java.util.List;

public class AllMonsterViewModel extends AndroidViewModel {
    private MonsterRepository monsterRepository;
    private LiveData<List<Monster>> listLiveData;

    public AllMonsterViewModel(@NonNull Application application) {
        super(application);
        monsterRepository = new MonsterRepository(application);
        listLiveData = monsterRepository.getAllMonster();
    }

    public LiveData<List<Monster>> getListLiveData() {
        return  listLiveData;
    }

}
