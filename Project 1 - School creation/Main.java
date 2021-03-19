public class Main {
    public static void main(String[] args) {


       //3 Teachers created
     Teacher Teacher1 = new Teacher();
        Teacher1.firstName="Torvald";
        Teacher1.lastName="Dresst";
        Teacher1.subject="Science";
        Teacher Teacher2= new Teacher();
        Teacher2.firstName="Jordan";
        Teacher2.lastName="Sigfried";
        Teacher2.subject="History";
        Teacher Teacher3 = new Teacher();
        Teacher3.firstName="Ariel";
        Teacher3.lastName="Sorest";
        Teacher3.subject="Art";

        //Created the School from constructor
        School School1 = new School();
        System.out.println(School1);

        //loop for creation of 10 students
        for (int i=0;i<10;i++) {
           School1.addStudent(new Student());
        }

        //uses classes to complete assignment
        School1.addTeacher(Teacher1);
        School1.addTeacher(Teacher2);
        School1.addTeacher(Teacher3);
        School1.showAllStudents();
        School1.showAllTeachers();
        School1.removeStudent(2);
        School1.removeTeacher(1);
        School1.showAllStudents();
        School1.showAllTeachers();









    }

}
