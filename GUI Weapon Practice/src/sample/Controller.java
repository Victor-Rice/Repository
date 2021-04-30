package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

public class Controller {

    //Fields for reference
    public TextField txtName;
    public TextField txtDamage;
    public TextField txtRange;
    public TextField txtMagazine;
    public ListView <Weapon> listViewWeapon = new ListView<>();
    public Button btnImportWeapon;
    public Label lblDamage;
    public Label lblMag;
    public Label lblReload;
    public Label lblAmmoRes;
    public Label lblAmmoType;
    public Label lblRange;
    public Label lblAmmoCounter;
    public Label lblAmmoReserveCounter;
    public TextField txtArmorName;
    public TextField txtArmorClass;
    public TextField txtArmorStat;
    public TextField txtArmorWeight;
    public Label lblArWeight;
    public Label lblArStats;
    public Label lblArClass;
    public Label lblArName;
    public ListView <Armor> listViewArmor = new ListView<>();
    public Button btnAddWeapon;
    public static Weapon Temp;
    public TextField txtItemAmount;
    public ListView<Item> listViewItems= new ListView<>();
    public Item Bandage = new Item("Bandage",5);
    public Item pTurret = new Item("Portable Turret", 1);
    public Item grenade = new Item("Grenade", 2);
    public Label lblItemName;
    public Label lblItemAmount;
    public String ProfileFile="default.txt";
    public ListView<String> listViewProfile= new ListView<>();
    public TextField txtProfile;
    public String profile;
    public ArrayList <Weapon> WeaponRecon = new ArrayList<>();
    public ArrayList <Armor> ArmorRecon = new ArrayList<>();
    public ArrayList <Item> ItemRecon = new ArrayList<>();
    public Label lblPlayerID;
    public Button btnLoadProfile;
    public Button btnSaveProfile;



    //Function to create your own weapon and add to list
    public void AddWeapon(ActionEvent actionEvent) {
        Weapon Temp = new Weapon (txtName.getText(), Integer.parseInt(txtDamage.getText()),Integer.parseInt(txtRange.getText()), Integer.parseInt(txtMagazine.getText()));
        listViewWeapon.getItems().add(Temp);
    }
    //Function to create own armor and add to list
    public void AddArmor(ActionEvent actionEvent) {
        Armor aTemp = new Armor(txtArmorName.getText(),txtArmorClass.getText(), txtArmorStat.getText(), txtArmorWeight.getText());
        listViewArmor.getItems().add(aTemp);
    }
    //Function to add more of premade items from selected list
    public void addItem(ActionEvent actionEvent) {
        Item TempItem = listViewItems.getSelectionModel().getSelectedItem();
        int i = Integer.parseInt(txtItemAmount.getText());
        TempItem.itemAmountEdit(i);
        lblItemAmount.setText(Integer.toString(TempItem.itemAmount));
    }
    //creates default weapons for ease of use
    public void ImportWeapons(ActionEvent actionEvent) {
        Weapon AssaultRifle = new Weapon("Assault Rifle", 7, 12, 32);
        Weapon Pistol = new Weapon("Pistol",9,44,16,false,16,1.4,160, 8, 11);
        Weapon HuntingRifle = new Weapon("Hunting Rifle",0.308,187.5,8,false,8,2.5,72, 15, 15);
        listViewWeapon.getItems().add(AssaultRifle);
        listViewWeapon.getItems().add(Pistol);
        listViewWeapon.getItems().add(HuntingRifle);
    }
    //creates default armor for ease of use
    public void ImportArmor(ActionEvent actionEvent) {
        Armor LightArmor = new Armor("Light Armor","Light","7","10 lbs");
        Armor MediumArmor = new Armor("Medium Armor","Medium","13","17 lbs");
        Armor HeavyArmor = new Armor("Heavy Armor","Heavy","25","35 lbs");
        listViewArmor.getItems().add(LightArmor);
        listViewArmor.getItems().add(MediumArmor);
        listViewArmor.getItems().add(HeavyArmor);
    }
    //grabs default items
    public void importItems(ActionEvent actionEvent) {
        listViewItems.getItems().add(Bandage);
        listViewItems.getItems().add(pTurret);
        listViewItems.getItems().add(grenade);
    }

