
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class PasswordController implements Initializable {

    @FXML
    private Button btnsms;
    @FXML
    private TextField smstextfield;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }
    
            
    @FXML
    private void sendsms(ActionEvent event) {
       
        
        if (smstextfield.getText().isEmpty())
              
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("NOT OK");
            alert.setHeaderText("veuillez saisir votre NUMERO ");
            alert.setContentText("Click cancel to exit.");
            alert.showAndWait();
            
        }
        
        String sms = smstextfield.getText().trim();
        if (isValidPhoneNumber(sms)) {
            sendsms(sms,generatepassword());
            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle(" OK");
            alert.setHeaderText(" Message envoyer ! ");
            alert.setContentText("Click cancel to exit.");
            alert.showAndWait();
        }
        else{
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("NOT OK");
            alert.setHeaderText(" Numéro ivalide ");
            alert.setContentText("Click cancel to exit.");
            alert.showAndWait();;
        }
        
        
        
    }
    
    private boolean isValidPhoneNumber(String sms){
        return true;
    }
    
    private String generatepassword(){
        return "password123";
     }
    private void sendsms(String sms,String password){
        
         }
     
    public static void main(String[] args){
        
      launch(args);
    }

}
