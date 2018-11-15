package utils;

import java.util.Random;

public class RandomPickerMachine {
    private int numberOfElements;
    private Random randomMachine;

    public RandomPickerMachine(int numberOfElements) {
        randomMachine = new Random();
        this.numberOfElements = numberOfElements;
    }

    public int pickRandomValue(){
       return randomMachine.nextInt(numberOfElements);
    }
}
