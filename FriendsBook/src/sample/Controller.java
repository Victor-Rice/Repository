package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    //Fields
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtBirthday;
    public TextField txtEmail;
    public TextField txtPhone;
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblBirthday;
    public Label lblEmail;
    public Label lblPhone;
    public ListView <Friend> listView = new ListView<>();
    Friend Temp;

    //Methods
    public void addFriend(ActionEvent actionEvent) {
        Temp = new Friend (txtFirstName.getText(), txtLastName.getText(), txtBirthday.getText(), txtEmail.getText(), txtPhone.getText());
        listView.getItems().add(Temp);
    }

    public void onClick(MouseEvent mouseEvent) {
        Temp = listView.getSelectionModel().getSelectedItem();
        lblFirstName.setText(Temp.firstName);
        lblLastName.setText(Temp.lastName);
        lblBirthday.setText(Temp.birthday);
        lblEmail.setText(Temp.email);
        lblPhone.setText(Temp.phoneNumber);

    }

    public void removeFriend(ActionEvent actionEvent) {
        Temp = listView.getSelectionModel().getSelectedItem();
        listView.getItems().remove(Temp);

    }

    public void add5Friends(ActionEvent actionEvent) {
        Temp = new Friend("Manish", "Suresh", "03/27", "mSuresh@gmail.com", "(236) 813-5621");
        listView.getItems().add(Temp);
        Friend Temp2 = new Friend("Jozef", " Jun", "01/13", "jJun@gmail.com", "(604) 513-7651");
        listView.getItems().add(Temp2);
        Friend Temp3 = new Friend("Hailie", "Wahyu", "06/21", "hWahyu@gmail.com", "(604)314-8350");
        listView.getItems().add(Temp3);
        Friend Temp4 = new Friend("Anastasia", "Britannia", "11/16", "aBritannia@gmail.com", "(604)612-9321");
        listView.getItems().add(Temp4);
        Friend Temp5 = new Friend("Alfred", "Aki", "12/24", "aAki@gmail.com", "(604)913-8371");
        listView.getItems().add(Temp5);

    }
}
