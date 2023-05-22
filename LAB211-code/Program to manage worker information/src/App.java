import View.View_Worker;

public class App {
    public static void main(String[] args) throws Exception {
        View_Worker view = new View_Worker();
        do {
            view.displayMenu();
        } while (true);
    }
}
