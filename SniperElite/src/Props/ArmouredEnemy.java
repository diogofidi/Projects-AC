package Props;

import Props.Enemy;

public class ArmouredEnemy extends Enemy {

    private int armour;

    public ArmouredEnemy(int health,int armour) {
        super(health);
        this.armour = armour;
    }
    @Override
    public void hit(int damage){

        if(armour > damage){
            armour -= damage;
            return;
        }
        damage -= armour;
        armour = 0;
        super.hit(damage);
    }
}