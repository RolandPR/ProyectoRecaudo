package application;

import datos.ClientesDAO;
import datos.RecaudoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;

public class vistaRecaudoController {

    @FXML
    private TableColumn<Persona, String> AmountTable;

    @FXML
    private MenuButton CuentaScroll;

    @FXML
    private TableColumn<Persona, String> DateTable;

    @FXML
    private TableColumn<Persona, String> DescripTable;

    @FXML
    private TableColumn<Persona, String> IdentTable;

    @FXML
    private TableColumn<Persona, String> InvoiceTable;

    @FXML
    private Label LabelNamePag;

    @FXML
    private Label LabelNumRef;

    @FXML
    private Label Labelinfo;

    @FXML
    private TableColumn<Persona, String> NameTable;

    @FXML
    private TableColumn<Persona, String> NumRefTable;

    @FXML
    private Rectangle Rectangulo;

    @FXML
    private TableView<Persona> TablaDatos;

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

        String[] partsMensaje3 = mensaje3.split(",");
        String numeroReferencia = partsMensaje3[1];
        String valorPago = partsMensaje3[2];
        String fechaLimitePago = partsMensaje3[3];
        String nombre = partsMensaje3[4];
        String numeroDocumento = partsMensaje3[5];

        TextTotalsum.setText(valorPago);

        Persona persona = new Persona(numeroReferencia, numeroDocumento, nombre, fechaLimitePago, "Movistar",
                valorPago);

        ObservableList<Persona> observableList = FXCollections.observableArrayList(persona);
        NumRefTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("noRef"));
        IdentTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("docId"));
        NameTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("name"));
        DateTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("date"));
        DescripTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("descrip"));
        AmountTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("amount"));

        TablaDatos.setItems(observableList);

    }

}
