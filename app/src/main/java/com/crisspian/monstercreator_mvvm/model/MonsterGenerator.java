package com.crisspian.monstercreator_mvvm.model;

public class MonsterGenerator {
    private MonsterAttributes monsterAttributes;
    private String name = "";
    private int drawable = 0;

    public MonsterGenerator(MonsterAttributes monsterAttributes, String name, int drawable) {
        this.monsterAttributes = monsterAttributes;
        this.name = name;
        this.drawable = drawable;
    }

    public Monster monsterGenerate() {
        int monsterPoint = 4 * monsterAttributes.getIntelligence()
                + 3 * monsterAttributes.getEvilness()
                + 2 * monsterAttributes.getUgliness();
        return new Monster(name, monsterAttributes, monsterPoint, drawable);
    }

}
