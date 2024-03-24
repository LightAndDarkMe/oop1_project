package bg.tu_varna.sit.b1.f22621620.source.equipment;

public enum Weapon {
    DAGGER ("Dagger", 0.20),
    LIGHTHAMMER ("Light Hammer", 0.20),
    SICKLE ("Sickle", 0.20),
    HANDAXE ("Handaxe", 0.25),
    MACE ("Mace", 0.25),
    QUARTERSTAFF ("Quarterstaff", 0.25),
    SPEAR ("Spear", 0.30),
    GREATCLUB ("Greatclub", 0.30),
    SHORTSWORD ("Shortsword", 0.30),
    SCIMITAR ("Scimitar", 0.30),
    LONGSWORD ("Longsword", 0.35),
    RAPIER ("Rapier", 0.35),
    WARHAMMER ("Warhammer", 0.40),
    BATTLEAXE ("Battleaxe", 0.40),
    HALBERD ("Halberd", 0.50),
    GREATAXE ("Greataxe", 0.50),
    GREATSWORD ("Greatsword", 0.50);

    private final String weapon;
    private final double damage;

    Weapon(String weapon, double damage) {
        this.weapon = weapon;
        this.damage = damage;
    }

    public String getWeapon() {
        return weapon;
    }

    public double getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Weapon: ")
                .append(weapon)
                .append("; Damage: ")
                .append(damage * 100)
                .toString();
    }
}
