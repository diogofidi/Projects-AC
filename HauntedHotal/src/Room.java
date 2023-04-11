public class Room {

    private boolean available = true;

    public boolean isAvailable(){
        return available;
    }
    public void occupy(){
        available = false;
    }
    public void vacate(){
        available = true;
    }
}
