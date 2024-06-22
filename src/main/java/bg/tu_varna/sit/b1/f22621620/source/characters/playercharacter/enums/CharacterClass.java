package bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.enums;

public enum CharacterClass {
    //Barbarian*, Bard, Cleric, Druid, Fighter*, Monk, Paladin, Ranger, Rogue, Sorcerer*, Warlock, Wizard, Artificer
    FIGHTER("Fighter", 30, 20, 50),
    SORCERER("Sorcerer", 10, 40, 50),
    BARBARIAN("Barbarian", 40, 10, 50);

    private final String characterClass;
    private final int strength;
    private final int spellcastingAbility;
    private final int health;

    CharacterClass(String characterClass, int strength, int spellcastingAbility, int health) {
        this.characterClass = characterClass;
        this.strength = strength;
        this.spellcastingAbility = spellcastingAbility;
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpellcastingAbility() {
        return spellcastingAbility;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Class: ")
                .append(characterClass)
                .toString();
    }
}
