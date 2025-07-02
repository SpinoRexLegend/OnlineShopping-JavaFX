import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Cart {
    @FXML
    private Button toShoppage2, toShoppage1, procceedToPayment2, procceedToPayment1;
    @FXML
    private Rectangle rectangle1, rectangle2, rectangle3, rectangle4, rectangle5, rectangle6;
    @FXML
    private Label nameLabel1, nameLabel2, nameLabel3, nameLabel4, nameLabel5, nameLabel6;
    @FXML
    private TextField qty1, qty2, qty3, qty4, qty5, qty6;
    @FXML
    private TextField total1, total11, total111, total1111, total11111, total111111;
    @FXML
    private TextField unitPrice1, unitPrice2, unitPrice3, unitPrice4, unitPrice5, unitPrice6;
    @FXML
    private ImageView imgView1, imgView2, imgView3, imgView4, imgView5, imgView6;
    @FXML
    private AnchorPane anchorToChange;

    Database database = new Database();
    OnlineShopping onlineShopping = new OnlineShopping();

    Image altair = new Image("Altair.jpeg");
    Image ezio = new Image("Ezio.jpeg");
    Image desmond = new Image("Desmond.jpeg");
    Image edward = new Image("Edward.jpeg");
    Image connor = new Image("Connor.jpeg");
    Image arno = new Image("arno.jpeg");

    private HashMap<String, Integer> orders = new HashMap<String, Integer>();
    private String userName;


    public void upDateCart(HashMap<String, Integer> hash)
    {
        hideAll();
        for(String key: hash.keySet())
        {
            if(hash.get(key) > 0)
            {
                switch(key)
                {
                    case "Altair":
                        update(altair, "Altair Ibn-La'Ahad", hash.get(key), database.getPrice(key));
                        break;
                    case "Ezio":
                        update(ezio, "Ezio Auditore de Firenze", hash.get(key), database.getPrice(key));
                        break;
                    case "Desmond":
                        update(desmond, "Desmond Miles", hash.get(key), database.getPrice(key));
                        break;
                    case "Edward":
                        update(edward, "Edward James Kenway", hash.get(key), database.getPrice(key));
                        break;
                    case "Connor":
                        update(connor, "Connor Kenway", hash.get(key), database.getPrice(key));
                        break;
                    case "Arno":
                        update(arno, "Arno Dorian", hash.get(key), database.getPrice(key));
                        break;

                }
            }
        }
    }
    public void hideAll()
    {
        anchorToChange.setLayoutY(550);

        toShoppage1.setVisible(false);
        procceedToPayment1.setVisible(false);
        toShoppage2.setVisible(false);
        procceedToPayment2.setVisible(false);

        rectangle1.setVisible(false);
        rectangle2.setVisible(false);
        rectangle3.setVisible(false);
        rectangle4.setVisible(false);
        rectangle5.setVisible(false);
        rectangle6.setVisible(false);

        imgView1.setVisible(false);
        imgView2.setVisible(false);
        imgView3.setVisible(false);
        imgView4.setVisible(false);
        imgView5.setVisible(false);
        imgView6.setVisible(false);

        nameLabel1.setVisible(false);
        nameLabel2.setVisible(false);
        nameLabel3.setVisible(false);
        nameLabel4.setVisible(false);
        nameLabel5.setVisible(false);
        nameLabel6.setVisible(false);

        qty1.setVisible(false);
        qty2.setVisible(false);
        qty3.setVisible(false);
        qty4.setVisible(false);
        qty5.setVisible(false);
        qty6.setVisible(false);

        total1.setVisible(false);
        total11.setVisible(false);
        total111.setVisible(false);
        total1111.setVisible(false);
        total11111.setVisible(false);
        total111111.setVisible(false);

        unitPrice1.setVisible(false);
        unitPrice2.setVisible(false);
        unitPrice3.setVisible(false);
        unitPrice4.setVisible(false);
        unitPrice5.setVisible(false);
        unitPrice6.setVisible(false);

    }

    public void update(Image image, String name, int qty, double unitprice) {

        if (imgView1.getImage() == null) {
            imgView1.setImage(image);
            nameLabel1.setText(name);
            qty1.setText(Integer.toString(qty));
            total1.setText(Double.toString(qty*unitprice));
            unitPrice1.setText(Double.toString(unitprice));

            toShoppage1.setVisible(true);
            procceedToPayment1.setVisible(true);

            rectangle1.setVisible(true);

            imgView1.setVisible(true);

            nameLabel1.setVisible(true);

            qty1.setVisible(true);

            total1.setVisible(true);

            unitPrice1.setVisible(true);

        } else if (imgView2.getImage() == null) {
            imgView2.setImage(image);
            nameLabel2.setText(name);
            qty2.setText(Integer.toString(qty));
            total11.setText(Double.toString(qty*unitprice));
            unitPrice2.setText(Double.toString(unitprice));

            rectangle2.setVisible(true);

            imgView2.setVisible(true);

            nameLabel2.setVisible(true);

            qty2.setVisible(true);

            total11.setVisible(true);

            unitPrice2.setVisible(true);
        }

        else if (imgView3.getImage() == null) {
            imgView3.setImage(image);
            nameLabel3.setText(name);
            qty3.setText(Integer.toString(qty));
            total111.setText(Double.toString(qty*unitprice));
            unitPrice3.setText(Double.toString(unitprice));

            rectangle3.setVisible(true);

            imgView3.setVisible(true);

            nameLabel3.setVisible(true);

            qty3.setVisible(true);

            total111.setVisible(true);

            unitPrice3.setVisible(true);
        }
        else if (imgView4.getImage() == null) {
            imgView4.setImage(image);
            nameLabel4.setText(name);
            qty4.setText(Integer.toString(qty));
            total1111.setText(Double.toString(qty*unitprice));
            unitPrice4.setText(Double.toString(unitprice));

            toShoppage1.setVisible(false);
            toShoppage2.setVisible(true);
            procceedToPayment1.setVisible(false);
            procceedToPayment2.setVisible(true);

            anchorToChange.setLayoutY(1000);

            rectangle4.setVisible(true);

            imgView4.setVisible(true);

            nameLabel4.setVisible(true);

            qty4.setVisible(true);

            total1111.setVisible(true);

            unitPrice4.setVisible(true);
        }
        else if (imgView5.getImage() == null) {
            imgView5.setImage(image);
            nameLabel5.setText(name);
            qty5.setText(Integer.toString(qty));
            total11111.setText(Double.toString(qty*unitprice));
            unitPrice5.setText(Double.toString(unitprice));

            toShoppage1.setVisible(false);
            toShoppage2.setVisible(true);
            procceedToPayment1.setVisible(false);
            procceedToPayment2.setVisible(true);

            rectangle5.setVisible(true);

            imgView5.setVisible(true);

            nameLabel5.setVisible(true);

            qty5.setVisible(true);

            total11111.setVisible(true);

            unitPrice5.setVisible(true);
        }
        else
        {
            imgView6.setImage(image);
            nameLabel6.setText(name);
            qty6.setText(Integer.toString(qty));
            total111111.setText(Double.toString(qty*unitprice));
            unitPrice6.setText(Double.toString(unitprice));

            rectangle6.setVisible(true);

            imgView6.setVisible(true);

            nameLabel6.setVisible(true);

            qty6.setVisible(true);

            total111111.setVisible(true);

            unitPrice6.setVisible(true);

        }
    }


    public void toShopPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OnlineShopping.fxml"));
        Parent root = loader.load();
        OnlineShopping onlineController = loader.getController();
        onlineController.addSpinner(null);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.show();
    }

    public void proceedToPayment(ActionEvent event) throws IOException {
        database.addList(orders, userName);
        database.changeData(orders);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderConfirmPage.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.show();
    }

    public void setData(HashMap<String, Integer> orders, String userName) {
        this.orders = orders;
        this.userName = userName;
    }
}



