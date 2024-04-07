package bg.tu_varna.sit.b1.f22621620.source.battle;

import bg.tu_varna.sit.b1.f22621620.source.battle.interfaces.Combat;
import bg.tu_varna.sit.b1.f22621620.source.battle.interfaces.EndGame;
import bg.tu_varna.sit.b1.f22621620.source.characters.nonplayercharacter.Dragon;
import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.PlayerCharacter;

import java.util.Random;

public class Battle implements Combat, EndGame {
    private PlayerCharacter playerCharacter;
    private Dragon dragon;
    private int first;

    public Battle(PlayerCharacter playerCharacter, Dragon dragon) {
        this.playerCharacter = playerCharacter;
        this.dragon = dragon;
    }

    @Override
    public void combat() {
        Random coinFlip = new Random();
        System.out.println("A coin is being flipped to determine who is first!");
        first = coinFlip.nextInt(2);
        System.out.println((first == 1) ? "The player goes first." : "The enemy goes first.");

        System.out.println("Combat Begins!");
        while (playerCharacter.getCurrentHealth() > 0 && dragon.getCurrentHealth() > 0) {
            if (first == 1) {
                System.out.println("Player's turn. Choose your action: (Melee / Spell)");
                //fix this, get his option, blah blah
                String choice = "";
                switch (choice) {
                    case "Melee" -> {
                        int damageDealt = (int) (playerCharacter.getStrength() * (playerCharacter.getInventory().getWeapon().getDamage() + 1));
                        System.out.println("With Melee attack you are dealing: " + damageDealt + " damage");
                        int damageAfterCalculation = (int) (damageDealt * (1 - dragon.getArmorClass()));
                        System.out.println("After the dragon's protection you dealt: " + damageAfterCalculation + " damage");
                        dragon.setCurrentHealth((dragon.getCurrentHealth() - damageAfterCalculation));
                        if (dragon.getCurrentHealth() <= 0) {
                            playerCharacter.creatureKill();
                            return;
                        }
                    }
                    case "Spell" -> {
                        int damageDealt = (int) (playerCharacter.getSpellcastingAbility() * (playerCharacter.getInventory().getSpell().getDamage()) + 1);
                        System.out.println("With Spell attack you are dealing: " + damageDealt + " damage");
                        int damageAfterCalculation = (int) (damageDealt * (1 - dragon.getArmorClass()));
                        System.out.println("After the dragon's protection you dealt: " + damageAfterCalculation + " damage");
                        dragon.setCurrentHealth((dragon.getCurrentHealth() - damageAfterCalculation));
                        if (dragon.getCurrentHealth() <= 0) {
                            playerCharacter.creatureKill();
                            return;
                        }
                    }
                    default -> {
                        System.out.println("Wrong choice! Choose again: (Melee / Spell)");
                        //make him choose again or smth
                    }
                }
                first = 0;
            }
            else {
                System.out.println("Dragon's turn");
                int flip = coinFlip.nextInt(2);
                switch (flip) {
                    case 0 -> {
                        int damageDealt = dragon.getStrength();
                        System.out.println("With Melee attack the dragon is dealing: " + damageDealt + " damage");
                        int damageAfterCalculation = (int) (damageDealt * (1 - playerCharacter.getInventory().getArmor().getArmorClass()));
                        System.out.println("After your armor's protection the dragon dealt: " + damageAfterCalculation + " damage");
                        playerCharacter.setCurrentHealth((playerCharacter.getCurrentHealth() - damageAfterCalculation));
                        if (playerCharacter.getCurrentHealth() <= 0) {
                            EndGame();
                            return;
                        }
                    }
                    case 1 -> {
                        int damageDealt = dragon.getSpellcastingAbility();
                        System.out.println("With Spell attack the dragon is dealing: " + damageDealt + " damage");
                        int damageAfterCalculation = (int) (damageDealt * (1 - playerCharacter.getInventory().getArmor().getArmorClass()));
                        System.out.println("After your armor's protection the dragon dealt: " + damageAfterCalculation + " damage");
                        playerCharacter.setCurrentHealth((playerCharacter.getCurrentHealth() - damageAfterCalculation));
                        if (playerCharacter.getCurrentHealth() <= 0) {
                            EndGame();
                            return;
                        }
                    }
                }
                first = 1;
            }
        }
    }

    @Override
    public void EndGame() {

    }
}
