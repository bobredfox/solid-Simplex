package matrices;

public class ArrayMatrix {
    private Double[][] matrixData;
    private int n;
    private int m;

    public ArrayMatrix(int n, int m){
        matrixData = new Double[m][n];
        this.n = n;
        this.m = m;
    }

    public ArrayMatrix(Double[][] array){
        matrixData = array;
        n = array[0].length;
        m = array.length;
    }

    public void setRow(int index, Double[] inputRow){
        if(index > matrixData.length){
            throw new ArrayIndexOutOfBoundsException("Index greater than array");
        } else {
            matrixData[index] = inputRow;
        }
    }

    public void printMatrix(){
        for (Double[] row : matrixData) {
            System.out.println();
            for (Double column : row) {
                System.out.print(column + ",");
            }
        }
    }

    public Double[] getRow(int row) {
        return matrixData[row];
    }

    public int getN(){
        return n;
    }

    public int getM(){
        return m;
    }
}
