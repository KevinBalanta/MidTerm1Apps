package com.example.challenge1.activities.model.data;

import java.util.Random;

public class ArithmeticOperationGenerator {

    public final static int SUMA = 1;
    public final static int REST = 2;
    public final static int DIVISION = 3;
    public final static int MULTI = 4;

    private int firstNumber;
    private int secondNumber;
    private int solution;
    private int operation;

    private Random random;


    public ArithmeticOperationGenerator() {

        resetOperation();
        random = new Random();
        generateRandomOperation();
    }


    public  void resetOperation(){
        firstNumber = 0;
        secondNumber = 0;
        solution = 0;
        operation = 0;
    }

    public String generateRandomOperation() {
        operation = random.nextInt(4) + 1;
        firstNumber = random.nextInt(1000) + 1;
        secondNumber = random.nextInt(1000) + 1;
        String result = "";

        switch (operation) {
            case SUMA:
                solution = firstNumber + secondNumber;
                result = firstNumber +" + "+secondNumber;
                break;

            case REST:
                solution = firstNumber - secondNumber;
                result = firstNumber +" - "+secondNumber;
                break;
            case MULTI:
                solution = firstNumber * secondNumber;
                result = firstNumber +" * "+secondNumber;
                break;
            case DIVISION:
                solution = firstNumber / secondNumber;
                result = firstNumber +" / "+secondNumber;
                break;
        }


        return result;
    }

    public boolean solveOperation(int solution){


        return solution == this.solution;
    }
}
