public class Main {
    public static void main(String[] args) {

        //instanciar novos objetos de wallet e piggybank;
    Wallet w1 = new Wallet();
    Wallet w2 = new Wallet();
    PiggyBank pb = new PiggyBank();

    //instanciar as pessoas e dizer como sao cada uma;
    Person p1 = new Person("Tiago",pb,w1,500);
        System.out.println(p1);
    Person p2 = new Person("Diogo",pb,w2,200);
        System.out.println(p2);

        //açao que declara que a p1 vai guardar 200;
        p1.saveMoney(200);
        System.out.println(p1);
        System.out.println(p2);

        //açao que declara que a p1 vai gastar 100;
        p1.spend(100);
        System.out.println(p1);
        System.out.println(p2);
    }
}