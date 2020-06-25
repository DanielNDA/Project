package ui;

import dao.ProfesoriDao;
import dao.StudentiDao;
import model.Profesori;
import model.Studenti;

import java.util.List;
import java.util.Scanner;

public class ProfesorUi {

    private Scanner scanner = new Scanner(System.in);
    private ProfesoriDao profesoriDao = new ProfesoriDao();

    public void startProfesorUi() {

        int optiune = -1;

        while (optiune != 0) {

            System.out.println("Profesor management");
            System.out.println("1.Add Profesor");
            System.out.println("2.View Profesor");
            System.out.println("3.Delete Profesor");
            System.out.println("0.Exit");
            optiune = scanner.nextInt();
            scanner.nextLine();

            if (optiune == 1) {
                addProfesor();
            }
            if (optiune == 2) {
                viewProfesor();
            }
            if (optiune == 3) {
                deteleProfesor();
            }

        }

    }

    private void addProfesor() {
        System.out.println("Enter profesor cnp");
        int cnpProf = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter profesor first name:");
        String numeProf = scanner.nextLine();
        System.out.println("Enter profesor last name:");
        String prenumeProf = scanner.nextLine();
        Profesori profesori = new Profesori();
        profesori.setCnpProfesor(cnpProf);
        profesori.setNumeProfesor(numeProf);
        profesori.setPrenumeProfesor(prenumeProf);
        profesoriDao.addProfesor(profesori);
    }

    private void viewProfesor() {
        List<Profesori> profesoriList = profesoriDao.getAllProfesori();
        for (Profesori profesori : profesoriList) {
            System.out.println(profesori.getCnpProfesor() + "." + profesori.getNumeProfesor() + " " + profesori.getPrenumeProfesor());
        }
    }

    private void deteleProfesor() {
        System.out.println("Enter profesor cnp");
        int id = scanner.nextInt();
        scanner.nextLine();
        Profesori profesori = profesoriDao.findProfesorByID(id);
        profesoriDao.deleteProfesor(profesori);

    }
}
