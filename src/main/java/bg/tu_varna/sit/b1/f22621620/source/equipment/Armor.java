package bg.tu_varna.sit.b1.f22621620.source.equipment;

public enum Armor {
    NONE ("No Armor", 0, 0),
    LEATHERARMOR ("Leather Armor", 0.30, 1),
    STUDDEDLEATHERARMOR ("Studded Leather Armor", 0.35, 1),
    CHAINSHIRT ("Chain Shirt", 0.40, 2),
    SCALEMAIL ("Scale Mail", 0.45, 2),
    BREASTPLATE ("Breastplate", 0.50, 3),
    HALFPLATE ("Halfplate", 0.55, 3),
    CHAINMAIL ("Chainmail", 0.60, 4),
    SPLINT ("Splint", 0.65, 5),
    PLATE ("Plate Armor", 0.70, 6);

    private final String armor;
    private final double armorClass;
    private final int level;

    Armor(String armor, double armorClass, int level) {
        this.armor = armor;
        this.armorClass = armorClass;
        this.level = level;
    }

    public String getArmor() {
        return armor;
    }

    public double getArmorClass() {
        return armorClass;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Armor: ")
                .append(armor)
                .append("; Armor Class: ")
                .append(armorClass * 100)
                .toString();
    }
}
