import Courses.Courses;

import java.util.ArrayList;

public class School {
    //fields
    ArrayList<Teacher> teachersArrayList = new ArrayList<>();
    ArrayList<Student> studentsArrayList = new ArrayList<>();
    ArrayList<Courses> coursesArrayList = new ArrayList<>();

    String nameOfSchool;
    String locationOfSchool;
    int numberOfStudents;
//Methods
    //Constructor
    School(){
        nameOfSchool="Victor's Uni";
        locationOfSchool="Vancouver";
        numberOfStudents=10;
    }
    //Command related Methods
    public void addTeacher(Teacher teacherInput){
        teachersArrayList.add(teacherInput);
    }
    public void showAllTeachers(){
        System.out.println(teachersArrayList);
    }

    public void addStudent(Student studentInput){
        studentsArrayList.add(studentInput);
    }
    public void showAllStudents(){
        System.out.println(studentsArrayList);
    }

    public void removeStudent(int x){for(int i=0;i<x;i++){studentsArrayList.remove(0);}}
    public void removeTeacher(int x){for(int i=0;i<x;i++){teachersArrayList.remove(0);}}


    //Printout method
    public String toString(){
        return "Name of School: "+this.nameOfSchool+"\tLocation of School: "+this.locationOfSchool+"\tNumber of Students: "+this.numberOfStudents;
    }

    //getters and setters
    public String getNameOfSchool() {
        return nameOfSchool;
    }

    public void setNameOfSchool(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
    }

    public String getLocationOfSchool() {
        return locationOfSchool;
    }

    public void setLocationOfSchool(String locationOfSchool) {
        this.locationOfSchool = locationOfSchool;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
}
