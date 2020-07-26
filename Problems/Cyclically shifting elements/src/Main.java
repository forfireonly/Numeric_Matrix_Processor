import java.util.Arrays;
import java.util.Scanner;

class MyArrayClass {
    private int arraySize;
    private int[] myArray;

    public void setArraySize(int arraySize)  {
        this.arraySize = arraySize;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setMyArray(int[] myArray) {
        this.myArray = Arrays.copyOf(myArray, arraySize);
    }

    public int[] getMyArray() {
        return Arrays.copyOf(myArray, arraySize);
    }

    public void cycleArray() {
        int[] cycledArray = new int[myArray.length];
        if (myArray.length - 1 >= 0) {
            System.arraycopy(myArray, 0, cycledArray, 1, myArray.length - 1);
        }
        cycledArray[0] = myArray[myArray.length - 1];
        for (int each : cycledArray) {
            System.out.printf("%d ", each);
        }

    }

}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        MyArrayClass newArray = new MyArrayClass();
        int sizeOfArray = scanner.nextInt();
        int[] scannedArray = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            scannedArray[i] = scanner.nextInt();
        }
        newArray.setArraySize(sizeOfArray);
        newArray.setMyArray(scannedArray);
        newArray.cycleArray();

    }
}