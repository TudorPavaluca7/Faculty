import model.Matrix;
import runnables.MatrixAddition;
import runnables.MatrixMultiplication;
import runnables.MatrixOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    private static Matrix operation(String op, Matrix a, Matrix b,int taskCount, int threadCount) throws Exception {

        Matrix result = new Matrix(a.getRowsNumber(), a.getColsNumber());

        List<MatrixOperation> tasks = new ArrayList<>();

        switch (op){
            case "add":
                for (int i = 0; i < taskCount; i++){
                    tasks.add(new MatrixAddition(a, b, result));
                }
                break;
            case "multiply":
                for (int i = 0; i < taskCount; i++){
                    tasks.add(new MatrixMultiplication(a, b, result));
                }
                break;
            default:
                throw new Exception("operation doesn't exist");
        }

        for (int row = 0; row < result.getRowsNumber(); row++){
            for(int col = 0; col < result.getRowsNumber(); col++){
                tasks.get(row % taskCount).addPointToWorkload(row, col);
            }
        }



        ExecutorService pool = Executors.newFixedThreadPool(threadCount);

        for (MatrixOperation task : tasks){
            pool.execute(task);
        }

        pool.shutdown();
        return result;
    }


    public static void main(String[] args) throws Exception {

        Matrix a = new Matrix(500, 500);
        Matrix b = new Matrix(500, 500);
        String add="add";
        String multiply = "multiply";

        float start =  System.nanoTime() / 1000000;
        operation(add, a, b, 4,16);
        float end = System.nanoTime() / 1000000;

        System.out.println("addition took:" + (end - start) / 1000 + " seconds, " + 4 + " runnables");

        start =  System.nanoTime() / 1000000;
        operation(multiply, a, b, 4,16);
        end = System.nanoTime() / 1000000;

        System.out.println("\n multiplication took: " + (end - start) / 1000 + " seconds, " + 4 + " runnables");


    }
}
