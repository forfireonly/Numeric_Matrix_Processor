import java.util.Arrays;
import java.util.Scanner;

class Checker {
    private int sizeOfArray;
    private int[] arrayToCheck;
    private int number;

    public void setSizeOfArray(int sizeOfArray) {
        this.sizeOfArray = sizeOfArray;
        //System.out.println(sizeOfArray);
    }

    public int getSizeOfArray() {

        return sizeOfArray;
    }

    public void setArrayToCheck(int[] arrayToCheck, int sizeOfArray)  {
        //System.out.println(sizeOfArray);
        this.arrayToCheck = Arrays.copyOf(arrayToCheck, sizeOfArray);
        //this.arrayToCheck = arrayToCheck;
        //System.out.println(Arrays.toString(arrayToCheck));
        //System.out.println(sizeOfArray);
        //System.out.println(arrayToCheck.length);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void check() {
        boolean isPresent = false;
        for (int each : arrayToCheck) {
            if (each == number) {
                isPresent = true;
                break;
            }
        }
        System.out.print(isPresent);
    }


}
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        int arraySize = scn.nextInt();
        int[] myArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            myArray[i] = scn.nextInt();
        }
        int myNumber = scn.nextInt();
        //System.out.print(myNumber);
        //System.out.println(Arrays.toString(myArray));
        Checker newChecker = new Checker();
        newChecker.setArrayToCheck(myArray, arraySize);
        newChecker.setSizeOfArray(arraySize);
        newChecker.setNumber(myNumber);
        newChecker.check();
    }
}