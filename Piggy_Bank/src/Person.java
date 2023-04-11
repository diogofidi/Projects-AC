public class Person {

    //declaraçao das variaveis
    private String name;
    private PiggyBank piggyBank;
    private Wallet wallet;

    //construtor de Person e passar o metodo de adicionar dinheiro
    public Person(String name, PiggyBank piggyBank, Wallet wallet, int money){
        this.name = name;
        this.piggyBank = piggyBank;
        this.wallet = wallet;

        wallet.add(money);
    }

    //declaraçao do metodo spend
    public int spend(int money){
        return wallet.use(money);
    }
    //declaraçao do metodo fillWallet
    public void fillWallet(int money){
        wallet.add(piggyBank.withdraw(money));
    }
    //declaraçao do metodo para guardar dinheiro
    public void saveMoney(int money){
        piggyBank.deposit(wallet.use(money));
    }

    //print
    @Override
    public String toString(){
        return "Person{" +
                "name=" + name +
                ", piggybank=" + piggyBank +
                ", wallet=" + wallet +
                '}';
    }
}
