package com.crisspian.monstercreator_mvvm.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.crisspian.monstercreator_mvvm.model.db.MonsterAttributeConverter;

@Entity(tableName = "monster_table")
public class Monster {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String name;
    @TypeConverters(MonsterAttributeConverter.class)
    private MonsterAttributes monsterAttributes;
    private int monsterPoint;
    private int drawable;

    public Monster(String name, MonsterAttributes monsterAttributes, int monsterPoint, int drawable) {
        this.name = name;
        this.monsterAttributes = monsterAttributes;
        this.monsterPoint = monsterPoint;
        this.drawable = drawable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonsterAttributes getMonsterAttributes() {
        return monsterAttributes;
    }

    public void setMonsterAttributes(MonsterAttributes monsterAttributes) {
        this.monsterAttributes = monsterAttributes;
    }

    public int getMonsterPoint() {
        return monsterPoint;
    }

    public void setMonsterPoint(int monsterPoint) {
        this.monsterPoint = monsterPoint;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
