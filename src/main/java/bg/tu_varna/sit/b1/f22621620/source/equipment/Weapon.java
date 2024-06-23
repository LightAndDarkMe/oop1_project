package bg.tu_varna.sit.b1.f22621620.source.equipment;

import bg.tu_varna.sit.b1.f22621620.source.exceptions.operations.InvalidLevelException;

public enum Weapon {
    DAGGER("Dagger", 0.20, 0),
    LIGHTHAMMER("Light Hammer", 0.20, 1),
    SICKLE("Sickle", 0.20, 1),
    HANDAXE("Handaxe", 0.25, 1),
    MACE("Mace", 0.25, 1),
    QUARTERSTAFF("Quarterstaff", 0.25, 1),
    SPEAR("Spear", 0.30, 1),
    GREATCLUB("Greatclub", 0.30, 1),
    SHORTSWORD("Shortsword", 0.30, 1),
    SCIMITAR("Scimitar", 0.30, 1),
    LONGSWORD("Longsword", 0.35, 2),
    RAPIER("Rapier", 0.35, 2),
    WARHAMMER("Warhammer", 0.40, 3),
    BATTLEAXE("Battleaxe", 0.40, 3),
    HALBERD("Halberd", 0.50, 4),
    GREATAXE("Greataxe", 0.50, 4),
    GREATSWORD("Greatsword", 0.50, 4);

    private final String weapon;
    private final double damage;
    private final int level;

    Weapon(String weapon, double damage, int level) {
        this.weapon = weapon;
        this.damage = damage;
        this.level = level;
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
        return stringBuilder.append("Weapon: ")
                .append(weapon)
                .append("; Damage: ")
                .append(damage * 100)
                .toString();
    }

    public static int getWeaponCount(int level) {
        if (level < 1) {
            throw new InvalidLevelException("Invalid level!");
        }

        int count = 0;
        for (Weapon weapon : Weapon.values()) {
            if (weapon.level <= level) {
                count++;
            }
        }

        return count;
    }
}
