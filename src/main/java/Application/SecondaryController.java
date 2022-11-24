package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelos.Usuario;

import datos.UsuariosDao;

public class SecondaryController {

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
		if (usuarioDao.selectByClave(usuario) != null) {
			System.out.println("cambio de ventana");
		} else {

			System.out.println("usuario y/o contrasenna incorrecto");
		}

	}

	@FXML
	void usuario(ActionEvent event) {

	}

}