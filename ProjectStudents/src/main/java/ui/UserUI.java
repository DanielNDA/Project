package ui;

import java.util.Scanner;

public class UserUI {

    private CursUi cursUi = new CursUi();
    private OrarUi orarUi = new OrarUi();
    private StudentUi studentUi = new StudentUi();
    private ProfesorUi profesorUi = new ProfesorUi();
    private SaliUi saliUi = new SaliUi();

    public void startUserUI() {

        Scanner scanner = new Scanner(System.in);

        int option = -1;

        while (option != 0) {
            System.out.println("User UI");
            System.out.println("1. Student Management");
            System.out.println("2. Profesor Management");
            System.out.println("3. Curs Management");
            System.out.println("4. Orar Management");
            System.out.println("5. Sala Management");
            System.out.println("0. Exit");
            option = scanner.nextInt();
            if (option == 1) {
                studentUi.startStudentUi();
            }
            if (option == 2) {
                profesorUi.startProfesorUi();
            }
            if (option == 3) {
                cursUi.startCursUi();
            }
            if (option == 4) {
                orarUi.startOrarUi();
            }
            if (option == 5) {
                saliUi.startSaliUi();
            }
        }

    }
}
