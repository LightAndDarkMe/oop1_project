package bg.tu_varna.sit.b1.f22621620.source.characters;

public abstract class Character {
    private int strength;
    private int spellcastingAbility;
    private int maxHealth;
    private int currentHealth;

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

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
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
                .append(" | Max Health: ")
                .append(maxHealth)
                .append(" | Current Health: ")
                .append(currentHealth)
                .toString();
    }
}
