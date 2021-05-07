import model.Matrix;
import runnables.MatrixAddition;
import runnables.MatrixMultiplication;
import runnables.MatrixOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


public class Main {

    private static Matrix operation(String op, Matrix a, Matrix b, int taskCount) throws Exception {

        Matrix result = new Matrix(a.getRowsNumber(), a.getColsNumber());

        List<MatrixOperation> callables = new ArrayList<>();

        switch (op){
            case "add":
                for (int i = 0; i < taskCount; i++){
                    callables.add(new MatrixAddition(a, b, result));
                }
                break;
            case "multiply":
                for (int i = 0; i < taskCount; i++){
                    callables.add(new MatrixMultiplication(a, b, result));
                }
                break;
            default:
                throw new Exception("operation doesn't exist");
        }

        for (int row = 0; row < result.getRowsNumber(); row++){
            for(int col = 0; col < result.getRowsNumber(); col++){
                callables.get(row % taskCount).addPointToWorkload(row, col);
            }
        }

        List<FutureTask> tasks = new ArrayList<>();

        for (MatrixOperation callable : callables) {
            tasks.add(new FutureTask(callable));
        }

        for (FutureTask task : tasks) {
            Thread thread = new Thread(task);
            thread.start();
        }

        for (FutureTask task : tasks) {
            task.get();
        }


        return result;
    }


    public static void main(String[] args) throws Exception {

        Matrix a = new Matrix(500, 500);
        Matrix b = new Matrix(500, 500);
//        System.out.println("Matrix A");
//        System.out.print(a.toString());
//        System.out.println("Matrix B");
//        System.out.print(b.toString());
//        b.toString();
        String add="add";
        String multiply = "multiply";

        float start =  System.nanoTime() / 1000000;
        Matrix c=operation(add, a, b, 16);
        float end = System.nanoTime() / 1000000;

        System.out.println("addition took:" + (end - start) / 1000 + " seconds, " + 4 + " runnables");

        start =  System.nanoTime() / 1000000;
        operation(multiply, a, b, 16);
        end = System.nanoTime() / 1000000;

        System.out.println("\n multiplication took: " + (end - start) / 1000 + " seconds, " + 4 + " runnables");


    }
}
