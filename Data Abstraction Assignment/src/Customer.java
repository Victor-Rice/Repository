import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private static int accountCounter=0;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;



    Customer(){
       this.name = "";
       this.accountNumber = accountNumber+accountCounter;
       this.checkBalance = 0.00;
       this.savingBalance = 0.00;
       this.savingRate = 0.07;
       this.accountCounter++;
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name=name;
        this.accountNumber=accountNumber;
        this.checkBalance=checkDeposit;
        this.savingBalance=savingDeposit;
    }

    //Requires: proper account name, amount >=0, date
    //Modifies: this.(checking/savings balance)
    //effects: adds amt to checkBalance or savingBalance
    public double deposit(double amt, Date date, String account){
        this.deposits.add(new Deposit(amt,date,account));
        if(amt<0){
            amt=0;
        }
        if(account==this.CHECKING){
            this.checkBalance=this.checkBalance+amt;
        }
        if(account==this.SAVING){
            this.savingBalance=savingBalance+amt;
        }
        return 0;
    }

    //Requires: balance - amt >=overdraft, !amt <=0
    //Modifies: this.(checking/savings balance)
    //Effects: removes amt from checkBalance or savingBalance up to -100, if balance - amt > overdraft then amt = balance + overdraft.
    public double withdraw(double amt, Date date, String account){
        //checks for negative withdraws
        if(amt<0){
            amt=0;
        }
        //checks overdraft
        if(checkOverdraft(amt,account)){
            //code will run if overdraft is okay
            this.withdraws.add(new Withdraw(amt,date,account));
            if(account==this.CHECKING){
                this.checkBalance=this.checkBalance-amt;
            }
            if(account==this.SAVING){
                this.savingBalance=savingBalance-amt;
            }
        }

        //Will run if overdraft is exceeded
        else {
            if(account==this.CHECKING){
                amt = this.checkBalance-OVERDRAFT;
            this.checkBalance=this.checkBalance-amt;
        }
            if(account==this.SAVING){
                amt = this.savingBalance-OVERDRAFT;
                this.savingBalance=savingBalance-amt;
            }
        System.out.println("over allowed amount, readjusting for max withdraw");}
        return 0;
    }
    private boolean checkOverdraft(double amt, String account){
        //returns true if within overdraft and false if outside overdraft
       if(account==CHECKING) {
           if (checkBalance - amt >= OVERDRAFT) {
               return true;
           }
           else return false;
       }
        if(account==SAVING) {
            if (savingBalance - amt >= OVERDRAFT) {
                return true;
            }
            else return false;

        }
        else return false;
    }


    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }


    //getters and setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static int getAccountCounter() {
        return accountCounter;
    }

    public static void setAccountCounter(int accountCounter) {
        Customer.accountCounter = accountCounter;
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(ArrayList<Withdraw> withdraws) {
        this.withdraws = withdraws;
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public void setCheckBalance(double checkBalance) {
        this.checkBalance = checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public double getSavingRate() {
        return savingRate;
    }

    public void setSavingRate(double savingRate) {
        this.savingRate = savingRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOVERDRAFT() {
        return OVERDRAFT;
    }




    //Requires: nothing
    //Modifies: Changes printout
    //Effects: printout, prints out name, account name, checking balance, savings balance
    public String toString(){
        return "Name: "+this.name+"\taccount number: "+this.accountNumber+"\tChecking balance: $"+this.checkBalance+"\tSavings balance: $"+this.savingBalance;
    }
}
