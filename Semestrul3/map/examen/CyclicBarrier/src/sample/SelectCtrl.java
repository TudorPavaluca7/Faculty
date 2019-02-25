package sample;
import Model.Expression.ArithmeticExpression;
import Model.Expression.ConstExpression;
import Model.Expression.ReadHeapExpression;
import Model.Expression.VarExpression;
import Model.Statement.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectCtrl {

    @FXML
    private ListView<String> listView;

    @FXML
    private Button runProgramBTN;

    public static IStmt statement;
    private List<IStmt> StmtList = new ArrayList<IStmt>();

    @FXML
    public void initialize() {

        IStmt ex1=new CompoundStatement(new AssignStatement("v",new ConstExpression(2)),new PrintStatement(new VarExpression("v")));
        IStmt ex2=new CompoundStatement(new AssignStatement("a", new ArithmeticExpression('+', new ConstExpression(2), new
                ArithmeticExpression('*', new ConstExpression(3), new ConstExpression(5)))),
                new CompoundStatement(new AssignStatement("b", new ArithmeticExpression('+', new VarExpression("a"), new
                        ConstExpression(1))), new PrintStatement(new VarExpression("b"))));

        IStmt ex3=new CompoundStatement(new AssignStatement("v",new ConstExpression(10)),new CompoundStatement(
                new NewStatement("a",new ConstExpression(22)),new CompoundStatement(
                new ForkStatement(new CompoundStatement(new HeapWriteStatement("a",new ConstExpression(30)),new CompoundStatement(
                        new AssignStatement("v",new ConstExpression(32)),new CompoundStatement(
                        new PrintStatement(new VarExpression("v")),new PrintStatement(new ReadHeapExpression("a"))
                )))),new CompoundStatement(
                new PrintStatement(new VarExpression("v")),new PrintStatement(new ReadHeapExpression("a"))))));
        //IStmt ex4 =new CompoundStatement(new CompoundStatement(new AssignStatement("v",new ConstExpression(2)),new ForkStatement(new AssignStatement("v",new ConstExpression(2)))),new ForkStatement(new AssignStatement("v",new ConstExpression(3))));
//        IStmt s1 = new NewStatement("v1", new ConstExpression(2));
//        IStmt s2 = new NewStatement("v2", new ConstExpression(3));
//        IStmt s3 = new NewStatement("v3", new ConstExpression(4));
//        IStmt s4 = new NewBarrier("cnt", new ReadHeapExpression("v3"));
//
//        IStmt s5 = new Await("cnt");
//        IStmt s6 = new PrintStatement(new ReadHeapExpression("v1"));
//        IStmt s7 = new PrintStatement(new ReadHeapExpression("v2"));
//        IStmt s8 = new PrintStatement(new ReadHeapExpression("v3"));
//
//        IStmt s9 = new HeapWriteStatement("v1", new ArithmeticExpression('*', new ReadHeapExpression("v1"), new ConstExpression(10)));
//        IStmt s10 = new HeapWriteStatement("v2", new ArithmeticExpression('*', new ReadHeapExpression("v2"), new ConstExpression(10)));
//        IStmt s11 = new HeapWriteStatement("v3", new ArithmeticExpression('*', new ReadHeapExpression("v3"), new ConstExpression(10)));
//
//        IStmt f1 = new CompoundStatement(s9, new CompoundStatement(s6,s5));
//        IStmt f2 = new CompoundStatement(s5, new CompoundStatement(s10, s7));
//        IStmt f3 = new CompoundStatement(new CompoundStatement(s5,s11), new CompoundStatement(s11, s8));
//
//        IStmt c1 = new CompoundStatement(new CompoundStatement(s1,s2), new CompoundStatement(s3,s4));
//        IStmt c2 = new CompoundStatement(new ForkStatement(f1), new CompoundStatement(new ForkStatement(f2), new ForkStatement(f3)));
//        IStmt c3 = new CompoundStatement(s5, new PrintStatement(new ConstExpression(2000)));

        IStmt ex4=new CompoundStatement(new NewStatement("v1",new ConstExpression(2)),new CompoundStatement(new NewStatement("v2",new ConstExpression(3)),new CompoundStatement(new NewStatement("v3",new ConstExpression(4)),new CompoundStatement(new NewBarrier("cnt",new ReadHeapExpression("v2")),new CompoundStatement(new ForkStatement(new CompoundStatement(new Await("cnt"),new CompoundStatement(new HeapWriteStatement("v1",new ArithmeticExpression('*',new ReadHeapExpression("v1"),new ConstExpression(10))),new PrintStatement(new ReadHeapExpression("v1"))))),new CompoundStatement(new ForkStatement(new CompoundStatement(new Await("cnt"),new CompoundStatement(new HeapWriteStatement("v2",new ArithmeticExpression('*',new ReadHeapExpression("v2"),new ConstExpression(10))),new CompoundStatement(new HeapWriteStatement("v2",new ArithmeticExpression('*',new ReadHeapExpression("v2"),new ConstExpression(10))),new PrintStatement(new ReadHeapExpression("v2"))))) ),new CompoundStatement(new Await("cnt"),new PrintStatement(new ReadHeapExpression("v3")))))))));



        //IStmt ex4 = new CompoundStatement(c1, new CompoundStatement(c2,c3));




        // IStmt ex4=
        StmtList.add(ex1);StmtList.add(ex2);StmtList.add(ex3);StmtList.add(ex4);


        ObservableList<String> list = FXCollections.observableArrayList();
        for(IStmt i : StmtList)
            list.add(""+i);

        listView.setItems(list);

        listView.getSelectionModel().selectIndices(0);

    }
    @FXML
    public void buttonRun() throws IOException {
        try{
        statement = StmtList.get(listView.getSelectionModel().getSelectedIndex());

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Program");
        stage.setScene(new Scene(root, 800, 600));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();}
        catch(Exception e){
                Alert a = new Alert(Alert.AlertType.ERROR, e.getMessage());
                a.show();
            }
    }



}
