package sample.TableViews;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FileTableView {
    private SimpleIntegerProperty identifier;
    private SimpleStringProperty file;

    public FileTableView(Integer identifier, String file){
        this.identifier=new SimpleIntegerProperty(identifier);
        this.file=new SimpleStringProperty(file);
    }

    public SimpleIntegerProperty identifierProperty() {
        return identifier;
    }

    public SimpleStringProperty fileProperty() {
        return file;
    }

    public void setIdentifier(int identifier) {
        this.identifier.set(identifier);
    }

    public void setFile(String  file) {
        this.file.set(file);
    }

    public int getIdentifier(){return identifier.get();}

    public String  getFile(){return  file.get();}
}
