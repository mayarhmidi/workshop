/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.security.rsa.RSACore;
import tools.MaConnection;

/**
 * FXML Controller class
 *
 * @author Mayy
 */
public class LoginController implements Initializable {

    @FXML
    private Label labelemail2;
    @FXML
    private Label labelmotdepasse2;
    @FXML
    private TextField textemail2;
    @FXML
    private PasswordField textmotdepasse2;
    @FXML
    private Button btnseconnecter;
    @FXML
    private RadioButton btnartiste;
    @FXML
    private AnchorPane checkartiste;
    @FXML
    private RadioButton checkadmin;
    @FXML
    private RadioButton checkmembre;
    @FXML
    private Hyperlink linkpwd;

   
    Connection cnx ;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       cnx = MaConnection.getInstance().getCnx();  
    }    

    @FXML
    private void gotopwd(ActionEvent event) {
        
        
         try {
            
            Parent loader = FXMLLoader.load(getClass().getResource("password.fxml"));
            linkpwd.getScene().setRoot(loader);
        } 
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void login(ActionEvent event) {
        
        String email = textemail2.getText();
        String pwd = textmotdepasse2.getText();
        
         if (textemail2.getText().isEmpty())
              
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("NOT OK");
            alert.setHeaderText(" veuillez saisir votre EMAIL ");
            alert.setContentText("Click cancel to exit.");
            alert.showAndWait();
            
        }
          if (textmotdepasse2.getText().isEmpty())
              
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("NOT OK");
            alert.setHeaderText(" veuillez saisir votre MOT DE PASSE ");
            alert.setContentText("Click cancel to exit.");
            alert.showAndWait();
            
        }
          
          else {
          
             try {
                 String sql = "select * from utilisateur where email=? and mot_de_passe=?" ;
                 
                 PreparedStatement ste = cnx.prepareStatement(sql);
                 
                 ste.setString(1, email);
                 ste.setString(2, pwd);
                 
                 ResultSet s = ste.executeQuery(sql);
                 
                 if (s.next()) {
                     Alert alert = new Alert(AlertType.CONFIRMATION);
                     alert.setTitle("OK");
                     alert.setHeaderText(" Login Success ");
                     alert.setContentText("Click cancel to exit.");
                     alert.showAndWait();
                 }
                 
                 else{
                     Alert alert = new Alert(AlertType.ERROR);
                     alert.setTitle("NOT OK");
                     alert.setHeaderText(" Login failed ");
                     alert.setContentText("Click cancel to exit.");
                     alert.showAndWait();
                 }
                 
             } 
             catch (SQLException ex) {
                 Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
          
          }
        
    }
  
   

  }
    

