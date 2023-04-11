public class Main {
    public static void main(String[] args) {

        Hotel havana = new Hotel("Havana", 100);
        Hotel ibis = new Hotel("Ibis", 50);
        Client tiago = new Client("Tiago");
        Client diogo = new Client("Diogo");

        tiago.setHotel(ibis);
        diogo.setHotel(havana);

        if (!tiago.checkIn()){
            System.out.println("Could not get a room for " + tiago.getName());
        }
        if(!diogo.checkIn()){
            System.out.println("Could not get a room for " + diogo.getName());

            tiago.checkOut();
            diogo.checkOut();
        }

        if(!diogo.checkOut()){
            System.out.println();
        }
        if(diogo.checkIn() && !diogo.checkIn()){
            System.out.println("Unable to checkout twice in a row!");
        }
        if(diogo.checkOut() && !diogo.checkIn()){
            System.out.println("Check in after check out works fine!!");
        }
        System.out.println(havana);
        System.out.println(ibis);
        System.out.println(tiago);
        System.out.println(diogo);


    }
}