package application;

import java.io.IOException;

import datos.UsuariosDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelos.Usuario;

public class vistaLoginController {

    @FXML
    private Label Labelniciarsesion;

    @FXML
    private PasswordField PswrdfIeld;

    @FXML
    private TextArea TxtAmswelcome;

    @FXML
    private Button bttnigresar;

    @FXML
    private TextField txfusuario;

    @FXML
    void Contrasenna(ActionEvent event) {

    }

    @FXML
	void LoginUsuario(ActionEvent event) {
		String nombre = txfusuario.getText();
		System.out.println(nombre);
		String clave = PswrdfIeld.getText();
		Usuario usuario = new Usuario(nombre, clave);
		UsuariosDao usuarioDao = new UsuariosDao();
		Usuario usuarioCambioVentana = usuarioDao.selectByClave(usuario);
		
		switch (usuarioCambioVentana.getIdRol()) {
		case 1:
			try {
				Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
		        Scene scene = new Scene(root,600,460);
		        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        appStage.setScene(scene);
		        appStage.setResizable(false);
		        appStage.toFront();
		        appStage.show();
		        
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				Parent root = FXMLLoader.load(getClass().getResource("secundary.fxml"));
		        Scene scene = new Scene(root,600,460);
		        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        appStage.setScene(scene);
		        appStage.setResizable(false);
		        appStage.toFront();
		        appStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				Parent root = FXMLLoader.load(getClass().getResource("vistaRecaudo.fxml"));
		        Scene scene = new Scene(root,775,519);
		        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		        appStage.setScene(scene);
		        appStage.setResizable(false);
		        appStage.toFront();
		        appStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		
	
			
		}
		
//		if (usuarioCambioVentana.getIdRol() == 1) {
//			try {
//				App.setRoot("primary");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}else if () {
//				
//			}
//			
//		} else {
//
//			System.out.println("usuario y/o contrasenna incorrecto");
//		}
		

	}

    @FXML
    void usuario(ActionEvent event) {

    }

}
