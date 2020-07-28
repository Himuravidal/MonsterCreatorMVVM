package com.crisspian.monstercreator_mvvm.model;

import com.crisspian.monstercreator_mvvm.model.AttributeValue;

import java.util.ArrayList;
import java.util.List;

public class AttributeStore {

    public static List<AttributeValue> intelligenceAttributeValues;
    public static List<AttributeValue> uglinessAttributeValues;
    public static List<AttributeValue> evilnessValue;

    public static List<AttributeValue> getIntelligenceAttributeValues() {
        intelligenceAttributeValues = new ArrayList<>();
        intelligenceAttributeValues.add(new AttributeValue("Ninguno", 0));
        intelligenceAttributeValues.add(new AttributeValue("Vivito", 3));
        intelligenceAttributeValues.add(new AttributeValue("Vivaracho", 7));
        intelligenceAttributeValues.add(new AttributeValue("Eintein", 10));
        return intelligenceAttributeValues;
    }

    public static List<AttributeValue> getUglinessAttributeValues() {
        uglinessAttributeValues = new ArrayList<>();
        uglinessAttributeValues.add(new AttributeValue("Ninguno",0));
        uglinessAttributeValues.add(new AttributeValue("Feo",3));
        uglinessAttributeValues.add(new AttributeValue("Adefesio feo",7));
        uglinessAttributeValues.add(new AttributeValue("Feo feo",10));
        return uglinessAttributeValues;
    }

    public static List<AttributeValue> getEvilnessValue() {
        evilnessValue = new ArrayList<>();
        evilnessValue.add(new AttributeValue("Ninguno", 0));
        evilnessValue.add(new AttributeValue("Malito", 3));
        evilnessValue.add(new AttributeValue("Malulo", 7));
        evilnessValue.add(new AttributeValue("Mephistofeles", 10));
        return evilnessValue;
    }

}
