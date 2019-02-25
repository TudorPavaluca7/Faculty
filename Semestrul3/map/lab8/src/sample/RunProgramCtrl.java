package sample;
import Model.ADT.*;
import Model.FileHandling.FileData;
import Model.FileHandling.FileTable;
import Model.FileHandling.IFileTable;
import Model.ProgramState;
import Model.Statement.IStmt;
import Repository.CRepo;
import Repository.IRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import Controller.*;

import java.util.ArrayList;
import java.util.List;

public class RunProgramCtrl {

    @FXML private TableView<HeapTableView> heapTable;
    @FXML private TableColumn<HeapTableView, Integer> heapAddressColumn;
    @FXML private TableColumn<HeapTableView, Integer> heapValueColumn;


    @FXML private TableView<FileTableView> fileTable;
    @FXML private TableColumn<FileTableView, Integer> fileTableIdentifier;
    @FXML private TableColumn<FileTableView, String> fileTableName;


    @FXML private TableView<SymTableView> symTable;
    @FXML private TableColumn<SymTableView, String> symTableVarName;
    @FXML private TableColumn<SymTableView, Integer> symTableValue;

    @FXML private ListView<String> outList;
    @FXML private ListView<String> exeStack;
    @FXML private ListView<String> prgStateIdentifiers;
    @FXML private Button oneStepBTN;
    @FXML private TextField noPrgStateTextField;

    private List<ProgramState> progList;
    private Controller ctrl;
    private boolean selected;

//    public void updateController(){
//        progList=ctrl.getRepo().getPrgList();
//        List<Integer> nr=new ArrayList<Integer>();
//        for(ProgramState p:progList){
//            nr.add(p.getID());
//        }
//        ObservableList<Integer> nr1=FXCollections.observableList(nr);
//        prgStateIdentifiers.setItems(nr1);
//    }
//
//    public void clearAll(){
//        this.selected = false;
//        exeStack.getItems().clear();
//        symTable.getItems().clear();
//        heapTable.getItems().clear();
//        outList.getItems().clear();
//        noPrgStateTextField.setText("");
//        fileTable.getItems().clear();
//        prgStateIdentifiers.getItems().clear();
//    }


    ProgramState getCurrentProgramState(){
        int index = prgStateIdentifiers.getSelectionModel().getSelectedIndex();
        if(index == -1)
            index = 0;
        return ctrl.getPrgStateByIndex(index);
    }
    private void setNoPrgState(){
        Integer nr = ctrl.noPrgStates();
        noPrgStateTextField.setText(String.valueOf(nr));
    }

    private void setPrgStateIdentifiers(){
        prgStateIdentifiers.setItems(ctrl.getPrgStatesID());
    }

    private void setExeStack(){

        ObservableList<String> list = FXCollections.observableArrayList();
        ProgramState programState = getCurrentProgramState();


        for(IStmt i : programState.getExeStack().getAll())
            list.add(""+i);

        exeStack.setItems(list);
    }

    private void setHeapTable(){

        ObservableList<HeapTableView> list = FXCollections.observableArrayList();
        ProgramState programState = getCurrentProgramState(); // here we don't need to get current because heap is shared by all
        // but i used to don't make another function to get one programState

        for(Integer key: programState.getHeap().getAll())
            list.add(new HeapTableView(key, programState.getHeap().get(key)));

        heapTable.setItems(list);
    }

    private void setFileTable(){

        ObservableList<FileTableView> list = FXCollections.observableArrayList();
        ProgramState programState = getCurrentProgramState(); // here we don't need to get current because fileTable is shared by all
        // but i used to don't make another function to get one programState

        for(Integer key: programState.getFileTable().getAll())
            list.add(new FileTableView(key, programState.getFileTable().get(key).getFileName()));

        fileTable.setItems(list);
    }

    private void setSymTable(){

        ObservableList<SymTableView> list = FXCollections.observableArrayList();
        ProgramState programState = getCurrentProgramState();

        for(String key: programState.getSymbolTable().getAll())
            list.add(new SymTableView(key, programState.getSymbolTable().get(key)));

        symTable.setItems(list);
    }

    private void setOutList(){
        ObservableList<String> list = FXCollections.observableArrayList();
        ProgramState programState = getCurrentProgramState();   // they all share the same outList

        for(Integer i: programState.getMessages().getAll())
            list.add(""+i);

        outList.setItems(list);
    }


    private void setAll(){
        setNoPrgState();
        setPrgStateIdentifiers();
        setExeStack();
        setHeapTable();
        setFileTable();
        setSymTable();
        setOutList();
    }
    @FXML
    public void initialize(){

        IStack<IStmt> exeStack = new CStack<>();
        IDictionary<String, Integer> dict = new CDictionary<>();
        IList<Integer> list = new CList<>();
        IFileTable<Integer, FileData> fileTable = new FileTable<>();
        IHeap<Integer, Integer> heap = new Heap<>();
        exeStack.push(SelectCtrl.statement);
        ProgramState programState = new ProgramState(exeStack, dict, list, null, fileTable, heap);

        IRepo repo = new CRepo("log.txt");
        repo.addPrg(programState);
        ctrl = new Controller(repo);


        this.heapAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.heapValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        this.fileTableIdentifier.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.fileTableName.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        this.symTableVarName.setCellValueFactory(new PropertyValueFactory<>("varName"));
        this.symTableValue.setCellValueFactory(new PropertyValueFactory<>("value"));


        setNoPrgState();
        setPrgStateIdentifiers();

        prgStateIdentifiers.getSelectionModel().select(0);
        setExeStack();
    }
    public void executeOneStep() {
        try {
            if (ctrl.getRepo().getPrgList().size()==0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "The program has been executed successfully!");
                a.show();
            }
            if (ctrl.oneStepGUI()) {
                setAll();
            } else {
                setNoPrgState();
                setPrgStateIdentifiers();
            }
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
            a.show();

        }
    }
    public void mouseClickPrgStateIdentifiers(){

        if(ctrl.noPrgStates() > 0)
            setAll();
    }


}
