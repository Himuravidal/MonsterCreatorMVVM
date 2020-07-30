package com.crisspian.monstercreator_mvvm.viewmodel;

import android.app.Application;
import android.util.Log;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.crisspian.monstercreator_mvvm.model.AttributeStore;
import com.crisspian.monstercreator_mvvm.model.AttributeType;
import com.crisspian.monstercreator_mvvm.model.Monster;
import com.crisspian.monstercreator_mvvm.model.MonsterAttributes;
import com.crisspian.monstercreator_mvvm.model.MonsterGenerator;
import com.crisspian.monstercreator_mvvm.model.repository.MonsterRepository;
import com.crisspian.monstercreator_mvvm.model.repository.RepositoryInterface;

public class ViewModelCreateMonster extends AndroidViewModel {

    private MonsterGenerator monsterGenerator;
    private MonsterRepository monsterRepository;
    private Monster monster;
    private String name = "";
    private int intelligence = 0;
    private int ugliness = 0;
    private int evilness = 0;
    int drawable = 0;
    private MutableLiveData<Monster> mutableMonsterLiveData;
    private MutableLiveData<Boolean> saveLiveData;

    public ViewModelCreateMonster(@NonNull Application application) {
        super(application);
        mutableMonsterLiveData = new MutableLiveData<>();
        saveLiveData = new MutableLiveData<>();
        monsterRepository = new MonsterRepository(application);
    }
    //this will return the monsterLiveData to observe on secondFragment
    public LiveData<Monster> monsterLive() { return mutableMonsterLiveData; }

    //this obtain the data, create the monster and update the live data monster object.
    public void updateMonster() {
        MonsterAttributes monsterAttributes = new MonsterAttributes(intelligence, ugliness, evilness);
        monster = MonsterGenerator.monsterGenerate(monsterAttributes, name, drawable);
        mutableMonsterLiveData.setValue(monster);
    }

    public void drawableSelect(int drawable) {
        this.drawable = drawable;
        updateMonster();
    }

    public void nameInsert(String name) {
        this.name = name;
        updateMonster();
    }

    public void attributeSelected(AttributeType attributeType,int position) {
        switch (attributeType) {
            case INTELLIGENCE:
                intelligence = AttributeStore.getIntelligenceAttributeValues().get(position).getValue();
            case EVILNESS:
                evilness = AttributeStore.getEvilnessValue().get(position).getValue();
            case UGLINESS:
                ugliness = AttributeStore.getUglinessAttributeValues().get(position).getValue();
        }
        updateMonster();
    }



    public void saveMonster() {
        monsterRepository.saveMonster(monster);
        drawable = 0;
        saveLiveData.setValue(true);
    }



}
