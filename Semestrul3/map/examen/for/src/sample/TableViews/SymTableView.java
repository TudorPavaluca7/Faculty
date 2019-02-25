package sample.TableViews;

import Model.Utilities.IDictionary;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SymTableView {
    private SimpleStringProperty variable;
    private SimpleIntegerProperty value;

    public SymTableView(String variable, Integer value){
        this.variable=new SimpleStringProperty(variable);
        this.value=new SimpleIntegerProperty(value);
    }

    public SimpleStringProperty variableProperty() {
        return variable;
    }

    public SimpleIntegerProperty valueProperty() {
        return value;
    }

    public void setVariable(String variable) {
        this.variable.set(variable);
    }

    public void setValue(int value) {
        this.value.set(value);
    }

    public String getVariable(){return variable.get();}

    public int getValue(){return  value.get();}
}
