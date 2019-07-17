public class Constable  extends characters{
    public  String jurisdiction;
    public Constable(String name, int strenght, int health, int stamia, int speed, int attackpower,String jurisdiction) {
        super ( name, strenght, health, stamia, speed, attackpower );
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getJurisdiction() {
        return jurisdiction;

    }
}
