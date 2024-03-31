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
        setMaxHealth(characterClass.getHealth());
        setCurrentHealth(characterClass.getHealth());
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

//    Fix Later!!!
    public void levelUp() {
        level++;
        for (int i = 0; i < 6; i++) {
            System.out.println("Choose which stat to level up by 5 points: (STR / ABI / HP)");
            //read the value - not relevant for now; fix later
            String choice = "";
            switch (choice) {
                case "STR" -> setStrength(getStrength() + 5);
                case "ABI" -> setSpellcastingAbility(getSpellcastingAbility() + 5);
                case "HP" -> setMaxHealth(getMaxHealth() + 5);
                default -> {
                    System.out.println("This is not a viable option, choose from: (STR / ABI / HP)");
                    i--;
                }
            }
        }
        setCurrentHealth(getMaxHealth());
    }

    public void creatureKill() {
        if(getCurrentHealth() < getMaxHealth() / 2) {
            setCurrentHealth(getMaxHealth() / 2);
        }
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
