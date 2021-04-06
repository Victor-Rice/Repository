import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Testcustomer {

    //Fields

    Date setDate = new Date();
    Customer testCustomer;
    Date testDate = new Date(1541314800000L);
    Date testDate2 = new Date(1534441937000L);
    Date testDate3 = new Date(1634441937000L);
    ArrayList<Deposit> testDepositAL = new ArrayList<>();
    Deposit testDeposit;
    Deposit testDeposit2;
    Withdraw testWithdraw;
    Withdraw testWithdraw2;
    Withdraw testWithdraw3;
    Withdraw testWithdrawOverdraft;
    ArrayList<Withdraw> testWithdrawAL = new ArrayList<>();



    @Before
    public void setup(){ testCustomer= new Customer("Jessica",0002,400.00,500.00);

    }

    @Test
    //Tests deposit and negative depositing
    public void testDeposit(){
        //checking initial balance
        assertTrue(testCustomer.getCheckBalance()==400);
        assertTrue(testCustomer.getSavingBalance()==500);

        //first deposit, checking balance is changed
        testCustomer.deposit(100,setDate,"Checking");
        assertTrue(testCustomer.getCheckBalance()==500);
        assertTrue(testCustomer.getSavingBalance()==500);

        //second deposit, checks if balance is updated
        testCustomer.deposit(100,setDate,"Saving");
        assertTrue(testCustomer.getSavingBalance()==600);
        assertTrue(testCustomer.getCheckBalance()==500);

        //tests for negative deposits and that it doesn't allow for it
        testCustomer.deposit(-100,setDate,"Checking");
        assertTrue(testCustomer.getCheckBalance()==500);
        assertTrue(testCustomer.getSavingBalance()==600);
        testCustomer.deposit(-100,setDate,"Saving");
        assertTrue(testCustomer.getSavingBalance()==600);
        assertTrue(testCustomer.getCheckBalance()==500);
    }
    @Test

    public void testDepositToString(){
        //Checking initial balance
        assertTrue(testCustomer.getCheckBalance()==400);
        assertTrue(testCustomer.getSavingBalance()==500);

        //Deposits amount and checks if it gets deposited properly
        testCustomer.deposit(400,testDate,"Checking");
        testDepositAL=testCustomer.getDeposits();

        //Gets Deposit from Arraylist
        testDeposit=testDepositAL.get(0);
        System.out.println(testDeposit);

        //Prints and checks if accurate
        assertEquals(testDeposit.toString(),"Deposit of: $400.0	Date: Sun Nov 04 00:00:00 PDT 2018	into account: Checking");

        //Deposits amount, gets deposit from arraylist
        testCustomer.deposit(500, testDate2,"Saving");
        testDeposit2=testDepositAL.get(1);

        //Prints and checks if accurate
        assertEquals(testDeposit2.toString(),"Deposit of: $500.0	Date: Thu Aug 16 10:52:17 PDT 2018	into account: Saving");
    }

    @Test
    public void testWithdrawToString(){
        //Checking initial balances
        assertTrue(testCustomer.getCheckBalance()==400);
        assertTrue(testCustomer.getSavingBalance()==500);

        //making first withdraw
        testCustomer.withdraw(100,testDate,"Checking");

        //creating a Withdraw arraylist to grab the private withdraw object
        testWithdrawAL=testCustomer.getWithdraws();

        //getting first Arraylist object
        testWithdraw=testWithdrawAL.get(0);
        System.out.println(testWithdraw);

        //checking the toString method
        assertEquals(testWithdraw.toString(),"Withdraw of: $100.0	Date: Sun Nov 04 00:00:00 PDT 2018	into account: Checking");

        //Checking second withdraw
        testCustomer.withdraw(100, testDate2,"Saving");
        testWithdraw2=testWithdrawAL.get(1);
        assertEquals(testWithdraw2.toString(),"Withdraw of: $100.0	Date: Thu Aug 16 10:52:17 PDT 2018	into account: Saving");

        //Checking Third withdraw
        testCustomer.withdraw(400, testDate3,"Checking");
        testWithdrawOverdraft=testWithdrawAL.get(2);
        assertEquals(testWithdrawOverdraft.toString(),"Withdraw of: $400.0	Date: Sat Oct 16 20:38:57 PDT 2021	into account: Checking");
        System.out.println("Checking: "+testCustomer.getCheckBalance());

        //Checking overdraft withdraw
        testCustomer.withdraw(100, testDate3,"Checking");

        //Checking withdraw was not created
        assertEquals(testWithdrawAL.size(),3);

        //Testing a fourth withdraw
        testCustomer.deposit(100,testDate3,"Checking");
        testCustomer.withdraw(50, testDate3,"Checking");

        //Checking withdraw was created
        testWithdraw3=testWithdrawAL.get(3);
        assertEquals(testWithdrawAL.size(),4);

        //Checking the toString
        assertEquals(testWithdraw3.toString(),"Withdraw of: $50.0	Date: Sat Oct 16 20:38:57 PDT 2021	into account: Checking");

    }



    @Test
    //tests that withdraw works fine and tests for negative withdraws
    public void testWithdraw(){

        //initial balance
        assertTrue(testCustomer.getCheckBalance()==400);
        assertTrue(testCustomer.getSavingBalance()==500);

        //tests Checking if withdraws works with both accounts
        testCustomer.withdraw(100,setDate,"Checking");
        assertTrue(testCustomer.getCheckBalance()==300);
        assertTrue(testCustomer.getSavingBalance()==500);
        testCustomer.withdraw(100,setDate,"Saving");
        assertTrue(testCustomer.getSavingBalance()==400);
        assertTrue(testCustomer.getCheckBalance()==300);


        //Tests if negative withdraw is caught
        testCustomer.withdraw(-100,setDate,"Checking");
        assertTrue(testCustomer.getCheckBalance()==300);
        assertTrue(testCustomer.getSavingBalance()==400);
        testCustomer.withdraw(-100,setDate,"Saving");
        assertTrue(testCustomer.getSavingBalance()==400);
        assertTrue(testCustomer.getCheckBalance()==300);
    }


    @Test
    //overdraft checking up to -100
    public void testOverdraft(){
        //initial balance
        assertTrue(testCustomer.getCheckBalance()==400);
        assertTrue(testCustomer.getSavingBalance()==500);

        //withdraws all within account
        testCustomer.withdraw(400,setDate,"Checking");
        assertTrue(testCustomer.getCheckBalance()==0);

        //tests withdraw up to overdraft
        testCustomer.withdraw(50,setDate,"Checking");
        assertTrue(testCustomer.getCheckBalance()==-50);
        testCustomer.withdraw(50,setDate,"Checking");
        assertTrue(testCustomer.getCheckBalance()==-100);

        //tests that overdraft is limited
        testCustomer.withdraw(50,setDate,"Checking");
        assertTrue(testCustomer.getCheckBalance()==-100);
    }
    @Test
    //Tests withdraw is over max overdraft, which then resets to max withdraw.
    public void testOverdraft2() {
        assertTrue(testCustomer.getCheckBalance() == 400);
        assertTrue(testCustomer.getSavingBalance() == 500);
        testCustomer.withdraw(4000, setDate, "Checking");
        assertTrue(testCustomer.getCheckBalance() == -100);
    }
}
