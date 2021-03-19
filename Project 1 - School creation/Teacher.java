public class Teacher {

//fields
    String firstName;
    String lastName;
    String subject;

//methods
    //constructor
    Teacher(){
        firstName="";
        lastName="";
        subject="";
    }
    //Printout Method
    public String toString(){
        return "Name: "+this.firstName+" "+this.lastName+"\tSubject: "+this.subject+"\n";
    }

    //Setters and getter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
