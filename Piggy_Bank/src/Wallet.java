public class Wallet {

    //declaraçao das propriedades
    private int money = 0;

    // get para poder aceder á variavel money fora da sua class
    public int getMoney(){
        return money;
    }


    //declaraçao do metodo add
    public void add(int money){
        this.money += money;
    }


    //declaraçao do metodo use
    public int use(int money){
        //condiçao usar dinheiro e atualiozação dos valores de removedMoney
        if(money > this.money){
            int removedMoney = this.money;
            this.money = 0;
            return removedMoney;
        }
        //atualização do valor de money;
        this.money -= money;
        return money;
    }

    // print
    @Override
    public String toString(){
        return "Wallet{" +
                "money=" + money +
                '}';
    }
}
