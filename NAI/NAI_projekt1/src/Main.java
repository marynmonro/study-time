import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("k:"); // 35
        String str = in.nextLine();
        int k = Integer.parseInt(str);
        System.out.println("train-set:"); //train-set.csv
        String trainSetPath = in.nextLine();
        System.out.println("test-set:"); //test-set.csv
        String testSetPath = in.nextLine();

        KNN.TestSetKNN(new Data(trainSetPath, testSetPath), k);
        System.out.println(" - - - ");
        System.out.println("Wprowadz przykladowy iris: ");
        String test = in.nextLine();
        String[] karr = test.split(" ");
        for (String st : karr) {
            KNN.TestArgumentKNN(new Data(trainSetPath), new Iris(st), k);
        }
    }
}