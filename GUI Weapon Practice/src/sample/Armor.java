package sample;

public class Armor {

    //Fields
    public String armorName;
    public String armorClass;
    public String armorStats;
    public String armorWeight;


    //Constructors

    public Armor(String aName,String aClass,String aStats,String aWeight){
        this.armorName = aName;
        this.armorClass= aClass;
        this.armorStats= aStats;
        this.armorWeight= aWeight;
    }

    //method to write to file for saving
    public String writeToFile() {

        return "[arm]"+this.armorName+","+this.armorClass+","+this.armorStats+","+this.armorWeight+"\n";
    }

    public String toString(){
        return this.armorName;
    }
}
