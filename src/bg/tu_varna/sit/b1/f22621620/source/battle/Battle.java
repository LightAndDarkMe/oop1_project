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

//    Add option to visualize how much damage you dealt, hps and stuff of that nature
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
                        dragon.setCurrentHealth(
                                (int) (dragon.getCurrentHealth() - (
                                        (playerCharacter.getStrength()
                                                * (playerCharacter.getInventory().getWeapon().getDamage()) + 1)
                                                * (1 - dragon.getArmorClass()))
                                ));
                        if (dragon.getCurrentHealth() <= 0) {
                            playerCharacter.creatureKill();
                            return;
                        }
                    }
                    case "Spell" -> {
                        dragon.setCurrentHealth(
                                (int) (dragon.getCurrentHealth() - (
                                        (playerCharacter.getSpellcastingAbility()
                                                * (playerCharacter.getInventory().getSpell().getDamage()) + 1)
                                                * (1 - dragon.getArmorClass()))
                                ));
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
                //fix this, get his option, blah blah
                int flip = coinFlip.nextInt(2);
                switch (flip) {
                    case 0 -> {
                        playerCharacter.setCurrentHealth(
                                (int) (playerCharacter.getCurrentHealth() - (
                                        dragon.getStrength()
                                        * (1 - playerCharacter.getInventory().getArmor().getArmorClass())
                                        )
                        ));
                        if (playerCharacter.getCurrentHealth() <= 0) {
                            EndGame();
                            return;
                        }
                    }
                    case 1 -> {
                        playerCharacter.setCurrentHealth(
                                (int) (playerCharacter.getCurrentHealth() - (
                                        dragon.getSpellcastingAbility()
                                                * (1 - playerCharacter.getInventory().getArmor().getArmorClass())
                                )
                                ));
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
