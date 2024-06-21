package bg.tu_varna.sit.b1.f22621620.source.battle;

import bg.tu_varna.sit.b1.f22621620.source.battle.interfaces.Combat;
import bg.tu_varna.sit.b1.f22621620.source.battle.interfaces.EndGame;
import bg.tu_varna.sit.b1.f22621620.source.characters.nonplayercharacter.Dragon;
import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.PlayerCharacter;
import bg.tu_varna.sit.b1.f22621620.source.dice.Dice;

import java.util.Scanner;

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
        System.out.println("A coin is being flipped to determine who is first!");
        int turnPriority = dice.rollDice(2);
        System.out.println((turnPriority == 1) ? "The player goes first." : "The enemy goes first.");

        System.out.println("Combat Begins!");
        while (player.getCurrentHealth() > 0 && dragon.getCurrentHealth() > 0) {
            if (turnPriority == 1) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Player's turn. Choose your action: (Melee / Spell)");
                System.out.print("$ ");
                String input = (scanner.nextLine()).toUpperCase();
                System.out.println();
                switch (input) {
                    case "MELEE" -> {
                        int damageDealt = (int) (player.getStrength() * (player.getInventory().getWeapon().getDamage() + 1));
                        System.out.println("With Melee attack you are dealing: " + damageDealt + " damage");
                        int damageAfterCalculation = (int) (damageDealt * (1 - dragon.getArmorClass()));
                        System.out.println("After the dragon's protection you dealt: " + damageAfterCalculation + " damage");
                        dragon.setCurrentHealth((dragon.getCurrentHealth() - damageAfterCalculation));
                        if (dragon.getCurrentHealth() <= 0) {
                            player.creatureKill();
                            return;
                        }
                    }
                    case "SPELL" -> {
                        int damageDealt = (int) (player.getSpellcastingAbility() * (player.getInventory().getSpell().getDamage()) + 1);
                        System.out.println("With Spell attack you are dealing: " + damageDealt + " damage");
                        int damageAfterCalculation = (int) (damageDealt * (1 - dragon.getArmorClass()));
                        System.out.println("After the dragon's protection you dealt: " + damageAfterCalculation + " damage");
                        dragon.setCurrentHealth((dragon.getCurrentHealth() - damageAfterCalculation));
                        if (dragon.getCurrentHealth() <= 0) {
                            player.creatureKill();
                            return;
                        }
                    }
                    default -> {
                        System.out.println("Wrong choice! Choose again: (Melee / Spell)");
                        //make him choose again or smth
                        //Fix this!
                        //Make this into a new function and call it again from there; in a nutshell - recursion
                    }
                }
                turnPriority = 0;
            } else {
                System.out.println("Dragon's turn");
                int rolled = dice.rollDice(2);
                switch (rolled) {
                    case 0 -> {
                        int damageDealt = dragon.getStrength();
                        System.out.println("With Melee attack the dragon is dealing: " + damageDealt + " damage");
                        int damageAfterCalculation = (int) (damageDealt * (1 - player.getInventory().getArmor().getArmorClass()));
                        System.out.println("After your armor's protection the dragon dealt: " + damageAfterCalculation + " damage");
                        player.setCurrentHealth((player.getCurrentHealth() - damageAfterCalculation));
                        if (player.getCurrentHealth() <= 0) {
                            EndGame();
                            return;
                        }
                    }
                    case 1 -> {
                        int damageDealt = dragon.getSpellcastingAbility();
                        System.out.println("With Spell attack the dragon is dealing: " + damageDealt + " damage");
                        int damageAfterCalculation = (int) (damageDealt * (1 - player.getInventory().getArmor().getArmorClass()));
                        System.out.println("After your armor's protection the dragon dealt: " + damageAfterCalculation + " damage");
                        player.setCurrentHealth((player.getCurrentHealth() - damageAfterCalculation));
                        if (player.getCurrentHealth() <= 0) {
                            EndGame();
                            return;
                        }
                    }
                }
                turnPriority = 1;
            }
        }
    }

    @Override
    public void EndGame() {
        System.out.println("YOU LOST!");
        System.out.println("Great Failure.");
        System.exit(0);
    }
}
