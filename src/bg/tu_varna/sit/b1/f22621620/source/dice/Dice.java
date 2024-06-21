package bg.tu_varna.sit.b1.f22621620.source.dice;

import bg.tu_varna.sit.b1.f22621620.source.dice.interfaces.DiceRoll;

import java.util.Random;

public class Dice implements DiceRoll {
    Random diceRoll;

    public Dice() {
        this.diceRoll = new Random();
    }

    @Override
    public int rollDice(int sides) {
        return diceRoll.nextInt(sides);
    }
}
