import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Matrix {
    private List<List<Integer>> content;
    private int rows, cols;

    public Matrix(int rows, int cols) {
       this.rows = rows;
       this.cols = cols;

       int max = 900;
       int min = 100;

       Random rand = new Random();

       this.content = new ArrayList<>(rows);
       for (int i = 0; i < this.rows; i++){
           this.content.add(new ArrayList<>(cols));
           for (int j = 0; j < this.cols; j++){
               this.content.get(i).add(rand.nextInt((max - min) + 1) + min);
           }
       }
    }

    public void FillWithZero() {
        for (int i = 0; i < this.rows; i++) {
            this.content.add(new ArrayList<>(cols));
            for (int j = 0; j < this.cols; j++) {
                this.content.get(i).set(j, 0);
            }
        }
    }

    public int get(int row, int col){
        return this.content.get(row).get(col);
    }

    public void set(int row, int col, int value){
        this.content.get(row).set(col, value);
    }

    public int getRowsNumber() {
        return rows;
    }

    public int getColsNumber() {
        return cols;
    }



    @Override
    public String toString() {
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < this.rows; i++){
            ss.append(this.content.get(i).toString()).append("\n");
        }

        return ss.toString();
    }
}
