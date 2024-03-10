package bg.tu_varna.sit.b1.f22621620.source.equipment;

public enum Spell {
    Firebolt ("Firebolt", 0.20);

    private final String spell;
    private final double damage;

    Spell(String spell, double damage) {
        this.spell = spell;
        this.damage = damage;
    }

    public String getSpell() {
        return spell;
    }

    public double getDamage() {
        return damage;
    }
}
