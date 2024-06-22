package bg.tu_varna.sit.b1.f22621620.source.dice;

import bg.tu_varna.sit.b1.f22621620.source.dice.interfaces.DiceRoll;

import java.util.Random;

public class Dice implements DiceRoll {
    private final Random diceRoll;

    public Dice() {
        this.diceRoll = new Random();
    }

    @Override
    public int rollDice(int sides) {
        int temp = diceRoll.nextInt();
        temp = (temp < 0) ? temp * -1 : temp;
        temp %= sides;
        return temp + 1;
    }
}
