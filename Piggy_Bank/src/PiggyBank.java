public class PiggyBank {

    //declaraçao das propriedades
    private int money;

    //get para conseguir aceder ao money fora da sua class
    public int getMoney(){
        return money;
    }

    //declaraçao do metodo withdraw
    public int withdraw(int money){

        //condiçao para conseguir retirar dinheiro e atualizaçao do valor de removedMoney
        if(money > this.money){
            int removedMoney = this.money;
            this.money = 0;
            return removedMoney;
        }
        //atualizaçao do money
        this.money -= money;
        return money;
    }
    //declaraçao do metodo deposit
    public void deposit(int money){
        this.money += money;
    }

    //print
    @Override
    public String toString(){
        return "PiggyBank{" +
                "money=" + money +
                '}';
    }
}
