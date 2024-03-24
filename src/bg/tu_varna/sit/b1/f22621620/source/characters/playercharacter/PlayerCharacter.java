package bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter;

import bg.tu_varna.sit.b1.f22621620.source.characters.Character;
import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.enums.CharacterClass;
import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.inventory.Inventory;

public class PlayerCharacter extends Character {
    private Inventory inventory;
    private CharacterClass characterClass;
    private int level;

    public PlayerCharacter(CharacterClass characterClass) {
        inventory = new Inventory();
        this.characterClass = characterClass;
        setStrength(characterClass.getStrength());
        setSpellcastingAbility(characterClass.getSpellcastingAbility());
        setHealth(characterClass.getHealth());
        this.level = 1;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Player:\n")
                .append(characterClass)
                .append(" ")
                .append(level)
                .append("\n")
                .append(super.toString())
                .append("\n")
                .append(inventory)
                .toString();

    }
}
