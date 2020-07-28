package com.crisspian.monstercreator_mvvm.model.repository;

import androidx.lifecycle.LiveData;

import com.crisspian.monstercreator_mvvm.model.Monster;

import java.util.List;

public interface RepositoryInterface {
    void saveMonster(Monster monster);
    LiveData<List<Monster>> getAllMonster();
    void clearAllMonster();
}
