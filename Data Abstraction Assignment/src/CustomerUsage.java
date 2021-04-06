import org.w3c.dom.ls.LSOutput;

import java.util.Date;

public class CustomerUsage {
    public static void main(String[] args) {
        Date setDate = new Date();

        //Deposit testDeposit = new Deposit(400,setDate,"Checking");
        //System.out.println(testDeposit);

        //Deposit savingsDeposit = new Deposit(500,setDate,"Saving");
        //System.out.println(savingsDeposit);

        //Withdraw checkingWithdraw = new Withdraw(400,setDate,"Checking");
        //System.out.println(checkingWithdraw);

        //Withdraw savingsWithdraw = new Withdraw(500,setDate,"Saving");
        //System.out.println(savingsWithdraw);

        Customer testCustomer = new Customer();
        Customer testSecondCustomer = new Customer("Jessica",0001,400.00,500.00);

        System.out.println(testSecondCustomer);
        testSecondCustomer.deposit(50,setDate,"Checking");
        System.out.println(testSecondCustomer);
        testSecondCustomer.deposit(150,setDate,"Checking");
        System.out.println(testSecondCustomer);
        testSecondCustomer.deposit(200,setDate,"Saving");
        System.out.println(testSecondCustomer);
        testSecondCustomer.displayDeposits();

        testSecondCustomer.withdraw(50,setDate,"Checking");
        testSecondCustomer.withdraw(70,setDate,"Checking");
        testSecondCustomer.withdraw(150,setDate,"Checking");
        testSecondCustomer.withdraw(250,setDate,"Saving");
        System.out.println(testSecondCustomer);
    }
}
