


public class characters{



        private String name;
        private int strenght;
        private int health;
        private int stamia;
        private int speed;
        private int attackpower;

        public void run ( ) {
            System.out.println ( "Sonic" );
        }

        public void Attack ( ) {
            System.out.println ( "strike" );
        }

        public void heal ( ) {
            System.out.println ( "aw" );
        }

        public void decreaseHealth ( ) {
            System.out.println ( "oops" );
        }

        public void increaseStamina ( ) {

            System.out.println ( "yay" );
        }

        public void decreaseStamina ( ) {
            System.out.println ( "oh no" );

        }


    public characters( String name, int strenght, int health, int stamia, int speed, int attackpower) {
        this.name = name;
        this.strenght = strenght;
        this.health = health;
        this.stamia = stamia;
        this.speed = speed;
        this.attackpower = attackpower;


    }
}


