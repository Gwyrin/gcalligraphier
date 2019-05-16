/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcalligraphier.ctrl;

import gcalligraphier.bean.Params;
import gcalligraphier.io.WrkIO;
import gcalligraphier.wrk.Worker;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Vincent
 */
public class MainViewController implements Initializable {

    @FXML
    private TextArea txt;
    @FXML
    private ComboBox<String> cmbRandomize;
    @FXML
    private TextField minRed;
    @FXML
    private TextField maxRed;
    @FXML
    private TextField minGreen;
    @FXML
    private TextField maxGreen;
    @FXML
    private TextField minBlue;
    @FXML
    private TextField maxBlue;
    @FXML
    private TextField minSize;
    @FXML
    private TextField maxSize;

    
    private Worker wrk ;
    private WrkIO wrkIO ;
    @FXML
    private CheckBox chkFont;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbRandomize.getItems().add("Characters");
        cmbRandomize.getItems().add("Words");
        cmbRandomize.getItems().add("Paragraphs");
        cmbRandomize.getItems().add("Text");
        cmbRandomize.getSelectionModel().select(0);
        wrk = new Worker();
        wrkIO = new WrkIO();
    }    

    @FXML
    private void linkGwyrin(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("http://www.gwyrin.ch"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void linkTwitter(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("http://www.twitter.com/Gwyrin"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void randomize(ActionEvent event) {
        Params p = new Params();
        p.setMaxR(getAndVerifyValue(maxRed, 0, 255));
        p.setMaxG(getAndVerifyValue(maxGreen, 0, 255));
        p.setMaxB(getAndVerifyValue(maxBlue, 0, 255));
        p.setMinR(getAndVerifyValue(minRed, 0, 255));
        p.setMinG(getAndVerifyValue(minGreen, 0, 255));
        p.setMinB(getAndVerifyValue(minBlue, 0, 255));
        p.setMaxSize(getAndVerifyValue(maxSize, 1, 1000));
        p.setMinSize(getAndVerifyValue(minSize, 1, 1000));
        p.setRandomfonts(chkFont.isSelected());
        p.setMode(cmbRandomize.getSelectionModel().getSelectedItem());
        ArrayList<String> r = new ArrayList<>();
        r.add(wrk.caligraph(txt.getText(), p));
        wrkIO.writeTextFile("result.html", r);
        try {
            Desktop.getDesktop().open(new File("result.html"));
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int getAndVerifyValue(TextField input, int min, int max){
        String in = input.getText();
        int result = 0;
        try{
            result = Integer.parseInt(in);
        }catch(NumberFormatException e){
            
        }
        if (result > max){
            result = max;
        }
        if (result < min){
            result = min;
        }
        input.setText(result+"");
        return result;
    }    
}
