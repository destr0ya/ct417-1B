package group2;

import group1.*;
import org.joda.time.DateTime;

import java.util.ArrayList;

public class Test {

    public static void main(String [] args) {

        //Create 20 fictional students
        ArrayList<Student> students = new ArrayList<Student>();
        DateTime dt = new DateTime();
        for(int i = 1; i < 21; i++) {
            Student student = new Student();
            student.setName("John Smith" + i);
            dt.dayOfMonth().setCopy(i);
            if (i == 12) {
                dt.monthOfYear().setCopy(12);
            } else {
                dt.monthOfYear().setCopy(i % 12);
            }
            dt.year().setCopy(1996);
            student.setDOB(dt);
            student.setId(143582 + i);
            students.add(student);
        }

        //Create 3 modules
        Module module0 = new Module();
        module0.setName("Software Engineering III");
        module0.setId("CT417");

        Module module1 = new Module();
        module1.setName("Machine Learning & Data Mining");
        module1.setId("CT475");

        Module module2 = new Module();
        module2.setName("Graphics & Image Processing");
        module2.setId("CT404");

        //Create a program
        Program program = new Program();
        program.setName("4BCT");

        //Set start date
        DateTime dt1 = new DateTime();
        dt1.dayOfMonth().setCopy(4);
        dt1.monthOfYear().setCopy(9);
        dt1.year().setCopy(2017);
        program.setStartDate(dt1);

        //Set end date
        DateTime dt2 = new DateTime();
        dt2.dayOfMonth().setCopy(25);
        dt2.monthOfYear().setCopy(11);
        dt2.year().setCopy(2017);
        program.setStartDate(dt2);

        //Add students to modules, and modules to program
        for (int j = 0; j < 10; j++) {
            module0.addStudent(students.get(j));
            module1.addStudent(students.get(j + 10));
        }
        for (Student student : students) {
            module2.addStudent(student);
        }
        program.addModule(module0);
        program.addModule(module1);
        program.addModule(module2);

        System.out.println("Module " + module0.getName() + " in program " + program.getName() + " has student " + module0.studentsToString());
        System.out.println("Module " + module1.getName() + " in program " + program.getName() + " has student " + module1.studentsToString());
        System.out.println("Module " + module2.getName() + " in program " + program.getName() + " has student " + module2.studentsToString());

  }

}
