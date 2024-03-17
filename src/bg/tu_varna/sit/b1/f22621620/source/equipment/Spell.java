package bg.tu_varna.sit.b1.f22621620.source.equipment;

public enum Spell {
    //Cantrips:
    CHILLTOUCH ("Chill Touch", 0.18), //1d8
    ELDRITCHBLAST ("Eldritch Blast", 0.30), //1d10
    FIREBOLT ("Fire Бolt", 0.20), //1d10
    FROSTBITE ("Frostbite", 0.15), //1d6
    MINDSLIVER ("Mind Sliver", 0.15), //1d6
    POISONSPRAY ("Poison Spray", 0.25), //1d12
    SACREDFLAME ("Sacred Flame", 0.18), //1d8
    THUNDERCLAP ("Thunderclap", 0.15), //1d6
    TOLLTHEDEAD ("Toll the Dead", 0.30), //1d12
    VICIOUSMOCKERY ("Vicious Mockery", 0.10), //1d4

    //Level 1:
    BURNINGHANDS ("Burning Hands", 0.35), //3d6
    CATAPULT ("Catapult", 0.45), //3d8
    CHAOSBOLT ("Chaos Bolt", 0.40), //2d8 + 1d6
    MAGICMISSILE ("Magic Missile", 0.30), //3d4+3

    //Level 2:
    CLOUDOFDAGGERS ("Cloud of Daggers", 0.45), //4d4
    DRAGONSBREATH ("Dragon's Breath", 0.40), //3d6
    SCORCHINGRAY ("Scorching Ray", 0.55), //6d6

    //Level 3:
    FIREBALL ("Fireball", 0.70), //8d6
    HUNGEROFHADAR ("Hunger of Hadar", 0.50), //4d6
    LIGHTNINGBOLT ("Lightning Bolt", 0.70), //8d6

    //Level 4:
    ICESTORM ("Ice Storm", 0.60), //2d8 + 4d6
    PHANTASMALKILLER ("Phantasmal Killer", 0.70), //4d10
    SICKENINGRADIANCE ("Sickening Radiance", 0.75), //4d10
    WALLOFFIRE ("Wall of Fire", 0.65), //5d8

    //Level 5:
    BANISHINGSMITE ("Banishing Smite", 0.80), //5d10
    CLOUDKILL ("Cloudkill", 0.65), //5d8
    FLAMESTRIKE ("Flame Strike", 0.70), //8d6

    //Level 6:
    CHAINLIGHTNING ("Chain Lightning", 0.95), //10d8
    DISINTEGRATE ("Disintegrate", 1.20), //10d6 + 40

    //Level 7:
    DELAYEDBLASTFIREBALL ("Delayed Blast Fireball", 1.00), //13d6
    FIRESTORM ("Fire Storm", 0.90), //7d10

    //Level 8:
    EARTHQUAKE ("Earthquake", 0.95), //5d6 + 50
    INCENDIARYCLOUD ("Incendiary Cloud", 0.95), //10d8
    SUNBURST ("Sunburst", 01.00), //12d6

    //Level 9:
    METEORSWARM ("Meteor Swarm", 2.25); //40d6

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