    //displays stats/updates labels on GUI on selection
    public void DisplayStats(MouseEvent mouseEvent) {
        Temp = listViewWeapon.getSelectionModel().getSelectedItem();
        lblDamage.setText(Integer.toString(Temp.damage));
        lblMag.setText(Integer.toString(Temp.clipSize));
        lblReload.setText(Double.toString(Temp.reloadTime));
        lblAmmoRes.setText(Double.toString(Temp.ammoReserve));
        lblAmmoType.setText(Double.toString(Temp.ammoType));
        lblRange.setText(Integer.toString(Temp.range));
        lblAmmoCounter.setText(Integer.toString(Temp.currentBulletCount));
        lblAmmoReserveCounter.setText(Integer.toString(Temp.ammoReserve));
    }
    //displays stats/updates labels on GUI on selection
    public void ArmorSelected(MouseEvent mouseEvent) {
        Armor aTemp = listViewArmor.getSelectionModel().getSelectedItem();
        lblArName.setText(aTemp.armorName);
        lblArClass.setText(aTemp.armorClass);
        lblArStats.setText(aTemp.armorStats);
        lblArWeight.setText(aTemp.armorWeight);
    }
    //displays stats/updates labels on GUI on selection
    public void itemSelection(MouseEvent mouseEvent) {
        Item TempItem = listViewItems.getSelectionModel().getSelectedItem();
        lblItemName.setText(TempItem.itemName);
        lblItemAmount.setText(Integer.toString(TempItem.itemAmount));
    }
    //Single Fire feature
    public void wFire(ActionEvent actionEvent) {
        Temp.fire(1);
        lblAmmoCounter.setText(Integer.toString(Temp.currentBulletCount));
    }
    //Reload feature
    public void wReload(ActionEvent actionEvent) {
        Temp.reload(Temp.clipSize);
        lblAmmoCounter.setText(Integer.toString(Temp.currentBulletCount));
        lblAmmoReserveCounter.setText(Integer.toString(Temp.ammoReserve));
    }
    //burst fire feature
    public void wBFire(ActionEvent actionEvent) {
        Temp.fire(5);
        lblAmmoCounter.setText(Integer.toString(Temp.currentBulletCount));

    }
    //Selection function
    public void SelectProfile(MouseEvent mouseEvent) {
        profile = listViewProfile.getSelectionModel().getSelectedItem();
        txtProfile.setText(profile);
        btnLoadProfile.setDisable(false);
        btnSaveProfile.setDisable(false);
    }
    //Saves profiles from the viewlist to file
    public void SaveProfileList(ActionEvent actionEvent) throws IOException {
        FileWriter fw = new FileWriter("PlayerList.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        ObservableList<String> oListPlayerList = listViewProfile.getItems();
        for(String user:oListPlayerList){
            bw.write(user+"\n");
        }
        bw.close();
    }
    //Loads profiles from the file to viewlist
    public void LoadProfileFile(ActionEvent actionEvent) throws IOException {
        listViewProfile.getItems().clear();
        FileReader fr = new FileReader("PlayerList.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line=br.readLine())!=null){
            listViewProfile.getItems().add(line);
        }
    }

    //creation of profile to save info to
    public void AddProfile(ActionEvent actionEvent) throws IOException {

        listViewProfile.getItems().add(txtProfile.getText());
        FileWriter fw = new FileWriter(txtProfile.getText());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.close();
    }

    //save info to created profile
    public void updateProfile(ActionEvent actionEvent) throws IOException {
        ProfileFile=txtProfile.getText();
        FileWriter fw = new FileWriter(ProfileFile, true);
        BufferedWriter bw = new BufferedWriter(fw);


        ObservableList<Weapon> oListWepProfile = listViewWeapon.getItems();
        ObservableList<Armor> oListArmProfile = listViewArmor.getItems();
        ObservableList<Item> oListItmProfile = listViewItems.getItems();

        for(Weapon wTemp:oListWepProfile){
            bw.write(wTemp.writeToFile());
        }
        for(Armor aTemp:oListArmProfile){
            bw.write(aTemp.writeToFile());
        }
        for(Item iTemp:oListItmProfile){
            bw.write(iTemp.writeToFile());
        }
        bw.close();
    }

    //loads profile from previously created
    public void LoadProfile(ActionEvent actionEvent) throws IOException {
        //clears all objects
        WeaponRecon.clear();
        ArmorRecon.clear();
        ItemRecon.clear();

        lblPlayerID.setText(profile);

        FileReader fr = new FileReader(profile);
        BufferedReader br = new BufferedReader(fr);
        String line;
        //Recreates Objects
        while ((line=br.readLine())!=null){
            if(line.substring(0,5).equals("[wep]")){
                reconstructWeap(line.substring(5));
            }
            if(line.substring(0,5).equals("[arm]")){
                reconstructArm(line.substring(5));
            }
            if(line.substring(0,5).equals("[itm]")){
                reconstructItem(line.substring(5));
            }
        }
        //Updates ListView
        listViewWeapon.getItems().clear();
        for(Weapon lTemp:WeaponRecon){
            listViewWeapon.getItems().add(lTemp);
        }
        listViewArmor.getItems().clear();
        for(Armor aTemp:ArmorRecon){
            listViewArmor.getItems().add(aTemp);
        }
        listViewItems.getItems().clear();
        for(Item iTemp:ItemRecon){
            listViewItems.getItems().add(iTemp);
        }

    }

    //reconstructs weapons data from strings on txt file
    private void reconstructWeap(String info) {
        String wName;
        String wMag;
        String wDam;
        String wRan;
        ArrayList<Integer> commaPos = new ArrayList<>();

        for (int i=0;i<info.length();i++){
            if(info.substring(i,i+1).equals(",")){
                commaPos.add(i);
            }
        }
        wName=info.substring(0,commaPos.get(0));
        wMag=info.substring(commaPos.get(0)+1,commaPos.get(1));
        wDam=info.substring(commaPos.get(1)+1,commaPos.get(2));
        wRan=info.substring(commaPos.get(2)+1);

        Weapon Temp = new Weapon(wName,Integer.parseInt(wDam),Integer.parseInt(wRan),Integer.parseInt(wMag));
        WeaponRecon.add(Temp);

    }
    //reconstructs armor data from strings from txt file
    private void reconstructArm(String info) {
        String name;
        String aClass;
        String stats;
        String weight;
        ArrayList<Integer> commaPos = new ArrayList<>();

        for (int i=0;i<info.length();i++){
            if(info.substring(i,i+1).equals(",")){
                commaPos.add(i);
            }
        }
        name=info.substring(0,commaPos.get(0));
        aClass=info.substring(commaPos.get(0)+1,commaPos.get(1));
        stats=info.substring(commaPos.get(1)+1,commaPos.get(2));
        weight=info.substring(commaPos.get(2)+1);

        Armor rTemp = new Armor(name, aClass, stats, weight);
        ArmorRecon.add(rTemp);

    }
    //reconstructs item data from file
    private void reconstructItem(String info) {
        String name;
        String amount;
        ArrayList<Integer> commaPos = new ArrayList<>();

        for (int i=0;i<info.length();i++){
            if(info.substring(i,i+1).equals(",")){
                commaPos.add(i);
            }
        }
        name=info.substring(0,commaPos.get(0));
        amount=info.substring(commaPos.get(0)+1);
        Item iTemp = new Item(name, Integer.parseInt(amount));
        ItemRecon.add(iTemp);
    }

    //resets ammo reserves back to default
    public void resetAmmo(ActionEvent actionEvent) {
        Temp.ammoReserve=150;
        lblAmmoReserveCounter.setText(Integer.toString(Temp.ammoReserve));
    }


}
