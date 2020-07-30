package com.crisspian.monstercreator_mvvm.model;

public class MonsterGenerator {

    //Tuve que modificar lo que recibia este metodo, faltaban los atributos y estaban puestos como parte de la clase y constructor
    public static Monster monsterGenerate(MonsterAttributes monsterAttributes, String name, int drawable) {
        int monsterPoint = 4 * monsterAttributes.getIntelligence()
                + 3 * monsterAttributes.getEvilness()
                + 2 * monsterAttributes.getUgliness();
        return new Monster(name, monsterAttributes, monsterPoint, drawable);
    }

}
