package bg.tu_varna.sit.b1.f22621620.source.operations.gameplay;

import bg.tu_varna.sit.b1.f22621620.source.battle.Battle;
import bg.tu_varna.sit.b1.f22621620.source.characters.nonplayercharacter.Dragon;
import bg.tu_varna.sit.b1.f22621620.source.dice.Dice;
import bg.tu_varna.sit.b1.f22621620.source.equipment.Armor;
import bg.tu_varna.sit.b1.f22621620.source.equipment.Spell;
import bg.tu_varna.sit.b1.f22621620.source.equipment.Weapon;
import bg.tu_varna.sit.b1.f22621620.source.field.generator.Generator;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;

import java.util.Scanner;

public class GameEngine {
    private static GameEngine instance = null;
    private final GameData gameData = GameData.getInstance();

    private GameEngine() {
    }

    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    public void onMonsterCollision() {
        Dragon dragon = new Dragon(gameData.getCurrentField().getLevel());
        Battle battle = new Battle(gameData.getPlayer(), dragon);
        battle.combat();
    }

    public void onTreasureCollision() {
        Dice dice = new Dice();
        int temp = dice.rollDice(3);
        Armor armor = null;
        Spell spell = null;
        Weapon weapon = null;
        switch (temp) {
            case 1 -> {
                int sides = Armor.getArmorCount(gameData.getCurrentField().getLevel());
                int armorIndex = dice.rollDice(sides);
                armor = Armor.values()[armorIndex - 1];
            }
            case 2 -> {
                int sides = Spell.getSpellCount(gameData.getCurrentField().getLevel());
                int spellIndex = dice.rollDice(sides);
                spell = Spell.values()[spellIndex - 1];
            }
            case 3 -> {
                int sides = Weapon.getWeaponCount(gameData.getCurrentField().getLevel());
                int weaponIndex = dice.rollDice(sides);
                weapon = Weapon.values()[weaponIndex - 1];
            }
        }

        boolean flag = false;
        do {
            System.out.println("You've found the legendary: " + (temp == 1 ? armor : (temp == 2 ? spell : weapon)) + ". Do you want to equip it? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            System.out.print("$ ");
            String input = scanner.nextLine().toUpperCase();
            System.out.println();
            switch (input) {
                case "Y" -> {
                    if (temp == 1) {
                        gameData.getPlayer().getInventory().setArmor(armor);
                    }
                    if (temp == 2) {
                        gameData.getPlayer().getInventory().setSpell(spell);
                    }
                    if (temp == 3) {
                        gameData.getPlayer().getInventory().setWeapon(weapon);
                    }
                    System.out.println("You've equipped the treasure.");
                    flag = true;
                }
                case "N" -> {
                    System.out.println("The treasure was lost.");
                    flag = true;
                }
                default -> {
                    flag = false;
                }
            }
        } while (!flag);
    }

    public void onWallCollision() {
        throw new RuntimeException("no");
    }

    public void onExitCollision() {
        gameData.getPlayer().levelUp();
        gameData.getCurrentField().levelUp();
        System.out.println("You cleared the level! Embrace yourself for level " + gameData.getCurrentField().getLevel());
        Generator generator = new Generator();
        generator.generate(gameData.getCurrentField().getLevel());
    }
}
