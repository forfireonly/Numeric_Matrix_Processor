import java.util.Scanner;
class Squirrels {
    private int numberOfSquirrels;

    public void setSguirrels(int numberOfSquirrels) {
        if (numberOfSquirrels > 10000) {
            throw new IllegalArgumentException();
        }
        this.numberOfSquirrels = numberOfSquirrels;
    }

    public int getNumberOfSquirrels() {
        return numberOfSquirrels;
    }

    void countLeftover(Nuts nuts) {

        System.out.print(nuts.getNumberOfNuts() % this.numberOfSquirrels);

    }
}

class Nuts {
    private int numberOfNuts;

    public void setNumberOfNuts(int numberOfNuts) {
        if (numberOfNuts > 10000) {
            throw new IllegalArgumentException();
        }
        this.numberOfNuts = numberOfNuts;
    }

    public int getNumberOfNuts() {
        return numberOfNuts;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Squirrels squirrels = new Squirrels();
        squirrels.setSguirrels(scanner.nextInt());
        Nuts nuts = new Nuts();
        nuts.setNumberOfNuts(scanner.nextInt());
        squirrels.countLeftover(nuts);
        // put your code here
    }
}