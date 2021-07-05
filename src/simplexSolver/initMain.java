package simplexSolver;

import matrices.LinkedMatrix;

import java.util.LinkedList;

public class initMain {
    public static void main(String[] args){
        LinkedMatrix<Double[]> underFollowingRestrictions = new LinkedMatrix<>();
        Double[][] matrix = {{2.0, 1.0, 1.0, 0.0, 0.0},
                          {1.0, 1.0, 0.0, 1.0, 0.0},
                          {1.0, 0.0, 0.0, 0.0, 1.0}};
        for (Double[] row : matrix) {
            underFollowingRestrictions.add(row);
        }


    }


}
