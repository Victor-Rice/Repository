package sample;

public class Item {

    //fields
String itemName;
int itemAmount;

//constructors
    public Item(String name, int Amount){
        this.itemName=name;
        this.itemAmount=Amount;
    }

    public void itemAmountEdit(int i){
        this.itemAmount+=i;
    }


    //method to write to file
    public String writeToFile() {

        return "[itm]"+this.itemName+","+this.itemAmount+"\n";
    }

    public String toString(){
        return this.itemName;
    }
}
