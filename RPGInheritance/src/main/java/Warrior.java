public class Warrior extends characters {
    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public int shieldStrength;
    public Warrior(String name, int strenght, int health, int stamia, int speed, int attackpower,int shieldStrength ) {
        super ( name, strenght, health, stamia, speed, attackpower );
    }
}
