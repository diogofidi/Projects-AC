package Props;

public class Barrel extends GameObject implements Destroyable {

    private BarrelType barrelType;
    private int currentDamage;

    public Barrel(){
        int index = (int) (Math.random() * (BarrelType.values().length));
        barrelType = BarrelType.values()[index];
    }
    @Override
    public void hit(int damage) {
        currentDamage++;
    }
    @Override
    public boolean isDestroyed() {
        return currentDamage >= barrelType.getMaxDamage();
    }
    @Override
    public String getMessage() {
        return "Props.Barrel found. Blow it!";
    }
}