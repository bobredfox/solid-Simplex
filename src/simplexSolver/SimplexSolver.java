package simplexSolver;

import matrices.ArrayMatrix;

public class SimplexSolver {
    private Double[] problem;
    private ArrayMatrix restrictiveEquations;
    private Double[] b;
    private int functionvalue = 0;
    private int[] bases;

    SimplexSolver(Double[] inputProblem, ArrayMatrix inputMatrix, Double[] values) {
        // Works currently only with Phase II Problems
        this.restrictiveEquations = inputMatrix;
        int length = restrictiveEquations.getN();
        if (inputProblem.length < length) {
            this.problem = extendRow(inputProblem, length);
        } else {
            this.problem = inputProblem;
        }
        this.b = values;
        this.bases = new int[inputMatrix.getM()];
        setInitalBases();
    }

    private Double[] extendRow(Double[] row, int newLength){
        Double[] temp = new Double[newLength];
        for (int i = 0; i < temp.length; i++) {
            if (i < row.length) {
                temp[i] = row[i];
            } else {
                temp[i] = 0.0;
            }
        }
        return temp;
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
    }

    public void printBases(){
        int i = 1;
        for(int base: bases){
            System.out.println(i + " BaseColumn:" + base);
            i++;
        }
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
                lineWriter.append("| ");
                lineWriter.append(functionvalue);
                length = lineWriter.length();
            } else if (row == 1) {
                lineWriter.append("-".repeat(Math.max(0, length + 2)));
            } else {
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

