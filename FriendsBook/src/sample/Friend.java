package sample;

public class Friend {
    //Fields
    public String firstName ="";
    public String lastName ="";
    public String birthday ="";
    public String email ="";
    public String phoneNumber ="";

    //Constructor
    Friend (String mFirst,String mLast,String mDate,String mEmail,String mPhone){
        this.firstName = mFirst;
        this.lastName = mLast;
        this.birthday = mDate;
        this.email = mEmail;
        this.phoneNumber = mPhone;
    }

    public String toString(){
        return this.firstName;
    }
}
