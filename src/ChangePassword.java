import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangePassword {

    @FXML
    private Button changePasswordButton, verifyNameButton;
    @FXML
    private Label checkUserNameLabel, statusPasswd;
    @FXML
    private PasswordField firstPassword, secondPassword;
    @FXML
    private TextField verifyUserName;

    String userName, passwd1, passwd2;
    CustomerDatabse database = new CustomerDatabse();

    public void changePassword(ActionEvent event)
    {
        userName = verifyUserName.getText();
        if(userName.isEmpty()) checkUserNameLabel.setText("Please type UserName First");
        else {
            passwd1 = firstPassword.getText();
            passwd2 = secondPassword.getText();
            if(database.changePassword(userName, passwd1, passwd2)) statusPasswd.setText("SuccessFully Updated");
            else statusPasswd.setText("Entered Passwords do not match");
            verifyNameButton.setText("");
            firstPassword.setText("");
            secondPassword.setText("");
        }

    }

    public void verifyUserName(ActionEvent event)
    {
        userName = verifyUserName.getText();
        if(!database.checkUserName(userName))
            checkUserNameLabel.setText("Well it seems that this username doesn't exists in our database");
        else
            checkUserNameLabel.setText("User exits in database :>");
    }

    public void getToLogin(ActionEvent event) throws IOException {
        Parent newNode = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(newNode);
        stage.setScene(newScene);
        stage.show();
    }
}
