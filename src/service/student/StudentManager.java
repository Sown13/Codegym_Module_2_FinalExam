package service.student;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager implements IStudentManager {
    private static List<Student> studentList = new ArrayList<>();

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean isDisplayDone = false;
        int displayCondition = 0;
        int i =0;
        int j = 0;
        do {
            for (; displayCondition < studentList.size(); displayCondition++) {
                for ( j =i+5 ; i < j && i < studentList.size(); i++) {
                    System.out.println(studentList.get(i));
                }
                String waiter = scanner.nextLine();
                if(displayCondition == studentList.size()){
                    isDisplayDone = true;
                }
            }
        } while (isDisplayDone);
    }
}
