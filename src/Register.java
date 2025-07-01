import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Register {

    @FXML
    private Button submit;
    @FXML
    private TextField userName;
    @FXML
    private Label statusLabel;
    @FXML
    private PasswordField password1, password2;
    @FXML
    private Hyperlink loginPage;

    CustomerDatabse database = new CustomerDatabse();

    public void returnToLoginPage(ActionEvent event) throws IOException
    {
        Parent newNode = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(newNode);
        stage.setScene(newScene);
        stage.show();
    }

    public void submitForm()
    {
        if(database.checkUserName(userName.getText()))
        {
            statusLabel.setText("UserName Already Exists");
            password1.setText("");
            password1.setText("");
            userName.setText("");
        }
        else if(!password1.getText().equals(password2.getText()))
        {
            statusLabel.setText("Entered Passwords do not match");
            password1.setText("");
            password1.setText("");
        }
        else if(userName.getText().isEmpty() || password1.getText().isEmpty() || password2.getText().isEmpty())
        {
            statusLabel.setText("One or More Fields Empty");
        }
        else {
            database.addUser(userName.getText(), password1.getText());
            statusLabel.setText("Registration Successful");
        }
    }
}
