package curs8;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;


public class Carte {

    private final LongProperty idcarte;
    private final StringProperty titlu;
    private final LongProperty an;
    private final StringProperty gen;
    private final LongProperty nrpagini;
    private final StringProperty editura;
    private ObjectProperty<CheckBox> Select;

    public Carte(Long idcarte, String titlu, Long an, String gen, Long nrpagini, String editura, CheckBox Select) {
        this.idcarte = new SimpleLongProperty(idcarte);
        this.titlu = new SimpleStringProperty(titlu);
        this.an = new SimpleLongProperty(an);
        this.gen = new SimpleStringProperty(gen);
        this.nrpagini = new SimpleLongProperty(nrpagini);
        this.editura = new SimpleStringProperty(editura);
        this.Select = new SimpleObjectProperty<>(Select);
    }

    public Long getIdcarte() {
        return idcarte.get();
    }

    public String getTitlu() {
        return titlu.get();
    }
    
    public Long getAn() {
        return an.get();
    }

    public String getGen() {
        return gen.get();
    }
    
    public Long getNrpagini() {
        return nrpagini.get();
    }

    public String getEditura() {
        return editura.get();
    }
    
    public CheckBox getSelect() {
        return Select.get();
    }
    
    public void setIdcarte(Long valoare) {
        idcarte.set(valoare);
    }

    public void setTitlu(String valoare) {
        titlu.set(valoare);
    }

    public void setAn(Long valoare) {
        an.set(valoare);
    }

    public void setGen(String valoare) {
        gen.set(valoare);
    }
    
    public void setNrpagini(Long valoare) {
        nrpagini.set(valoare);
    }

    public void setEditura(String valoare) {
    	editura.set(valoare);
    }
    
    public void setSelect(CheckBox selected) {
		Select.set(selected);;
	}
    
    public LongProperty idcarteProperty() {
        return idcarte;
    }

    public StringProperty titluProperty() {
        return titlu;
    }
    
    public LongProperty anProperty() {
        return an;
    }

    public StringProperty genProperty() {
        return gen;
    }
    
    public LongProperty nrpaginiProperty() {
        return nrpagini;
    }

    public StringProperty edituraProperty() {
        return editura;
    }
    
    public ObjectProperty<CheckBox> SelectProperty() {
        return Select;
    }
}