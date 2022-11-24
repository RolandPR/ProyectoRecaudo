package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class PrimaryController {

    @FXML
    private Button CargarDocumento;

    @FXML
    private ImageView IconoCargarArchivo;

    @FXML
    private ImageView iconoUsuario;

    @FXML
    private MenuButton menuUser;

    
    
    
    public void showInformationDialog() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Confirmación");
    	alert.setHeaderText(null);
    	alert.setContentText("El archivo ha sido cargado correctamente");
    	alert.setGraphic(new ImageView(this.getClass().getResource("VerificacionSinFondo.png").toString()));
    	alert.show();
    }
    
    public void showWarningDialog() {
    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("Aviso");
    	alert.setHeaderText(null);
    	alert.setContentText("No se ha cargado ningun archivo");
    	alert.show();
    }

    @FXML
    void Open(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Explorador de archivos");
    	fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));
    	File selectedFile = fileChooser.showOpenDialog(null);
    	
    	
    	if(selectedFile != null) {
    		showInformationDialog();
    	}else {
    		showWarningDialog();
    	}


    }

}
