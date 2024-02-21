package curs8;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;


public class Autor {

    private final LongProperty idautor;
    private final StringProperty nume;
    private final StringProperty prenume;
    private final LongProperty nrcarti;
    private final StringProperty nationalitate;
    private ObjectProperty<CheckBox> Select;

    public Autor(Long idautor, String nume, String prenume, Long nrcarti, String nationalitate, CheckBox Select) {
        this.idautor = new SimpleLongProperty(idautor);
        this.nume = new SimpleStringProperty(nume);
        this.prenume = new SimpleStringProperty(prenume);
        this.nrcarti = new SimpleLongProperty(nrcarti);
        this.nationalitate = new SimpleStringProperty(nationalitate);
        this.Select = new SimpleObjectProperty<>(Select);
    }

    public Long getIdautor() {
        return idautor.get();
    }

    public String getNume() {
        return nume.get();
    }

    public String getPrenume() {
        return prenume.get();
    }

    public Long getNrcarti() {
        return nrcarti.get();
    }
    
    public String getSectie() {
        return nationalitate.get();
    }
    
    public CheckBox getSelect() {
        return Select.get();
    }

    public void setIdAutor(Long valoare) {
        idautor.set(valoare);
    }

    public void setNume(String valoare) {
        nume.set(valoare);
    }

    public void setPrenume(String valoare) {
        prenume.set(valoare);
    }
    
    public void setNrpagini(Long valoare) {
        nrcarti.set(valoare);
    }

    public void setNationalitate(String valoare) {
        nationalitate.set(valoare);
    }
    
    public void setSelect(CheckBox selected) {
		Select.set(selected);;
	}

    public LongProperty idautorProperty() {
        return idautor;
    }

    public StringProperty numeProperty() {
        return nume;
    }

    public StringProperty prenumeProperty() {
        return prenume;
    }
    
    public LongProperty nrcartiProperty() {
        return nrcarti;
    }
    
    public StringProperty nationalitateProperty() {
        return nationalitate;
    }
    
    public ObjectProperty<CheckBox> SelectProperty() {
        return Select;
    }
}