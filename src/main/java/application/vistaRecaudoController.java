package application;

import datos.ClientesDAO;
import datos.RecaudoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

public class vistaRecaudoController {

    @FXML
    private TableColumn<?, ?> AmountTable;

    @FXML
    private MenuButton CuentaScroll;

    @FXML
    private TableColumn<?, ?> DateTable;

    @FXML
    private TableColumn<?, ?> DescripTable;

    @FXML
    private TableColumn<?, ?> IdentTable;

    @FXML
    private TableColumn<?, ?> InvoiceTable;

    @FXML
    private Label LabelNamePag;

    @FXML
    private Label LabelNumRef;

    @FXML
    private Label Labelinfo;

    @FXML
    private TableColumn<?, ?> NameTable;

    @FXML
    private TableColumn<?, ?> NumRefTable;

    @FXML
    private Rectangle Rectangulo;

    @FXML
    private TableView<?> TablaDatos;

    @FXML
    private TextField TextNumRef;

    @FXML
    private TextField TextTotalsum;

    @FXML
    private Label TotalTitulo;

    @FXML
    private Button botonBuscar;

    @FXML
    void AddRef(ActionEvent event) {

    }

    @FXML
    void Cuenta(ActionEvent event) {

    }

    @FXML
    void MostrarDatos(ActionEvent event) {

    }

    @FXML
    void MostrarTotal(ActionEvent event) {

    }

    @FXML
    void buscar(ActionEvent event) {
    	RecaudoDAO recaudoDAO = new RecaudoDAO();
    	ClientesDAO clienteDao = new ClientesDAO();
    	String mensaje1 = recaudoDAO.selectByRef(TextNumRef.getText());
    	String string = mensaje1;
    	String[] parts = string.split(",");
    	String id = parts[0]; 
    	String noref = parts[1];
    	String valor = parts[2]; 
    	String fecha = parts[3];
    	String mensaje2 = clienteDao.devolverString(Integer.parseInt(id));
    	String mensaje3 = mensaje1 + "," + mensaje2;
    	System.out.println(mensaje3);
    	
    	

    }

}
