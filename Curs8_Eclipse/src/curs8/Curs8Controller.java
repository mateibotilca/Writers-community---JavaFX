package curs8;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;



public class Curs8Controller implements Initializable {
    
	
	
	@FXML
    private TableView<Carte> tabela_Carti;
    @FXML
    private Tab tab_Carti;
    @FXML
    private Button buton_IncarcareCarti;
    @FXML
    private TableColumn<Carte, Long> atribut_idcarte;
    @FXML
    private TableColumn<Carte, String> atribut_titluC;
    @FXML
    private TableColumn<Carte, Long> atribut_anC;
    @FXML
    private TableColumn<Carte, String> atribut_genC;
    @FXML
    private TableColumn<Carte, Long> atribut_nrpaginiC;
    @FXML
    private TableColumn<Carte, String> atribut_edituraC;
    @FXML
    private TableColumn<Carte, CheckBox> atribut_SelectC;
    @FXML
    private Button buton_StergeCarti;
    @FXML
    private TextField adauga_titluC = new TextField();
    @FXML
    private TextField adauga_anC = new TextField();
    @FXML
    private TextField adauga_genC = new TextField();
    @FXML
    private TextField adauga_nrpaginiC = new TextField();
    @FXML
    private TextField adauga_edituraC = new TextField();
    @FXML
    private Button buton_AdaugaCarti;
    @FXML
    private Button buton_ModificaCarti;
    @FXML
    private TableView<Autor> tabela_Autori;
    @FXML
    private Tab tab_Autori;
    @FXML
    private Button buton_IncarcareAutori;
    @FXML
    private TableColumn<Autor, Long> atribut_idautor;
    @FXML
    private TableColumn<Autor, String> atribut_numeA;
    @FXML
    private TableColumn<Autor, String> atribut_prenumeA;
    @FXML
    private TableColumn<Autor, Long> atribut_nrcartiA;
    @FXML
    private TableColumn<Autor, String> atribut_nationalitateA;
    @FXML
    private TableColumn<Autor, CheckBox> atribut_SelectA;
    @FXML
    private Button buton_StergeAutori;
    @FXML
    private TextField adauga_numeA = new TextField();
    @FXML
    private TextField adauga_prenumeA = new TextField();
    @FXML
    private TextField adauga_nrcartiA = new TextField();
    @FXML
    private TextField adauga_nationalitateA = new TextField();
    @FXML
    private Button buton_AdaugaAutori;
    @FXML
    private Button buton_ModificaAutori;
    @FXML
    private TableView<Scriere> tabela_Scrieri;
    @FXML
    private Tab tab_Scrieri;
    @FXML
    private Button buton_IncarcareScrieri;
    @FXML
    private TableColumn<Scriere, Long> atribut_idscriere;
    @FXML
    private TableColumn<Scriere, String> atribut_numeS;
    @FXML
    private TableColumn<Scriere, String> atribut_prenumeS;
    @FXML
    private TableColumn<Scriere, String> atribut_titluS;
    @FXML
    private TableColumn<Scriere, Long> atribut_durataS;
    @FXML
    private TableColumn<Carte, CheckBox> atribut_SelectS;
    @FXML
    private Button buton_StergeScrieri;
    @FXML
    private TextField adauga_idautorS = new TextField();
    @FXML
    private TextField adauga_idcarteS = new TextField();
    @FXML
    private TextField adauga_durataS = new TextField();
    @FXML
    private Button buton_AdaugaScrieri;
    @FXML
    private Button buton_ModificaScrieri;
	
    
   
