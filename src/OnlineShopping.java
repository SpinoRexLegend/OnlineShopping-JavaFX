import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class OnlineShopping implements Initializable {
    @FXML
    private Button save, payment;
    @FXML
    private Spinner<Integer> altairNo, ezioNo, desmondNo, edwardNo, connorNo, arnoNo;
    @FXML
    private TextField altairPrice, ezioPrice, desmondPrice, edwardPrice, connorPrice, arnoPrice;
    @FXML
    private TextField altairPriceT, ezioPriceT, desmondPriceT, edwardPriceT, connorPriceT, arnoPriceT;
    @FXML
    private TextField totalPrice;

    Database database = new Database();

    HashMap<String, Integer> orders = new HashMap<>();

    public String userName;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addSpinner(null);
        addPrice(null);
        updatePrice(null);
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    private double updatePrice(ActionEvent event) {
        double take1 = altairNo.getValue() * database.getPrice("Altair");
        double take2 = ezioNo.getValue() * database.getPrice("Ezio");
        double take3 = desmondNo.getValue() * database.getPrice("Desmond");
        double take4 = edwardNo.getValue() * database.getPrice("Edward");
        double take5 = connorNo.getValue() * database.getPrice("Connor");
        double take6 = arnoNo.getValue() * database.getPrice("Arno");

        altairPriceT.setText(Double.toString(take1));
        ezioPriceT.setText(Double.toString(take2));
        desmondPriceT.setText(Double.toString(take3));
        edwardPriceT.setText(Double.toString(take4));
        connorPriceT.setText(Double.toString(take5));
        arnoPriceT.setText(Double.toString(take6));

        return take1+take2+take3+take4+take5+take6;
    }

    public void addSpinner(ActionEvent event)
    {
        altairNo.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Math.min(database.getQty("Altair"), 10), 0));
        ezioNo.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Math.min(database.getQty("Ezio"), 10), 0));
        desmondNo.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Math.min(database.getQty("Desmond"), 10), 0));
        edwardNo.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Math.min(database.getQty("Edward"), 10), 0));
        connorNo.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Math.min(database.getQty("Connor"), 10), 0));
        arnoNo.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Math.min(database.getQty("Arno"), 10), 0));
    }

    public void addPrice(ActionEvent event) {
        altairPrice.setText(Double.toString(database.getPrice("Altair")));
        ezioPrice.setText(Double.toString(database.getPrice("Ezio")));
        desmondPrice.setText(Double.toString(database.getPrice("Desmond")));
        edwardPrice.setText(Double.toString(database.getPrice("Edward")));
        connorPrice.setText(Double.toString(database.getPrice("Connor")));
        arnoPrice.setText(Double.toString(database.getPrice("Arno")));
    }
    public void displayPrice(ActionEvent event)
    {
        orders.put("Altair", altairNo.getValue());
        orders.put("Ezio", ezioNo.getValue());
        orders.put("Desmond", desmondNo.getValue());
        orders.put("Edward", edwardNo.getValue());
        orders.put("Connor", connorNo.getValue());
        orders.put("Arno", arnoNo.getValue());
    }

    public void savePrice(ActionEvent event) {
        displayPrice(null);
        totalPrice.setText(Double.toString(updatePrice(null)));
    }

    public void proceedToPayment(ActionEvent event) {
        database.changeData(orders);
        database.addList(orders, userName);
    }
}
