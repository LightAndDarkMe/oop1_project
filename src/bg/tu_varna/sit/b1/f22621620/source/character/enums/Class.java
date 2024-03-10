package bg.tu_varna.sit.b1.f22621620.source.character.enums;

public enum Class {
    FIGHTER ("Fighter"),
    WIZARD ("Wizard"),
    BARBARIAN ("Barbarian");

    private final String characterClass;

    Class(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getCharacterClass() {
        return characterClass;
    }
}
