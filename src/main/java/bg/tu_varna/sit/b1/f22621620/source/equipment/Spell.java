package bg.tu_varna.sit.b1.f22621620.source.equipment;

public enum Spell {
    //Cantrips:
    CHILLTOUCH ("Chill Touch", 0.18, 0), //1d8
    ELDRITCHBLAST ("Eldritch Blast", 0.30, 0), //1d10
    FIREBOLT ("Fire Бolt", 0.20, 0), //1d10
    FROSTBITE ("Frostbite", 0.15, 0), //1d6
    MINDSLIVER ("Mind Sliver", 0.15, 0), //1d6
    POISONSPRAY ("Poison Spray", 0.25, 0), //1d12
    SACREDFLAME ("Sacred Flame", 0.18, 0), //1d8
    THUNDERCLAP ("Thunderclap", 0.15, 0), //1d6
    TOLLTHEDEAD ("Toll the Dead", 0.30, 0), //1d12
    VICIOUSMOCKERY ("Vicious Mockery", 0.10, 0), //1d4

    //Level 1:
    BURNINGHANDS ("Burning Hands", 0.35, 1), //3d6
    CATAPULT ("Catapult", 0.45, 1), //3d8
    CHAOSBOLT ("Chaos Bolt", 0.40, 1), //2d8 + 1d6
    MAGICMISSILE ("Magic Missile", 0.30, 1), //3d4+3

    //Level 2:
    CLOUDOFDAGGERS ("Cloud of Daggers", 0.45, 2), //4d4
    DRAGONSBREATH ("Dragon's Breath", 0.40, 2), //3d6
    SCORCHINGRAY ("Scorching Ray", 0.55, 2), //6d6

    //Level 3:
    FIREBALL ("Fireball", 0.70, 3), //8d6
    HUNGEROFHADAR ("Hunger of Hadar", 0.50, 3), //4d6
    LIGHTNINGBOLT ("Lightning Bolt", 0.70, 3), //8d6

    //Level 4:
    ICESTORM ("Ice Storm", 0.60, 4), //2d8 + 4d6
    PHANTASMALKILLER ("Phantasmal Killer", 0.70, 4), //4d10
    SICKENINGRADIANCE ("Sickening Radiance", 0.75, 4), //4d10
    WALLOFFIRE ("Wall of Fire", 0.65, 4), //5d8

    //Level 5:
    BANISHINGSMITE ("Banishing Smite", 0.80, 5), //5d10
    CLOUDKILL ("Cloudkill", 0.65, 5), //5d8
    FLAMESTRIKE ("Flame Strike", 0.70, 5), //8d6

    //Level 6:
    CHAINLIGHTNING ("Chain Lightning", 0.95, 6), //10d8
    DISINTEGRATE ("Disintegrate", 1.20, 6), //10d6 + 40

    //Level 7:
    DELAYEDBLASTFIREBALL ("Delayed Blast Fireball", 1.00, 7), //13d6
    FIRESTORM ("Fire Storm", 0.90, 7), //7d10

    //Level 8:
    EARTHQUAKE ("Earthquake", 0.95, 8), //5d6 + 50
    INCENDIARYCLOUD ("Incendiary Cloud", 0.95, 8), //10d8
    SUNBURST ("Sunburst", 01.00, 8), //12d6

    //Level 9:
    METEORSWARM ("Meteor Swarm", 2.25, 9), //40d6

    //Illegal:
    WISH("Wish", 50, 16); //Make a wish

    private final String spell;
    private final double damage;
    private final int level;

    Spell(String spell, double damage, int level) {
        this.spell = spell;
        this.damage = damage;
        this.level = level;
    }

    public String getSpell() {
        return spell;
    }

    public double getDamage() {
        return damage;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Spell: ")
                .append(spell)
                .append("; Damage: ")
                .append(damage * 100)
                .toString();
    }
}
