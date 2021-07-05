package matrices;

public class ArrayMatrix {
    private Double[][] matrixData;

    public ArrayMatrix(int n, int m){
        matrixData = new Double[n][m];
    }

    public ArrayMatrix(Double[][] array){
        matrixData = array;
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
}
