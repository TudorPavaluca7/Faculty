package sample.TableViews;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class HeapTableView {
    private SimpleIntegerProperty address;
    private SimpleIntegerProperty value;

    public HeapTableView(Integer address,Integer value){
        this.address=new SimpleIntegerProperty(address);
        this.value=new SimpleIntegerProperty(value);
    }

    public SimpleIntegerProperty addressProperty() {
        return address;
    }

    public SimpleIntegerProperty ValueProperty() {
        return value;
    }

    public void setAddress(int address) {
        this.address.set(address);
    }

    public void setValue(int value) {
        this.value.set(value);
    }

    public int getAddress(){return address.get();}

    public int getValue(){return  value.get();}
}
