public class Hotel {

    public static final int NO_ROOM = -1;

    private String name;
    private Room[] rooms;


    public Hotel(String name, int numRooms) {
        this.name = name;
        rooms = new Room[numRooms];
    }

    public int checkIn(){

        for (int i = 0; i < rooms.length; i++){
            if(rooms[i] == null){
                rooms[i] = new Room();
            }
            if(rooms[i].isAvailable()){
                rooms[i].occupy();
                return i;
            }
        }
        return NO_ROOM;
    }

    public void checkOut(int roomId){
        if(rooms[roomId] != null){
            rooms[roomId].vacate();
        }
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms.length +
                '}';
    }
}

