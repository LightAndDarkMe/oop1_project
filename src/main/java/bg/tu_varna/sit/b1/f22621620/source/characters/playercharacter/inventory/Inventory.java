package bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.inventory;

import bg.tu_varna.sit.b1.f22621620.source.equipment.Armor;
import bg.tu_varna.sit.b1.f22621620.source.equipment.Weapon;
import bg.tu_varna.sit.b1.f22621620.source.equipment.Spell;

public class Inventory {
    private Armor armor;
    private Weapon weapon;
    private Spell spell;

    public Inventory() {
        armor = Armor.NONE;
        weapon = Weapon.DAGGER;
        spell = Spell.FIREBOLT;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Inventory: ")
                .append("\n")
                .append(armor)
                .append(" | ")
                .append(weapon)
                .append(" | ")
                .append(spell)
                .toString();
    }
}
