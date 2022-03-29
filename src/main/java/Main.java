import Controller.QueueManagementController;
import View.QueueManagementView;

public class Main {
    public static void main(String[] args) {
        QueueManagementView view = new QueueManagementView();
        QueueManagementController controller = new QueueManagementController(view);
        view.frame.setVisible(true);
    }
}
