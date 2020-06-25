package ui;

import dao.CursDao;
import dao.ProfesoriDao;
import model.Cursuri;
import model.Profesori;

import java.util.List;
import java.util.Scanner;

public class CursUi {

    private Scanner scanner = new Scanner(System.in);
    private CursDao cursDao = new CursDao();

    public void startCursUi() {

        int optiune = -1;

        while (optiune != 0) {

            System.out.println("Curs management");
            System.out.println("1.Add Curs");
            System.out.println("2.View Curs");
            System.out.println("3.Delete Curs");
            System.out.println("0.Exit");
            optiune = scanner.nextInt();
            scanner.nextLine();

            if (optiune == 1) {
                addCurs();
            }
            if (optiune == 2) {
                viewCurs();
            }
            if (optiune == 3) {
                deteleCurs();
            }

        }

    }

    private void addCurs() {
        System.out.println("Enter curs name:");
        String numeCurs = scanner.nextLine();
        System.out.println("Enter curs description");
        String description = scanner.nextLine();
        Cursuri cursuri = new Cursuri();
        cursuri.setNumeCurs(numeCurs);
        cursuri.setDescriere(description);
        cursDao.addCursuri(cursuri);
    }

    private void viewCurs() {
        List<Cursuri> cursuriList = cursDao.getAllCursuri();
        for (Cursuri cursuri : cursuriList) {
            System.out.println(cursuri.getCursId() + "." + cursuri.getNumeCurs() + " - " + cursuri.getDescriere());
        }
    }

    private void deteleCurs() {
        System.out.println("Enter curs id");
        int id = scanner.nextInt();
        scanner.nextLine();
        Cursuri cursuri = cursDao.findCursByID(id);
        cursDao.deleteCursuri(cursuri);

    }
}
