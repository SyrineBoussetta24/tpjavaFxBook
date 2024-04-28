package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Window;

public class AddBookControlor implements Initializable {
	 @FXML
	 private TextField tfLastName;
	 @FXML
	 private TextField tfFirstName;
	 @FXML
	 private TextField tfEmail;
	 @FXML
	 private Button addBtn;
	 @FXML
	 private Button exportBtn;
	 @FXML
	 private Button importBtn;
	 @FXML
	 private Button removeBtn;
	 @FXML
	 private Button quitBtn;
	 @FXML
	 private TableView<Person> table;
	 @FXML
	 private TableColumn<Person, String> emailCol;
	 @FXML
	 private TableColumn<Person, String> firstNameCol;
	 @FXML
	 private TableColumn<Person, String> lastNameCol;
	 private DataClass data=new DataClass();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		firstNameCol.setCellValueFactory(new PropertyValueFactory("prenom"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory("nom"));
		emailCol.setCellValueFactory(new PropertyValueFactory("mail"));
		table.setEditable(true);
		firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	    lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
	    emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
	}
	
	@FXML
    void add(ActionEvent event){
		 String firstName = tfFirstName.getText();
	        String lastName = tfLastName.getText();
	        String email = tfEmail.getText();
	        Window owner = addBtn.getScene().getWindow();
	        
	        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
	        	Alert alert = new Alert(AlertType.ERROR);
	        	 alert.setHeaderText(null);
	        	 alert.setContentText("Veuillez remplir tous les champs");
	        	 alert.initOwner(owner);
	        	 alert.show();}
	        

	        else if (!isEmailAddress(email)) {
	        	Alert alert = new Alert(AlertType.ERROR);
	        	 alert.setHeaderText(null);
	        	 alert.setContentText("email incorrect ! ");
	        	 alert.initOwner(owner);
	        	 alert.show();
	        }
	        else {
	        table.getItems().add(new Person(firstName, lastName, email));}
	    }
	 @FXML
	    void exportBtn(ActionEvent event) {
	    	DataClass d = new DataClass();
	    	List<Person> p = table.getItems();
	    	d.setExportList(p);
	    	System.out.println(d.getExportList());

	    }


	    @FXML
	    void importBtn(ActionEvent event) {
	    	for(Person p : data.getImportList()) {
	    		table.getItems().add(p);
	    	}
	    }
	    
	    @FXML
	    void quitBtn(ActionEvent event) {
	    	Window owner = quitBtn.getScene().getWindow();
	        Platform.exit();
	    }

	    @FXML
	    void removeBtn(ActionEvent event) {
	    	Person p = table.getSelectionModel().getSelectedItem();
	    	table.getItems().remove(p);
	    }
	    public static boolean isEmailAddress(String email) {
	        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
	        Matcher m = p.matcher(email.toUpperCase());
	        return m.matches();
	    }
	    
	    

	 


}