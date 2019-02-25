package sample;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class BarrierTableView {

    private SimpleIntegerProperty address, value;
    private SimpleStringProperty list;

    public BarrierTableView(Integer address, Integer value, String list) {
        this.address = new SimpleIntegerProperty(address);
        this.value = new SimpleIntegerProperty(value);
        this.list = new SimpleStringProperty(list);
    }

    public int getAddress() {
        return address.get();
    }

    public void setList(String list) {
        this.list.set(list);
    }

    public String getList() {

        return list.get();
    }

    public SimpleStringProperty listProperty() {
        return list;
    }

    public void setAddress(int address) {
        this.address.set(address);
    }

    public void setValue(int value) {
        this.value.set(value);
    }



    public SimpleIntegerProperty addressProperty() {
        return address;
    }

    public int getValue() {
        return value.get();
    }

    public SimpleIntegerProperty valueProperty() {
        return value;
    }
}
