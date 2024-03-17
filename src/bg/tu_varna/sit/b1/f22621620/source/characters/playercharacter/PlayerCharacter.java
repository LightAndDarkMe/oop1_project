package bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter;

import bg.tu_varna.sit.b1.f22621620.source.characters.Character;
import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.enums.CharacterClass;
import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.inventory.Inventory;

public class PlayerCharacter extends Character {
    private Inventory inventory;
    private CharacterClass characterClass;

    public PlayerCharacter(CharacterClass characterClass) {
        inventory = new Inventory();
        this.characterClass = characterClass;
        setStrength(characterClass.getStrength());
        setSpellcastingAbility(characterClass.getSpellcastingAbility());
        setHealth(characterClass.getHealth());
    }


}
