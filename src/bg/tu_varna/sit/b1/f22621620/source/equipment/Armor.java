package bg.tu_varna.sit.b1.f22621620.source.equipment;

public enum Armor {
    NONE ("No Armor", 0),
    LEATHERARMOR ("Leather Armor", 0.30),
    STUDDEDLEATHERARMOR ("Studded Leather Armor", 0.35),
    CHAINSHIRT ("Chain Shirt", 0.40),
    SCALEMAIL ("Scale Mail", 0.45),
    BREASTPLATE ("Breastplate", 0.50),
    HALFPLATE ("Halfplate", 0.55),
    CHAINMAIL ("Chainmail", 0.60),
    SPLINT ("Splint", 0.65),
    PLATE ("Plate Armor", 0.70);

    private final String armor;
    private final double armorClass;

    Armor(String armor, double armorClass) {
        this.armor = armor;
        this.armorClass = armorClass;
    }

    public String getArmor() {
        return armor;
    }

    public double getArmorClass() {
        return armorClass;
    }
}
