import model.Matrix;
import threads.MatrixAdditionThread;
import threads.MatrixMultiplicationThread;
import threads.MatrixOperationThread;

import java.util.ArrayList;
import java.util.List;


public class Main {

    private static void operation(String op, Matrix a, Matrix b, int threadCount) throws Exception {

        Matrix result = new Matrix(a.getRowsNumber(), a.getColsNumber());

        List<MatrixOperationThread> threads = new ArrayList<>();

        switch (op){
            case "add":
                for (int i = 0; i < threadCount; i++){
                    threads.add(new MatrixAdditionThread(a, b, result));
                }
                break;
            case "multiply":
                for (int i = 0; i < threadCount; i++){
                    threads.add(new MatrixMultiplicationThread(a, b, result));
                }
                break;
            default:
                throw new Exception("operation doesn't exist");
        }

        for (int row = 0; row < result.getRowsNumber(); row++){
            for(int col = 0; col < result.getRowsNumber(); col++){
                threads.get(row % threadCount).addPointToWorkload(row, col);
            }
        }



        for (int i = 0; i < threadCount; i++){
            threads.get(i).start();
        }

        for (int i = 0; i < threadCount; i++){
            threads.get(i).join();
        }
        System.out.println(result.toString());
    }



    }

