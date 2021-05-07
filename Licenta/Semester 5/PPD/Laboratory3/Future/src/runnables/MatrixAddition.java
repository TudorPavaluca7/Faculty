package runnables;

import javafx.util.Pair;
import model.Matrix;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixAddition extends MatrixOperation {

    public MatrixAddition(Matrix a, Matrix b, Matrix sum) {
        super(a, b, sum);
    }

    @Override
    public Matrix call() {
        for (Pair<Integer, Integer> point : this.workload){

            this.result.set(point.getKey(), point.getValue(), a.get(point.getKey(), point.getValue()) + b.get(point.getKey(), point.getValue()));

        }
        return this.result;
    }

}
