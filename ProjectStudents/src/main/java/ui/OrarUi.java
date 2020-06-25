package ui;

import dao.OrarDao;
import dao.StudentiDao;
import model.Orar;
import model.Studenti;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrarUi {

    private Scanner scanner = new Scanner(System.in);
    private OrarDao orarDao = new OrarDao();


    public void startOrarUi() {

        int optiune = -1;

        while (optiune != 0) {

            System.out.println("Orar management");
            System.out.println("1.Add Ore");
            System.out.println("2.View Ore");
            System.out.println("3.Delete Ore");
            System.out.println("4.Update Ore");
            System.out.println("0.Exit");
            optiune = scanner.nextInt();
            scanner.nextLine();

            if (optiune == 1) {
                addOre();
            }
            if (optiune == 2) {
                viewOrar();
            }
            if (optiune == 3) {
                deteleOrar();
            }
            if (optiune == 4) {
                updateStudent();
            }
        }
    }

    private void addOre() {
        System.out.println("Enter date");
        String date  = scanner.nextLine();
        System.out.println("Enter start hour");
        String startHour = scanner.nextLine();
        System.out.println("Enter end hour");
        String endHour = scanner.nextLine();
        Orar orar = new Orar();
        orar.setData(java.sql.Date.valueOf(date));
        orar.setStartHour(startHour);
        orar.setEndHour(endHour);
        orarDao.addOrar(orar);
    }

    private void viewOrar() {
        List<Orar> orarList = orarDao.getAllOrar();
        for (Orar orar : orarList) {
            System.out.println(orar.getOrarId() + ". Date : " + orar.getData() + " ->Start at: " + orar.getStartHour()+ " Ends at : "+ orar.getEndHour());
        }
    }

    private void deteleOrar() {
        System.out.println("Enter orar id");
        int id = scanner.nextInt();
        scanner.nextLine();
        Orar orar = orarDao.findOrarByID(id);
        orarDao.deleteOrar(orar);
    }
    private void updateStudent() {
        System.out.println("Enter orar id");
        int id = scanner.nextInt();
        scanner.nextLine();
        Orar orar = orarDao.findOrarByID(id);
        System.out.println("Enter new date");
        String newDate = scanner.nextLine();
        System.out.println("Enter start hour");
        String startHour = scanner.nextLine();
        System.out.println("Enter end hour");
        String endHour = scanner.nextLine();
        orar.setData(java.sql.Date.valueOf(newDate));
        orar.setStartHour(startHour);
        orar.setEndHour(endHour);
        orarDao.updateOrar(orar);

    }
}
