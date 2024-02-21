package curs8;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Scriere {

    private final LongProperty idscriere;
    private final StringProperty nume;
    private final StringProperty prenume;
    private final StringProperty titlu;
    private final LongProperty durata;
    private ObjectProperty<CheckBox> Select;



    public Scriere(Long idscriere, String nume, String prenume, String titlu, Long durata, CheckBox Select) {
        this.idscriere = new SimpleLongProperty(idscriere);
        this.nume = new SimpleStringProperty(nume);
        this.prenume = new SimpleStringProperty (prenume);
        this.titlu = new SimpleStringProperty(titlu);
        this.durata = new SimpleLongProperty(durata);
        this.Select = new SimpleObjectProperty<>(Select);

    }

    public Long getIdscriere() {
        return idscriere.get();
    }

    public String getNume_Autor() {
        return nume.get();
    }

    public String getPrenume_Autor() {
        return prenume.get();
    }

    public String getTitlu_carte() {
        return titlu.get();
    }
    
    public Long getDurata() {
        return durata.get();
    }
    public CheckBox getSelect() {
        return Select.get();
    }
    
    public void setIdscriere(Long valoare) {
        idscriere.set(valoare);
    }

    public void setNume_Autor(String valoare) {
    	nume.set(valoare);
    }

    public void setPrenume_Autor(String valoare) {
    	prenume.set(valoare);
    }

    public void setTitlu_Carte(String valoare) {
    	titlu.set(valoare);
    }
    
    public void setDurata(Long valoare) {
    	durata.set(valoare);
    }
    
    public void setSelect(CheckBox selected) {
		Select.set(selected);;
	}

    public LongProperty idscriereProperty() {
        return idscriere;
    }

    public StringProperty numeProperty() {
        return nume;
    }

    public StringProperty prenumeProperty() {
        return prenume;
    }

    public StringProperty titluProperty() {
        return titlu;
    }
    
    public LongProperty durataProperty() {
        return durata;
    }
    
    public ObjectProperty<CheckBox> SelectProperty() {
        return Select;
    }
}