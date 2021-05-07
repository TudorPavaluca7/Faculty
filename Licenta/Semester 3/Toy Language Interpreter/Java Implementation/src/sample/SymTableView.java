package sample;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class SymTableView {
    private SimpleStringProperty varName;
    private SimpleIntegerProperty value;

    public SymTableView(String varName, Integer value) {
        this.varName =  new SimpleStringProperty(varName);
        this.value =  new SimpleIntegerProperty(value);
    }

    public String getVarName() {
        return varName.get();
    }

    public SimpleStringProperty varNameProperty() {
        return varName;
    }

    public int getValue() {
        return value.get();
    }

    public SimpleIntegerProperty valueProperty() {
        return value;
    }

    public void setVarName(String varName) {
        this.varName.set(varName);
    }

    public void setValue(int value) {
        this.value.set(value);
    }
}
