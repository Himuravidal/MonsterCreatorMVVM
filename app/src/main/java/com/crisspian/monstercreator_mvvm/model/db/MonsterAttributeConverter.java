package com.crisspian.monstercreator_mvvm.model.db;

import androidx.room.TypeConverter;

import com.crisspian.monstercreator_mvvm.model.MonsterAttributes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

public class MonsterAttributeConverter {

    private static Gson gson = new Gson();

    @TypeConverter
    public static String fromCreatureAttributes(MonsterAttributes monsterAttributes) {
        if (monsterAttributes != null) {
            return gson.toJson(monsterAttributes);
        }
        return null;
    }

    @TypeConverter
    public MonsterAttributes toCreatureAttributes(String value) {
        if (value == null) {
            return (MonsterAttributes) Collections.emptyList();
        }
        Type listType = new TypeToken<MonsterAttributes>() {
        }.getType();
        return gson.fromJson(value, listType);
    }
}
