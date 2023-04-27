package service.student;

import model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManager implements IStudentManager {
    private static List<Student> studentList = new ArrayList<>();

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    public boolean isExisted(String studentId) {
        return studentList
                .stream()
                .anyMatch(student -> student.getStudentID().equals(studentId));
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sinh viên");
        String studentId = scanner.nextLine();
        if (!isExisted(studentId)) {
            System.out.println("Không tồn tại sinh viên này!");
        } else {
            System.out.println("Nhập tên mới");
            String newName = scanner.nextLine();
            System.out.println("Nhập điểm trung bình mới");
            double newAverageScore = Double.parseDouble(scanner.nextLine());
            Student foundedStudent = studentList
                    .stream()
                    .filter(student -> student.getStudentID().equals(studentId))
                    .findFirst()
                    .get();
            foundedStudent.setStudentName(newName);
            foundedStudent.setAverageScore(newAverageScore);
            System.out.println("Sửa thành công" + " " + foundedStudent);
        }
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sinh viên cần xóa");
        String studentId = scanner.nextLine();
        if (!isExisted(studentId)) {
            System.out.println("Không tồn tại sinh viên này!");
        } else {
            Student foundedStudent = studentList
                    .stream()
                    .filter(student -> student.getStudentID().equals(studentId))
                    .findFirst()
                    .get();
            System.out.println("Bạn có chắc muốn xóa sinh viên này?" + foundedStudent);
            System.out.println("""
                    1/    : Có
                    2/KHÁC: Không
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> studentList.remove(foundedStudent);
                default -> System.out.println("Đã hủy lệnh, quay lại menu chính!");
            }
        }
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean isDisplayDone = false;
        int displayCondition = 0;
        int i = 0;
        int j = 0;
        do {
            for (; displayCondition < studentList.size(); displayCondition++) {
                for (j = i + 5; i < j && i < studentList.size(); i++) {
                    System.out.println(studentList.get(i));
                }
                String waiter = scanner.nextLine();
                if (displayCondition == studentList.size()) {
                    isDisplayDone = true;
                }
            }
        } while (isDisplayDone);
    }

    @Override
    public void sort() {
        System.out.println("""
                1/       Sắp xếp theo điểm trung bình tăng dần
                2/Khác:  Sắp xếp theo điểm trung bình giảm dần
                """);
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> studentList.sort(Comparator.comparing(Student::getAverageScore));
            default -> studentList.sort();
        }
    }
}
