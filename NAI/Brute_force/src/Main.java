import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       // String plik = sc.nextLine();
        String plik = "plecak.txt";
        Data data = new Data(plik);

        int k = 0;
        int n = 0;

        //for ( String str : data.getAtrybuty() ) System.out.println(str);

        String[] arr = data.getAtrybuty().get(0).split(",");
        k = Integer.parseInt(arr[0]);
        n = Integer.parseInt(arr[1]);

        int[] masses = Arrays.stream(data.getAtrybuty().get(1).split(",")).mapToInt(Integer::parseInt).toArray();
        int[] items = Arrays.stream(data.getAtrybuty().get(2).split(",")).mapToInt(Integer::parseInt).toArray();
        BruteForce bruteForce = new BruteForce(k, n, masses, items );

        System.out.println("- - - - - - - -  \nResult:");
        bruteForce.result();

       // bruteForce.implementation();

//        while (true){
//            System.out.println("- - - - - - - -  \nPodaj parametry:");
//
//            System.out.println("Parametr k:");
//            k = sc.nextInt();
//
//            System.out.println("Parametr n:");
//            n = sc.nextInt();
//
//            System.out.println("m1,m2,m3,m4,…,mn: ");
//            String mn = sc.nextLine();
//
//            System.out.println("w1,w2,w3,w4,…,wn: ");
//            String wn = sc.nextLine();
//
//            BruteForce brute = new BruteForce(k, n, masses, items );
//
//            System.out.println("- - - - - - - -  \nResult:");
//
//            brute.implementation();
//        }




    }
}
