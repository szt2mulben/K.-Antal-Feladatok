class Aircraft {
    protected int maxAmmo;
    protected int baseDamage;
    protected int ammo;

    public Aircraft() {
        this.ammo = 0;
    }

    public int fight() {
        int damage = baseDamage * ammo;
        ammo = 0;
        return damage;
    }

    public int refillAmmo(int ammoToFill) {
        int remainingAmmo = 0;
        if (ammoToFill <= maxAmmo - ammo) {
            ammo += ammoToFill;
        } else {
            ammo += maxAmmo - ammo;
            remainingAmmo = ammoToFill - (maxAmmo - ammo);
        }
        return remainingAmmo;
    }

    public String getType() {
        return "Aircraft";
    }

    public String getStatus() {
        return "Type " + getType() + ", Ammo: " + ammo + ", Base Damage: " + baseDamage + ", All Damage: " + (baseDamage * ammo);
    }

    public boolean isPriority() {
        return false;
    }
}

class F16 extends Aircraft {
    public F16() {
        maxAmmo = 8;
        baseDamage = 30;
    }

    @Override
    public String getType() {
        return "F16";
    }

    @Override
    public boolean isPriority() {
        return false;
    }
}

class F35 extends Aircraft {
    public F35() {
        maxAmmo = 12;
        baseDamage = 50;
    }

    @Override
    public String getType() {
        return "F35";
    }

    @Override
    public boolean isPriority() {
        return true;
    }
}
