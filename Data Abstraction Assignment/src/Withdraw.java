import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }


    //Requires: nothing
    //Modifies: Changes printout
    //Effects: printout, prints out "Deposit of", date, account name
    public String toString(){
        return "Withdraw of: $"+this.amount+"\tDate: "+this.date+"\tinto account: "+this.account;
    }
}
