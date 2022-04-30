import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    private static ArrayList<Language> trainingArray;
    private static ArrayList<Language> testArray;
    private static HashMap<String, Perceptron> mapOfLangs; // język i go perceptron

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        trainingArray = Data.getDataFromDir("dane/training");
        testArray = Data.getDataFromDir("dane/test");

        mapOfLangs = new HashMap<>();
        for (Language l : trainingArray)
            mapOfLangs.put(l.getName(), new Perceptron());

        // uczymy każdy perceptron rozpoznawania "jego" języka

        for (int i = 0; i < 1000; i++)
        for ( Language l : trainingArray ) {
            for (Map.Entry<String, Perceptron> entry : mapOfLangs.entrySet()) {
                entry.getValue().learn(l, entry.getKey());
            }
        }

        for ( Language test : testArray ) {
            calculation(test);
        }

        System.out.println(" - - - ");

        while (true) {
            System.out.println("Choose method to test the single layer neural network: (by text/by file)");
            String option = in.nextLine(); //

            if ( option.equals("by text") ){
                System.out.println("Enter text:");
                String text = in.nextLine();
                calculation(new Language("", text));

            } else if ( option.equals("by file") ){
                System.out.println("Enter file name:");
                String filename = in.nextLine();
                String filetext = null;
                try {
                    BufferedReader br = new BufferedReader(new FileReader(filename));
                    String st = "";
                    while ( (st = br.readLine()) != null) {
                        assert false;
                        filetext += st;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                calculation(new Language("", filetext.toString()));

            } else break;
        }


    }

    private static void calculation(Language test) {
        double value = 0;
        String result = "";

        for (Map.Entry<String, Perceptron> entry : mapOfLangs.entrySet()) {
            if (value < entry.getValue().perceptron(test) || value == 0 ) {
                value = entry.getValue().perceptron(test);
                result = entry.getKey();
            }
        }

        System.out.println(test.getName() + " -> " + result);
    }

}