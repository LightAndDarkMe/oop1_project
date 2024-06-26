package bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter;

import bg.tu_varna.sit.b1.f22621620.source.characters.Character;
import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.enums.CharacterClass;
import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.inventory.Inventory;
import bg.tu_varna.sit.b1.f22621620.source.exceptions.operations.InterruptedTimerException;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PlayerCharacter extends Character {
    private final Inventory inventory;
    private final CharacterClass characterClass;
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

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println("Choose which stat to level up by 5 points: (STR / ABI / HP)");
            System.out.print("$ ");
            String input = (scanner.nextLine()).toUpperCase();
            System.out.println();

            switch (input) {
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

        System.out.println(this);
        System.out.println("New map is generating...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new InterruptedTimerException(e.getMessage());
        }
    }

    public void creatureKill() {
        if (getCurrentHealth() < getMaxHealth() / 2) {
            setCurrentHealth(getMaxHealth() / 2);
        }
        System.out.println("Health after the battle: " + getCurrentHealth());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new InterruptedTimerException(e.getMessage());
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
