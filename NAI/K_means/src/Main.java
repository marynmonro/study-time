import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Plik CSV z danymi do grupowania:");
        String plik = sc.nextLine(); // test.csv
        //String plik = "test.csv";
        System.out.println("Parametr k:");
        String k = sc.nextLine(); // 2

        System.out.println("Obliczenia...");
        Data data = new Data(plik);
        Kmeans kmeans = new Kmeans( data.getAtrybuty() , Integer.parseInt(k));

        System.out.println("- - - - - - - -  \nResult:");
        kmeans.result();

    }
}
