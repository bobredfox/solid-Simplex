package simplexSolver;

import matrices.ArrayMatrix;

public class initMain {
    public static void main(String[] args){
        Double[][] matrix = {{2.0, 1.0, 1.0, 0.0, 0.0},
                          {1.0, 1.0, 0.0, 1.0, 0.0},
                          {1.0, 0.0, 0.0, 0.0, 1.0}};
        Double[] problemE = {30.0, 20.0};
        Double[] b = {1500.0, 1200.0, 500.0};
        ArrayMatrix problem = new ArrayMatrix(matrix);
        SimplexSolver solveSystem = new SimplexSolver(problemE, problem, b);
        solveSystem.printStep();
    }


}
