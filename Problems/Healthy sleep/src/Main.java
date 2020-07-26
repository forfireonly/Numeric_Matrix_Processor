import java.util.Scanner;
class SleepAnalyzer {
    private int minSleep;
    private int maxSleep;
    private int personSleep;

    public void setMaxSleep(int maxSleep) {
        this.maxSleep = maxSleep;
    }

    public void setMinSleep(int minSleep) {
        this.minSleep = minSleep;
    }

    public void setPersonSleep(int personSleep) {
        this.personSleep = personSleep;
    }

    public void analyze() {
        System.out.print(personSleep < minSleep ? "Deficiency" : personSleep > maxSleep ? "Excess" : "Normal");
    }
}
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        SleepAnalyzer newAnalyzer = new SleepAnalyzer();
        newAnalyzer.setMinSleep(scn.nextInt());
        newAnalyzer.setMaxSleep(scn.nextInt());
        newAnalyzer.setPersonSleep(scn.nextInt());
        newAnalyzer.analyze();
    }
}