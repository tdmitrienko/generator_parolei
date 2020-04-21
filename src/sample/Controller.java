package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.GeneratorParol;

import javax.security.auth.login.LoginException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class Controller  implements Initializable {
    public ChoiceBox maxlength=new ChoiceBox();
    public ChoiceBox kolvoParolei=new ChoiceBox();
    public RadioButton pervayBukva;
    public RadioButton az;
    public RadioButton AZ;
    public RadioButton number;
    public RadioButton simvol;
    public RadioButton ay;
    public RadioButton AY;
    public TextArea text;
    public RadioButton caesar;
    public TextArea text1;
    public GeneratorParol generatorParol;
    public String []s=new String[20];
    public RadioButton MD5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        maxlength.getItems().addAll(10,7,5);
        kolvoParolei.getItems().addAll(10,7,5);
    }

    public void rez(ActionEvent actionEvent) {
        text.setText(" ");
        int max = (int) maxlength.getValue();
        int kolvo = (int) kolvoParolei.getValue();
        for (int i = 0; i < kolvo; i++) {
        generatorParol = new GeneratorParol(max);
            if (ay.isSelected()) {
                generatorParol.FilterRusMal(max);
            }
            if (AY.isSelected()) {
                generatorParol.FilterRusBig(max);
            }
            if (AZ.isSelected()) {
                generatorParol.FilterEngBig(max);
            }
            if (az.isSelected()) {
                generatorParol.FilterEngMal(max);
            }
            if (number.isSelected()) {
                generatorParol.FilterNumber(max);
            }
            if (simvol.isSelected()) {
                generatorParol.FilterSimvol(max);
            }
            s[i]=generatorParol.parol();
            text.setText(text.getText() + s[i] + "\n");
        }
    }

    public void shifr(ActionEvent actionEvent) throws NoSuchAlgorithmException, LoginException {
        text1.setText(" ");
        int kolvo = (int) kolvoParolei.getValue();
        for (int i = 0; i < kolvo; i++) {
            if(caesar.isSelected()){
                text1.setText(text1.getText() +generatorParol.caesar(s[i]) + "\n");
            }
            if(MD5.isSelected()){
                text1.setText(text1.getText() +generatorParol.MD5(s[i]) + "\n");
            }
        }
    }
}
