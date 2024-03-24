package bg.tu_varna.sit.b1.f22621620.source.characters;

public abstract class Character {
    private int strength;
    private int spellcastingAbility;
    private int health;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpellcastingAbility() {
        return spellcastingAbility;
    }

    public void setSpellcastingAbility(int spellcastingAbility) {
        this.spellcastingAbility = spellcastingAbility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Stats: ")
                .append("\n")
                .append("Strength: ")
                .append(strength)
                .append(" | Spellcasting Ability: ")
                .append(spellcastingAbility)
                .append(" | Health: ")
                .append(health)
                .toString();
    }
}