    private ObservableList<Carte> dateCarti;
    private ObservableList<Autor> dateAutori;
    private ObservableList<Scriere> dateScrieri;
    private DBOperations jb;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jb = new DBOperations();
    }    

    @FXML
    private void incarcaCarti(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateCarti = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("carti");
        //jb.afisare(rs);
        //System.out.println("test");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
        	dateCarti.add(new Carte(rs.getLong("idcarte"), rs.getString("titlu"), rs.getLong("an"), rs.getString("gen"), rs.getLong("nrpagini"), rs.getString("editura"), Select));
        }
        
        atribut_idcarte.setCellValueFactory(new PropertyValueFactory<>("idcarte"));
        atribut_titluC.setCellValueFactory(new PropertyValueFactory<>("titlu"));
        atribut_anC.setCellValueFactory(new PropertyValueFactory<>("an"));
        atribut_genC.setCellValueFactory(new PropertyValueFactory<>("gen"));
        atribut_nrpaginiC.setCellValueFactory(new PropertyValueFactory<>("nrpagini"));
        atribut_edituraC.setCellValueFactory(new PropertyValueFactory<>("editura"));
        atribut_SelectC.setCellValueFactory(new PropertyValueFactory<>("Select"));
        
        tabela_Carti.setItems(null);
        tabela_Carti.setItems(dateCarti);
        jb.disconnect();
    }

    @FXML
    private void incarcaAutori(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateAutori = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("autori");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
        	dateAutori.add(new Autor(rs.getLong("idautor"), rs.getString("nume"), rs.getString("prenume"), rs.getLong("nrcarti"), rs.getString("nationalitate"), Select));
        }

        atribut_idautor.setCellValueFactory(new PropertyValueFactory<>("idautor"));
        atribut_numeA.setCellValueFactory(new PropertyValueFactory<>("nume"));
        atribut_prenumeA.setCellValueFactory(new PropertyValueFactory<>("prenume"));
        atribut_nrcartiA.setCellValueFactory(new PropertyValueFactory<>("nrcarti"));
        atribut_nationalitateA.setCellValueFactory(new PropertyValueFactory<>("nationalitate"));
        atribut_SelectA.setCellValueFactory(new PropertyValueFactory<>("Select"));
        
        tabela_Autori.setItems(null);
        tabela_Autori.setItems(dateAutori);
        jb.disconnect();
    }   
    
    @FXML
    private void incarcaScrieri(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateScrieri = FXCollections.observableArrayList();

        ResultSet rs = jb.TabelScrieri();
        //jb.afisare(rs);
        //System.out.println("test");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
            dateScrieri.add(new Scriere(rs.getLong("idscriere"), rs.getString("nume"), rs.getString("prenume"), rs.getString("titlu"), rs.getLong("durata"), Select));
        }
        
        atribut_idscriere.setCellValueFactory(new PropertyValueFactory<>("idscriere"));
        atribut_numeS.setCellValueFactory(new PropertyValueFactory<>("nume"));
        atribut_prenumeS.setCellValueFactory(new PropertyValueFactory<>("prenume"));
        atribut_titluS.setCellValueFactory(new PropertyValueFactory<>("titlu"));
        atribut_durataS.setCellValueFactory(new PropertyValueFactory<>("durata"));
        atribut_SelectS.setCellValueFactory(new PropertyValueFactory<>("Select"));

        
        tabela_Scrieri.setItems(null);
        tabela_Scrieri.setItems(dateScrieri);
        jb.disconnect();
    }
    
    @FXML
    private void adaugaAutori(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
        
        String nume = adauga_numeA.getText();
        String prenume = adauga_prenumeA.getText();
        Long nrcarti = Long.parseLong(adauga_nrcartiA.getText());
        String nationalitate = adauga_nationalitateA.getText();
        
        jb.adaugaAutor(nume, prenume, nrcarti, nationalitate);
        
        dateAutori = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("autori");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
        	dateAutori.add(new Autor(rs.getLong("idautor"), rs.getString("nume"), rs.getString("prenume"), rs.getLong("nrcarti"), rs.getString("nationalitate"), Select));
        }
        
        adauga_numeA.clear();
        adauga_prenumeA.clear();
        adauga_nrcartiA.clear();
        adauga_nationalitateA.clear();
        
        tabela_Autori.setItems(null);
        tabela_Autori.setItems(dateAutori);
        jb.disconnect();
    }
    
    @FXML
    private void adaugaCarti(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
        
        String titlu = adauga_titluC.getText();
        Long an = Long.parseLong(adauga_anC.getText());
        String gen = adauga_genC.getText();
        Long nrpagini = Long.parseLong(adauga_nrpaginiC.getText());
        String editura = adauga_edituraC.getText();
        
        
        jb.adaugaCarte(titlu, an, gen, nrpagini, editura);
        
        dateCarti = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("carti");
        while (rs.next()) {
        	CheckBox Select = new CheckBox(null);
        	dateCarti.add(new Carte(rs.getLong("idcarte"), rs.getString("titlu"), rs.getLong("an"), rs.getString("gen"), rs.getLong("nrpagini"), rs.getString("editura"), Select));
        }
        
        adauga_titluC.clear();
        adauga_anC.clear();
        adauga_genC.clear();
        adauga_nrpaginiC.clear();
        adauga_edituraC.clear();
        
        tabela_Carti.setItems(null);
        tabela_Carti.setItems(dateCarti);
        jb.disconnect();
    }
    
    @FXML
    private void adaugaScrieri(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
  
        Long idautor = Long.parseLong(adauga_idautorS.getText());
        Long idcarte = Long.parseLong(adauga_idcarteS.getText());
        Long durata = Long.parseLong(adauga_durataS.getText());
        
        jb.adaugaScriere(idautor, idcarte, durata);
        
        dateScrieri = FXCollections.observableArrayList();

        ResultSet rs = jb.TabelScrieri();
        //jb.afisare(rs);
        //System.out.println("test");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
        	dateScrieri.add(new Scriere(rs.getLong("idscriere"), rs.getString("nume"), rs.getString("prenume"), rs.getString("titlu"), rs.getLong("durata"), Select));
        }
        
        adauga_idautorS.clear();
        adauga_idcarteS.clear();
        adauga_durataS.clear();
        
        tabela_Scrieri.setItems(null);
        tabela_Scrieri.setItems(dateScrieri);
        jb.disconnect();
    }
    
    @FXML
    private void stergeCarti(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
        
        for(int i = 0; i < tabela_Carti.getItems().size(); i ++) {
        	if(tabela_Carti.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Carti.getItems().get(i).getIdcarte();
        		jb.stergeTabela("carti", "idcarte", pk);
        	}
        }
        
      dateCarti = FXCollections.observableArrayList();

      ResultSet rs = jb.vedeTabel("carti");
      while (rs.next()) {
      	CheckBox Select = new CheckBox("");
      	dateCarti.add(new Carte(rs.getLong("idcarte"), rs.getString("titlu"), rs.getLong("an"), rs.getString("gen"), rs.getLong("nrpagini"), rs.getString("editura"), Select));
      }
      
      tabela_Carti.setItems(null);
      tabela_Carti.setItems(dateCarti);
        
        
        jb.disconnect();
    }
    
    @FXML
    private void stergeAutori(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
        
        for(int i = 0; i < tabela_Autori.getItems().size(); i ++) {
        	if(tabela_Autori.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Autori.getItems().get(i).getIdautor();
        		jb.stergeTabela("autori", "idautor", pk);
        	}
        }
        
      dateAutori = FXCollections.observableArrayList();

      ResultSet rs = jb.vedeTabel("autori");
      while (rs.next()) {
      	CheckBox Select = new CheckBox("");
      	dateAutori.add(new Autor(rs.getLong("idautor"), rs.getString("nume"), rs.getString("prenume"), rs.getLong("nrcarti"), rs.getString("nationalitate"), Select));
      }
      
      tabela_Autori.setItems(null);
      tabela_Autori.setItems(dateAutori);
        
        
        jb.disconnect();
    }
    
    @FXML
    private void stergeScrieri(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
        
        for(int i = 0; i < tabela_Scrieri.getItems().size(); i ++) {
        	if(tabela_Scrieri.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Scrieri.getItems().get(i).getIdscriere();
        		jb.stergeTabela("autori_carti", "idscriere", pk);
        	}
        }
        
        dateScrieri = FXCollections.observableArrayList();

        ResultSet rs = jb.TabelScrieri();
        //jb.afisare(rs);
        //System.out.println("test");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
        	dateScrieri.add(new Scriere(rs.getLong("idscriere"), rs.getString("nume"), rs.getString("prenume"), rs.getString("titlu"), rs.getLong("durata"), Select));
        }
        
        tabela_Scrieri.setItems(null);
        tabela_Scrieri.setItems(dateScrieri);      
        
        jb.disconnect();
    }
    
    @FXML
    private void modificaCarti(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
    	ArrayList<String> campuri = new ArrayList<>();
    	ArrayList<String> valori = new ArrayList<>();
    	
        String titlu = adauga_titluC.getText();
        if(!titlu.isEmpty()) {
        	valori.add(titlu);
        	campuri.add("titlu");
        }
        String an = adauga_anC.getText();
        if(!an.isEmpty()) {
        	valori.add(an);
        	campuri.add("an");
        }
        String gen = adauga_genC.getText();
        if(!gen.isEmpty()) {
        	valori.add(gen);
        	campuri.add("gen");
        }
        String nrpagini = adauga_nrpaginiC.getText();
        if(!nrpagini.isEmpty()) {
        	valori.add(nrpagini);
        	campuri.add("nrpagini");
        }
        String editura = adauga_edituraC.getText();
        if(!editura.isEmpty()) {
        	valori.add(editura);
        	campuri.add("editura");
        }
        
        String[] campuri_array = campuri.toArray(new String[0]);
        String[] valori_array = valori.toArray(new String[0]);
        
        for(int i = 0; i < tabela_Carti.getItems().size(); i ++) {
        	if(tabela_Carti.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Carti.getItems().get(i).getIdcarte();
        		jb.modificaTabela("carti", "idcarte", pk, campuri_array, valori_array);
        	}
        }
        
        dateCarti = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("carti");
        while (rs.next()) {
        	CheckBox Select = new CheckBox(null);
        	dateCarti.add(new Carte(rs.getLong("idcarte"), rs.getString("titlu"), rs.getLong("an"), rs.getString("gen"), rs.getLong("nrpagini"), rs.getString("editura"), Select));
        }
        
        adauga_titluC.clear();
        adauga_anC.clear();
        adauga_genC.clear();
        adauga_nrpaginiC.clear();
        adauga_edituraC.clear();
        
        tabela_Carti.setItems(null);
        tabela_Carti.setItems(dateCarti);
        jb.disconnect();
    }
    
    @FXML
    private void modificaAutori(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
    	ArrayList<String> campuri = new ArrayList<>();
    	ArrayList<String> valori = new ArrayList<>();
    	
        String nume = adauga_numeA.getText();
        if(!nume.isEmpty()) {
        	valori.add(nume);
        	campuri.add("nume");
        }
        String prenume = adauga_prenumeA.getText();
        if(!prenume.isEmpty()) {
        	valori.add(prenume);
        	campuri.add("prenume");
        }
        String nrcarti = adauga_nrcartiA.getText();
        if(!nrcarti.isEmpty()) {
        	valori.add(nrcarti);
        	campuri.add("nrcarti");
        }
        String nationalitate = adauga_nationalitateA.getText();
        if(!nationalitate.isEmpty()) {
        	valori.add(nationalitate);
        	campuri.add("nationalitate");
        }
        
        String[] campuri_array = campuri.toArray(new String[0]);
        String[] valori_array = valori.toArray(new String[0]);
        
        for(int i = 0; i < tabela_Autori.getItems().size(); i ++) {
        	if(tabela_Autori.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Autori.getItems().get(i).getIdautor();
        		jb.modificaTabela("autori", "idautor", pk, campuri_array, valori_array);
        	}
        }
        dateAutori = FXCollections.observableArrayList();
        ResultSet rs = jb.vedeTabel("autori");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
        	dateAutori.add(new Autor(rs.getLong("idautor"), rs.getString("nume"), rs.getString("prenume"), rs.getLong("nrcarti"), rs.getString("nationalitate"), Select));
        }
        adauga_numeA.clear();
        adauga_prenumeA.clear();
        adauga_nrcartiA.clear();
        adauga_nationalitateA.clear();
        
        tabela_Autori.setItems(null);
        tabela_Autori.setItems(dateAutori);
        jb.disconnect();
    }
    
    @FXML
    private void modificaScrieri(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
    	ArrayList<String> campuri = new ArrayList<>();
    	ArrayList<String> valori = new ArrayList<>();
    	
        String idautor = adauga_idautorS.getText();
        if(!idautor.isEmpty()) {
        	valori.add(idautor);
        	campuri.add("idautor");
        }
        String idcarte = adauga_idcarteS.getText();
        if(!idcarte.isEmpty()) {
        	valori.add(idcarte);
        	campuri.add("idcarte");
        }
        String durata = adauga_durataS.getText();
        if(!durata.isEmpty()) {
        	valori.add(durata);
        	campuri.add("durata");
        }
        
        String[] campuri_array = campuri.toArray(new String[0]);
        String[] valori_array = valori.toArray(new String[0]);
        
        for(int i = 0; i < tabela_Scrieri.getItems().size(); i ++) {
        	if(tabela_Scrieri.getItems().get(i).getSelect().isSelected()) {
        		long pk = tabela_Scrieri.getItems().get(i).getIdscriere();
        		jb.modificaTabela("autori_carti", "idscriere", pk, campuri_array, valori_array);
        	}
        }
        
        dateScrieri = FXCollections.observableArrayList();

        ResultSet rs = jb.TabelScrieri();
        //jb.afisare(rs);
        //System.out.println("test");
        while (rs.next()) {
        	CheckBox Select = new CheckBox("");
        	dateScrieri.add(new Scriere(rs.getLong("idscriere"), rs.getString("nume"), rs.getString("prenume"), rs.getString("titlu"), rs.getLong("durata"), Select));
        }
        
        adauga_idautorS.clear();
        adauga_idcarteS.clear();
        adauga_durataS.clear();
        
        tabela_Scrieri.setItems(null);
        tabela_Scrieri.setItems(dateScrieri);
        jb.disconnect();
    }
    
    
    
}