package bg.tu_varna.sit.b1.f22621620.source.battle;

import bg.tu_varna.sit.b1.f22621620.source.battle.interfaces.Combat;
import bg.tu_varna.sit.b1.f22621620.source.battle.interfaces.EndGame;
import bg.tu_varna.sit.b1.f22621620.source.characters.nonplayercharacter.Dragon;
import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.PlayerCharacter;
import bg.tu_varna.sit.b1.f22621620.source.dice.Dice;
import bg.tu_varna.sit.b1.f22621620.source.exceptions.operations.InterruptedTimerException;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Battle implements Combat, EndGame {
    private final PlayerCharacter player;
    private final Dragon dragon;

    public Battle(PlayerCharacter playerCharacter, Dragon dragon) {
        this.player = playerCharacter;
        this.dragon = dragon;
    }

    @Override
    public void combat() {
        Dice dice = new Dice();
        System.out.println("A coin is being flipped to determine who is going first!");
        int turnPriority = dice.rollDice(2);
        System.out.println((turnPriority == 2) ? "The player goes first." : "The enemy goes first.");

        System.out.println("Combat Begins!");
        while (player.getCurrentHealth() > 0 && dragon.getCurrentHealth() > 0) {
            if (turnPriority == 2) {
                boolean flag;
                do {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Player's turn. Choose your action: (Melee / Spell)");
                    System.out.print("$ ");
                    String input = (scanner.nextLine()).toUpperCase();
                    System.out.println();

                    switch (input) {
                        case "MELEE" -> {
                            playerAttack(player.getStrength(), player.getInventory().getWeapon().getDamage());
                            if (dragon.getCurrentHealth() <= 0) {
                                player.creatureKill();
                                return;
                            }
                            flag = true;
                        }
                        case "SPELL" -> {
                            playerAttack(player.getSpellcastingAbility(), player.getInventory().getSpell().getDamage());
                            if (dragon.getCurrentHealth() <= 0) {
                                player.creatureKill();
                                return;
                            }
                            flag = true;
                        }
                        default -> {
                            System.out.println("Not an option! Choose again: (Melee / Spell)");
                            flag = false;
                        }
                    }
                } while (!flag);
                turnPriority = 1;
            } else {
                System.out.println("Dragon's turn");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new InterruptedTimerException(e.getMessage());
                }
                int roll = dice.rollDice(2);
                switch (roll) {
                    case 1 -> {
                        dragonAttack(dragon.getStrength());
                        if (player.getCurrentHealth() <= 0) {
                            endGame();
                        }
                    }
                    case 2 -> {
                        dragonAttack(dragon.getSpellcastingAbility());
                        if (player.getCurrentHealth() <= 0) {
                            endGame();
                        }
                    }
                }
                turnPriority = 2;
            }
        }
    }

    @Override
    public void endGame() {
        System.out.println("YOU LOST!");
        System.out.println("Great Failure.");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new InterruptedTimerException(e.getMessage());
        }
        System.exit(0);
    }

    private void playerAttack(int statBonus, double damageBonus) {
        int damageDealt = (int) (statBonus * (damageBonus + 1));
        damageDealt = randomBehavior(damageDealt);
        System.out.println("With your attack you are dealing: " + damageDealt + " damage");
        int damageAfterCalculation = (int) (damageDealt * (1 - dragon.getArmorClass()));
        System.out.println("After the dragon's protection you dealt: " + damageAfterCalculation + " damage");
        dragon.setCurrentHealth((dragon.getCurrentHealth() - damageAfterCalculation));
        System.out.println("Current dragon's health: " + dragon.getCurrentHealth());
    }

    private void dragonAttack(int damageDealt) {
        damageDealt = randomBehavior(damageDealt);
        System.out.println("With his attack the dragon is dealing: " + damageDealt + " damage");
        int damageAfterCalculation = (int) (damageDealt * (1 - player.getInventory().getArmor().getArmorClass()));
        System.out.println("After your armor's protection the dragon dealt: " + damageAfterCalculation + " damage");
        player.setCurrentHealth((player.getCurrentHealth() - damageAfterCalculation));
        System.out.println("Your current health: " + player.getCurrentHealth());
    }

    private int randomBehavior(int damage) {
        Dice dice = new Dice();

        int flip = dice.rollDice(2);
        damage = (flip == 1) ? damage + dice.rollDice(8) : damage - dice.rollDice(8);

        int roll = dice.rollDice(20);
        if (roll == 20) {
            System.out.println("Critical Hit! Rolled a 20.");
            damage *= 2;
        } else if (roll == 1) {
            System.out.println("Critical Failure! Rolled a 1.");
            damage = 0;
        }

        return damage;
    }
}
