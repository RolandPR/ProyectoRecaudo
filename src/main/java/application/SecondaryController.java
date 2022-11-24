package application;

import modelos.Usuario;
import datos.UsuariosDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class SecondaryController {

    @FXML
    private TextField apellido;

    @FXML
    private TextField cedula;

    @FXML
    private PasswordField contrasenia;

    @FXML
    private ImageView iconoUsuario;

    @FXML
    private Line lineaDer;

    @FXML
    private Line lineaIzq;

    @FXML
    private MenuButton menuUser;

    @FXML
    private TextField nombre;

    @FXML
    private Button registro;

    @FXML
    private TextField usuario;
    
    @FXML
    private MenuButton roles;
    
    @FXML
    private Label rolEscogido;
    
    
    
    
    public void showInformationDialog() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Confirmación");
    	alert.setHeaderText(null);
    	alert.setContentText("El usuario se ha registrado correctamente");
    	alert.setGraphic(new ImageView(this.getClass().getResource("VerificacionSinFondo.png").toString()));
    	alert.show();
    }
    
    public void showInformationUsuarioRepetido() {
    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("Información");
    	alert.setHeaderText(null);
    	alert.setContentText("El usuario ya se encuentra registrado");
    	alert.show();
    }
    public void showErrorDialog(int campoError) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Error");
    	alert.setHeaderText(null);
		switch (campoError) {
		case 1: {
			alert.setContentText("El campo nombre es obligatorio");
			break;
		}case 2:{
			alert.setContentText("El campo apellido es obligatorio");
			break;
		}case 3:{
			alert.setContentText("El campo cedula es obligatorio");
			break;
		}case 4:{
			alert.setContentText("El campo usuario es obligatorio");
			break;
		}case 5:{
			alert.setContentText("El campo contraseña es obligatorio");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + campoError);
		}
    	
    	alert.show();
    }
    
    public void validarCampo() {
    	int numero = 0;
    	if(nombre.getText().isEmpty()) {
    		numero =1;
    		showErrorDialog(numero);
    	}else if (apellido.getText().isEmpty()) {
    		numero =2;
    		showErrorDialog(numero);
    	}else if (cedula.getText().isEmpty()) {
    		numero =3;
    		showErrorDialog(numero);
    	}else if (usuario.getText().isEmpty()) {
    		numero =4;
    		showErrorDialog(numero);
    	}else if (contrasenia.getText().isEmpty()) {
    		numero =5;
    		showErrorDialog(numero);
    	}else {
    		registroUsuarios();
    	}
    
    }
    
    public void registroUsuarios() {
    	
    	int rolUsuario = 3;
    	String nombreUsuario = nombre.getText();
    	String apellidoUsuario = apellido.getText();
    	String cedulaUsuario = cedula.getText();
    	String cuentaUsuario = usuario.getText();
    	String ContraseniaUsuario = contrasenia.getText();
    	if(rolEscogido.getText().equals("Administrador")) {
    		rolUsuario = 2;
    	}else if(rolEscogido.getText().equals("Cajero")) {
    		rolUsuario = 3; 
    	}else if(rolEscogido.getText().equals("Operador")) {
    		rolUsuario = 1;
    	}
    	Usuario usuarioRegistroUsuario = new Usuario(rolUsuario, nombreUsuario, apellidoUsuario, cedulaUsuario, cuentaUsuario, ContraseniaUsuario);
    	UsuariosDao usuarioDao = new UsuariosDao();
    	if(usuarioDao.selectByNombreUsuario(usuarioRegistroUsuario) == null && usuarioDao.selectByCedula(usuarioRegistroUsuario) == null) {
    		usuarioDao.insertar(usuarioRegistroUsuario);
        	showInformationDialog();
    	}else {
    		showInformationUsuarioRepetido();
    	}
    	
    	
    }

    @FXML
    void IngresarCedula(ActionEvent event) {

    }

    @FXML
    void IngresarUsuario(ActionEvent event) {

    }

    @FXML
    void ingresarApellido(ActionEvent event) {

    }

    @FXML
    void ingresarContrasenia(ActionEvent event) {

    }

    @FXML
    void ingresarNombre(ActionEvent event) {

    }

    @FXML
    void registroUsuario(ActionEvent event) {
    	validarCampo();
    	

    }
    
    @FXML
    void escogerRol(ActionEvent event) {

    }
    
    @FXML
    void administrador(ActionEvent event) {
    	rolEscogido.setText("Administrador");

    }
    
    @FXML
    void cajero(ActionEvent event) {
    	rolEscogido.setText("Cajero");

    }
    
    @FXML
    void operador(ActionEvent event) {
    	rolEscogido.setText("Operador");

    }

}
