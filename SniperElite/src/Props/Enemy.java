package Props;

public abstract class Enemy extends GameObject implements Destroyable {

    private int health;

    public Enemy(int health){
        this.health = health;
    }
    public int getHealth(){
        return health;
    }
    @Override
    public boolean isDestroyed(){
        return health <= 0;
    }
    public void hit(int damage){
        health = health - damage > 0 ? health - damage : 0;
    }
    @Override
    public String getMessage(){
        return "Tango Acquired. Taking it down!!";
    }
}