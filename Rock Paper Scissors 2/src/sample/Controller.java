package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class Controller {
    public Label lblCurrentMoney;
    public Label lblCurrentBetAmount;
    public TextField txtBet;
    public Label lblPlayersChoice;
    public Label lblComputerChoice;
    public Label lblWinOrLose;
    public static int x;
    public static int y;
    public int betAmount;
    public int CurrentAmount;
    public int NewTotal;
    public Label lblBetAmount;
    public Button btnBet;

    public void Bet(ActionEvent actionEvent) {
        CurrentAmount = Integer.parseInt(lblCurrentMoney.getText());
        betAmount = Integer.parseInt(txtBet.getText());
        if(betAmount<=CurrentAmount && betAmount>0) {
            String betAmountTxt = txtBet.getText();
            lblCurrentBetAmount.setText(betAmountTxt);
            btnBet.setDisable(true);
        }else{
            txtBet.setText("0");
        }
    }

    public void Rock(ActionEvent actionEvent) {
        //update player choice
        y = 1;
        lblPlayersChoice.setText("Rock");
        //updates computer choice
        lblComputerChoice.setText(computerChoice());
        //decides who wins
        outcome();
    }

    private void outcome() {
        if (outcomeChecking()){
            lblWinOrLose.setText("You win!");
            CurrentAmount = Integer.parseInt(lblCurrentMoney.getText());
            betAmount = Integer.parseInt(lblCurrentBetAmount.getText());
            NewTotal = CurrentAmount + betAmount;
            lblCurrentMoney.setText(Integer.toString(NewTotal));
        }
        else {
            lblWinOrLose.setText("You Lose!");
            CurrentAmount = Integer.parseInt(lblCurrentMoney.getText());
            betAmount = Integer.parseInt(lblCurrentBetAmount.getText());
            NewTotal = CurrentAmount - betAmount;
            lblCurrentMoney.setText(Integer.toString(NewTotal));
            if(NewTotal <=0){
                lblCurrentBetAmount.setText("Disabled");
                betAmount=0;
                txtBet.clear();
                lblBetAmount.setText("Betting Disabled");
                btnBet.setDisable(true);
                txtBet.setDisable(true);
            }
        }
        lblCurrentBetAmount.setText("0");
        txtBet.clear();
    }


    public void Paper(ActionEvent actionEvent) {
        y=2;
        //update player choice
        lblPlayersChoice.setText("Paper");
        //updates computer choice
        lblComputerChoice.setText(computerChoice());
        //decides who wins
        outcome();

    }

    public void Scissors(ActionEvent actionEvent) {
        y=3;
        //update player choice
        lblPlayersChoice.setText("Scissors");
        //updates computer choice
        lblComputerChoice.setText(computerChoice());
        //decides who wins
        outcome();
    }
    public String computerChoice(){
        Random ran = new Random();
        this.x = ran.nextInt(3)+1;

        if (x == 1){
            return "Rock";
        }
        if (x == 2){
            return "Paper";
        }
        if (x == 3){
            return "Scissors";
        }
        return "";
    }



    public boolean outcomeChecking(){
        if(y==1 && x==3){
            return true;
        }
        if(y==2 && x==1){
            return true;
        }
        if(y==3 && x==2){
            return true;
        }

        return false;
    }


    public void userInput(KeyEvent keyEvent) {
        btnBet.setDisable(false);
    }
}
