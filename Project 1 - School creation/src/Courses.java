package Courses;

public class Courses {
//Fields
    String name;
    int lengthByYear;
    String teacher;

    //Constructor
    Courses(){
        name="";
        lengthByYear=1;
        teacher="";
    }


    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLengthByYear() {
        return lengthByYear;
    }

    public void setLengthByYear(int lengthByYear) {
        this.lengthByYear = lengthByYear;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

}
