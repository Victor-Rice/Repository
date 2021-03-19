public class Student {
    //Fields
    String firstName;
    String lastName;
    double grade;
    int studentNumber;
    static int counter=00000;

//Methods
    //Constructor
    Student(){
        firstName="";
        lastName="";
        grade=0;
        studentNumber=counter;
        counter++;
    }

    //Printout Method
    public String toString(){

        return "Name: "+this.firstName+" "+this.lastName+"\tGrade: "+this.grade+"\n";
    }

    //Getters and Setters

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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }






}
