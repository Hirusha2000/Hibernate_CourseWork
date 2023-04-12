import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.ijse.Hostel_Management_System.bo.BOFactory;
import lk.ijse.Hostel_Management_System.bo.custom.LoginBO;
import lk.ijse.Hostel_Management_System.entity.Student;
import lk.ijse.Hostel_Management_System.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.time.LocalDate;


public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("lk/ijse/Hostel_Management_System/view/LoginForm.fxml"))));
        primaryStage.setTitle("D24 HOSTEL MANAGEMENT SYSTEM powered by HUG SOLUTIONS@2023");
       /* Image image =new Image("view/assests/images/d24.PNG");
       primaryStage.getIcons().add(image);*/
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();




    }
}
