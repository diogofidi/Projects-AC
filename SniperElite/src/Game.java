import Props.GameObject;
import Props.GameObjectFactory;

import javax.security.auth.Destroyable;

public class Game {

    public static final double ENEMY_PROBABILITY = 0.7;
    public static final int BULLET_DAMAGE = 1;

    private GameObject[] gameObjects;
    private SniperElite sniperElite;

    public Game(int numberObjects){
        this.gameObjects = createGameObjects(numberObjects);
        this.sniperElite = new SniperElite(BULLET_DAMAGE);
    }
    public void start(){
        for(GameObject gameObject : gameObjects){
            System.out.println(gameObject.getMessage());

            if(gameObject instanceof Destroyable){
                Destroyable target = (Destroyable) gameObject;
                while(!target.isDestroyed()){
                    System.out.println("Making the shot...");
                    sniperElite.shoot((Props.Destroyable) target);
                }
                System.out.println("Target is neutralized. I repeat, Target is neutralyzed!");
            }
        }
        System.out.println("All targets are down. I repeat all targets are down!");
    }
    private GameObject[] createGameObjects(int numberObjects){
        GameObject[] gameObjects = new GameObject[numberObjects];
        for( int i = 0; i < gameObjects.length; i++){
            gameObjects[i] = Math.random() < ENEMY_PROBABILITY ? GameObjectFactory.createEnemy() : GameObjectFactory.createObject();
        }
        return gameObjects;
    }
}
