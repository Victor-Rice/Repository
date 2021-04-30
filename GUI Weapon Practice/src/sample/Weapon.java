package sample;

public class Weapon {

    //Fields
    public String name;
    public double ammoType;
    public int clipSize;
    public int currentBulletCount;
    public double length;
    public boolean jammed;
    public double reloadTime;
    public int ammoReserve;
    public int damage;
    public int range;

    //Methods

    //constructors

    Weapon(){
        this.name = "";
        this.ammoType = 7.62;
        this.clipSize = 32;
        this.length = 88;
        this.jammed = false;
        this.reloadTime = 2;
        this.ammoReserve = 150;
        this.currentBulletCount = 32;
    }
    public Weapon(String WeaponName, int wDamage, int wRange, int Magazine) {
        this.name = WeaponName;
        this.clipSize = Magazine;
        this.damage = wDamage;
        this.range = wRange;
        this.ammoType = 7.62;
        this.length = 88;
        this.jammed = false;
        this.reloadTime = 2;
        this.ammoReserve = 150;
        this.currentBulletCount = 32;

    }

    public Weapon(String WeaponName) {
        this.name = WeaponName;
        this.ammoType = 7.62;
        this.clipSize = 32;
        this.length = 88;
        this.jammed = false;
        this.reloadTime = 2;
        this.ammoReserve = 150;
        this.currentBulletCount = 32;
    }
    public Weapon(String wName,double wAmmo,double wLength,int wClip,boolean wJammed,int wCurrentBulletCount,double wReloadTime,int wAmmoReserve, int wDamage, int wRange){
        this.name = wName;
        this.ammoType = wAmmo;
        this.clipSize = wClip;
        this.currentBulletCount = wCurrentBulletCount;
        this.length = wLength;
        this.reloadTime = wReloadTime;
        this.ammoReserve = wAmmoReserve;
        this.jammed = wJammed;
        this.damage = wDamage;
        this.range = wRange;

    }

    //methods

    public void reload(int amt){
        //reload goes above clip size, Current bullet count should default to clip size

        if (ammoReserve<=amt){
            amt=ammoReserve;
        }
        if(amt>clipSize){
            amt=clipSize;
            ammoReserve = ammoReserve - amt;
            currentBulletCount = currentBulletCount+amt;
        }
        else
        if(amt<0){
            amt=0;
            ammoReserve = ammoReserve - amt;
            currentBulletCount = currentBulletCount+amt;
        }
        else
        if(amt+currentBulletCount>clipSize){
            amt=amt-currentBulletCount;
            currentBulletCount=currentBulletCount+amt;
            ammoReserve=ammoReserve-amt;
        }
        else
        if(currentBulletCount==clipSize){
            currentBulletCount=clipSize;

        }
        else{
            ammoReserve = ammoReserve - amt;
            currentBulletCount = currentBulletCount+amt;
        }

        System.out.println("reloading");

    }

    public void printAmmoReserve(){
        System.out.println("ammo reserve is at: "+this.ammoReserve);
    }


public void fire(int x){
        //checks clip size
        if (x>clipSize){
            x = clipSize;
        }
        //checks for negative amounts
        if (x<= 0){
            System.out.println("can't fire negative bullets, try again.");
            x=0;
        }
        //checks that you're firing the amount of bullets you have.
        if(x<=currentBulletCount){
            System.out.println(x+" bullet(s) fired");
            currentBulletCount=currentBulletCount-x;
        }
        else{
            x=currentBulletCount;
            System.out.println(x+" bullet(s) fired");
            currentBulletCount=currentBulletCount-x;
        }
}

public int checkBullets(){
        return this.currentBulletCount;
    }
    public void printBullets(){
        System.out.println("Current bullets: "+this.currentBulletCount);
    }



    public String writeToFile() {

        return "[wep]"+this.name+","+this.clipSize+","+this.damage+","+this.range+"\n";
    }


    public String toString(){
        return this.name;
    }



}


