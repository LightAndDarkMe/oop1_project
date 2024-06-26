package bg.tu_varna.sit.b1.f22621620.source.characters.nonplayercharacter;

import bg.tu_varna.sit.b1.f22621620.source.characters.Character;

public class Dragon extends Character {
    private final int level;
    private final double armorClass;

    public Dragon(int level) {
        this.level = level;
        armorClass = 0.05 + (level * 0.10);
        setStrength(15 + (level * 10));
        setSpellcastingAbility(15 + (level * 10));
        setMaxHealth(40 + (level * 10));
        setCurrentHealth(40 + (level * 10));
    }

    public int getLevel() {
        return level;
    }

    public double getArmorClass() {
        return armorClass;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Monster: Dragon ")
                .append(level)
                .append("\n")
                .append(super.toString())
                .append("\nArmor Class: ")
                .append(armorClass * 100)
                .toString();
    }
}
