import java.util.Arrays;
import java.util.Scanner;

class TestResults {
    private int[] grades;

    public void setGrades(int[] grades) {
        this.grades = Arrays.copyOf(grades, grades.length);
    }

    public void accessResults() {
        int gradeD = 0;
        int gradeC = 0;
        int gradeB = 0;
        int gradeA = 0;
        for (int each : grades) {
            if (each == 2) {
                gradeD++;
            } else {
                if (each == 3) {
                    gradeC++;
                } else {
                    if (each == 4) {
                        gradeB++;
                    } else {
                        if (each == 5) {
                            gradeA++;
                        }
                    }
                }
            }
        }
        System.out.printf("%d %d %d %d", gradeD, gradeC, gradeB, gradeA);
    }


}

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        int sizeOfArray = scn.nextInt();
        int[] grades = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            grades[i] = scn.nextInt();
        }

        TestResults newClass = new TestResults();
        newClass.setGrades(grades);
        newClass.accessResults();

    }
}