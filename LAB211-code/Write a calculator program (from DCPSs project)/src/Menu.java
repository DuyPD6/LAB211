public class Menu {
    Validate validate = new Validate();
    Controller controller = new Controller();

    public void displayMenu() {
        int choice;
        do {
            System.out.println("==========Calculator Program==========");
            System.out.println("1.  Addition Matrix");
            System.out.println("2.  Subtraction Matrix");
            System.out.println("3.  Multiplication Matrix");
            System.out.println("4.  Quit");
            choice = validate.getIntLimit("Your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("-----------------Addition-----------------");
                    controller.additionMatrix(choice);
                    break;
                case 2:
                    System.out.println("-----------------Subtraction-----------------");
                    controller.subtractionMatrix(choice);
                    break;
                case 3:
                    System.out.println("-----------------Multiplication-----------------");
                    controller.multiplicationMatrix(choice);
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input is not valid!");
                    System.exit(0);
            }
        } while (true);
    }
}
