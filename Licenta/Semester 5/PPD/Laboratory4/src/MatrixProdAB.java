import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixProdAB implements Runnable {

    private Lock lock = new ReentrantLock();
    private Condition rowDone = lock.newCondition();

    Matrix a;
    Matrix b;
    Matrix result;
    int row;

    public MatrixProdAB(Matrix a,Matrix b,Matrix result,int row)
    {
        this.a=a;
        this.b=b;
        this.result=result;
    }

    @Override
    public void run() {
        //lock.lock();
        for (int i = 0; i < a.getRowsNumber(); i++) {
            int res=0;
            for (int j = 0; j < a.getRowsNumber(); j++) {
                res += a.get(row,j)* b.get(j,i);
            }
            this.result.set(row, i, res);
        }

        rowDone.signal();
       // lock.unlock();
    }
}
