package ui;

import dao.StudentiDao;
import model.Studenti;

import java.util.List;
import java.util.Scanner;

public class StudentUi {

    private Scanner scanner = new Scanner(System.in);
    private StudentiDao studentiDao = new StudentiDao();


    public void startStudentUi() {

        int optiune = -1;

        while (optiune != 0) {

            System.out.println("Student management");
            System.out.println("1.Add Student");
            System.out.println("2.View Student");
            System.out.println("3.Delete Student");
            System.out.println("4.Update Student");

            System.out.println("0.Exit");
            optiune = scanner.nextInt();
            scanner.nextLine();

            if (optiune == 1) {
                addStudent();
            }
            if (optiune == 2) {
                viewStudent();
            }
            if (optiune == 3) {
                deteleStudent();
            }
            if (optiune == 4) {
                updateStudent();
            }
        }
    }

    private void addStudent() {
        System.out.println("Enter student CNP:");
        int cnpStudent = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter student first name:");
        String numeStudent = scanner.nextLine();
        System.out.println("Enter student last name:");
        String prenumeStudent = scanner.nextLine();
        Studenti studenti = new Studenti();
        studenti.setCnpStudent(cnpStudent);
        studenti.setNumeStudent(numeStudent);
        studenti.setPrenumeStudent(prenumeStudent);
        studentiDao.addStudent(studenti);
    }

    private void viewStudent() {
        List<Studenti> studentiList = studentiDao.getAllStudents();
        for (Studenti student : studentiList) {
            System.out.println(student.getCnpStudent() + "." + student.getNumeStudent() + " " + student.getPrenumeStudent());
        }
    }

    private void deteleStudent() {
        System.out.println("Enter student cnp:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Studenti studenti = studentiDao.findStudentByID(id);
        studentiDao.deleteStudent(studenti);

    }

    private void updateStudent() {
        System.out.println("Enter student cnp");
        int id = scanner.nextInt();
        scanner.nextLine();
        Studenti studentFound = studentiDao.findStudentByID(id);
        System.out.println("Enter new cnp");
        int newCnp = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new first name");
        String newName = scanner.nextLine();
        System.out.println("Enter new last name");
        String newLastName = scanner.nextLine();
        studentFound.setCnpStudent(newCnp);
        studentFound.setNumeStudent(newName);
        studentFound.setPrenumeStudent(newLastName);
        studentiDao.updateStudent(studentFound);

    }
}
