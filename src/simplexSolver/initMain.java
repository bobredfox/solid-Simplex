package simplexSolver;

import matrices.ArrayMatrix;

public class initMain {
    public static void main(String[] args){
        Double[][] matrix = {{2.0, 1.0, 1.0, 0.0, 0.0},
                          {1.0, 1.0, 0.0, 1.0, 0.0},
                          {1.0, 0.0, 0.0, 0.0, 1.0}};
        ArrayMatrix problem = new ArrayMatrix(matrix);
        problem.printMatrix();

    }


}
