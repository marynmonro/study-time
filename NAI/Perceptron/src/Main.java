import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("a train-set test-set:");

        String str1 = in.nextLine();
       // String str1 = "1.0 train-set.csv test-set.csv";
        String[] strArr = str1.split(" ");

        double a = Double.parseDouble(strArr[0]);
        String trainSetPath = strArr[1];
        String testSetPath = strArr[2];

        Data data = new Data(trainSetPath, testSetPath);
        Perceptron perceptron = new Perceptron(data);
        perceptron.learn(a);
        perceptron.TestSetPerceptron();

        System.out.println(" - - - ");
        while (true) {
            String str2 = in.nextLine(); // 6.1;3.5;1.4;0.2;Iris-virginica
            if ( str2.equals("end") ){
                break;
            }
            String[] karr = str2.split(" ");
            for (String str : karr) {
                perceptron.TestArgumentPerceptron(new Iris(str));
            }

        }


    }
}