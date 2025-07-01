import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPage implements Initializable {
    @FXML
    private Button login, reset;
    @FXML
    private Label registerId, headerLabel;
    @FXML
    private PasswordField password;
    @FXML
    private TextField userName;

    String user, pass;
    CustomerDatabse database = new CustomerDatabse();

    public void submit(ActionEvent event) throws IOException {
        user = userName.getText();
        pass = password.getText();
        if(database.checkUserPassword(user,pass))
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("OnlineShopping.fxml"));
            Parent root = loader.load();
            OnlineShopping online = loader.getController();
            online.setUserName(user);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
            stage.show();
        }
        else
        {
            password.setText("");
            registerId.setText("Incorrect Id/Password");
        }
    }
    public void reset(ActionEvent event)
    {
        password.setText("");
        userName.setText("");
    }
    public void resetPassword(ActionEvent event) throws IOException {
        Parent newNode = FXMLLoader.load(getClass().getResource("changePassword.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(newNode);
        stage.setScene(newScene);
        stage.show();
    }


    public void register(ActionEvent event) throws IOException {
        Parent newNode = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(newNode);
        stage.setScene(newScene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
