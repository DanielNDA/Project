package ui;

import dao.CursDao;
import dao.SaliDao;
import model.Cursuri;
import model.Sali;
import model.Studenti;

import java.util.List;
import java.util.Scanner;

public class SaliUi {

    private Scanner scanner = new Scanner(System.in);
    private SaliDao saliDao = new SaliDao();

    public void startSaliUi() {

        int optiune = -1;

        while (optiune != 0) {

            System.out.println("Sali management");
            System.out.println("1.Add Sala");
            System.out.println("2.View Sala");
            System.out.println("0.Exit");
            optiune = scanner.nextInt();
            scanner.nextLine();

            if (optiune == 1) {
                addSala();
            }
            if (optiune == 2) {
                viewSala();
            }
        }

    }

    private void addSala() {
        System.out.println("Enter classroom name:");
        String numeSala = scanner.nextLine();
        Sali sala = new Sali();
        sala.setNumeSala(numeSala);
        saliDao.addSala(sala);
    }

    private void viewSala() {
        List<Sali> saliList = saliDao.getAllSali();
        for (Sali sali : saliList) {
            System.out.println(sali.getSalaId() + "." + sali.getNumeSala());
        }
    }
}
