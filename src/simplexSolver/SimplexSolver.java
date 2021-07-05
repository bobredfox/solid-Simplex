package simplexSolver;

import matrices.ArrayMatrix;

public class SimplexSolver {
    private Double[] problem;
    private ArrayMatrix restrictiveEquations;
    private Double[] b;
    private int functionvalue = 0;
    private int[] bases;

    SimplexSolver(Double[] inputProblem, ArrayMatrix inputMatrix, Double[] values) {

        this.restrictiveEquations = inputMatrix;
        int length = restrictiveEquations.getN();
        if (inputProblem.length < length) {
            Double[] temp = new Double[length];
            for (int i = 0; i < temp.length; i++) {
                if (i < inputProblem.length) {
                    temp[i] = inputProblem[i];
                } else {
                    temp[i] = 0.0;
                }
            }
            this.problem = temp;
        } else {
            this.problem = inputProblem;
        }
        this.b = values;
        this.bases = new int[inputMatrix.getM()];
        setInitalBases();
    }

    private void setInitalBases() {
        int basisNumber = 0;
        for (int column = 0; column < restrictiveEquations.getN(); column++) {
            boolean basis = true;
            if (restrictiveEquations.getRow(0)[column] == 1.0) {
                int i = 1;
                while (basis && (i < restrictiveEquations.getM())) {
                    basis = restrictiveEquations.getRow(i)[column] == 0.0;
                    i++;
                }
            } else if(restrictiveEquations.getRow(0)[column] == 0.0) {
                int i = 1;
                boolean one = false;
                while (basis && (i < restrictiveEquations.getM())) {
                    if (restrictiveEquations.getRow(i)[column] == 1.0 && (!one)) {
                        one = true;
                    } else basis = restrictiveEquations.getRow(i)[column] == 0.0;
                    i++;
                }
            } else {
                basis = false;
            }
            if (!basis) {
                continue;
            }
            bases[basisNumber] = column;
            basisNumber++;
        }
        for (int base : bases){
            System.out.println("Base Column " + (base+1));

        }
        System.out.println();
    }

    void nextStep(){

    }


    void printStep(int stepNumber) {
        System.out.println("Step " + stepNumber);
        int length = 0;
        StringBuilder lineWriter = new StringBuilder();
        for (int row = 0; row < restrictiveEquations.getM() + 2; row++) {
            if (row == 0) {
                for (Double part : problem) {
                    lineWriter.append(part);
                    lineWriter.append(" ");
                }
                lineWriter.append("| " + functionvalue);
                length = lineWriter.length();
            } else if (row == 1) {
                for (int lines = 0; lines < length + 2; lines++) {
                    lineWriter.append("-");
                }
            } else if (row > 1) {
                for (Double part : restrictiveEquations.getRow(row - 2)) {
                    lineWriter.append(part);
                    lineWriter.append(" ");
                }
                lineWriter.append("| ");
                lineWriter.append(b[row - 2]);
            }
            System.out.println(lineWriter);
            lineWriter.delete(0, lineWriter.length());
        }
    }
}

