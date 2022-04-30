import java.util.List;
import java.util.Random;

public class Perceptron {

    private double[] wagi;
    private final double a = 0.3; //alfa - stala uczenia
    private double prog = randomForProg(); //theta
    private String Name ; //theta

    private double randomForProg() {
        Random r = new Random();
        return -0.25 + 0.5*r.nextDouble();
    } //random value from -0.25 to 0.25

    public Perceptron() {
        wagi = new double[26];
        Random r = new Random();
        for (int i = 0; i < wagi.length; i++) {
            wagi[i] = -0.25 + 0.5 * r.nextDouble();
        }
        wagi = normalize(wagi);

//        for ( double e: wagi) {
//            System.out.println(e);
//        }
//        System.out.println(" - - - ");

    }

    public void learn(Language language, String label) {
        this.Name = language.getName();
        double net = 0.0;
        for (int i = 0; i < language.getAttributes().length; i++) {
            net += wagi[i] * language.getAttributes()[i];
        }
        int y = 0 <= net ? 1 : 0;

        int d = language.getName().equals(label) ? 1 : 0;

        // regula delta
        double m = (d - y)*a;
        for (int i = 0; i < language.getAttributes().length; i++)
            wagi[i] = wagi[i] + (m * language.getAttributes()[i]);

        prog += m;
    }

    public double perceptron(Language language) {
        double net = 0.0;
        for (int i = 0; i < language.getAttributes().length; i++) {
            net += wagi[i]*language.getAttributes()[i];
        }
        return net;
    }

    private double[] normalize(double[] attributes ){
        double distance = distance(attributes);
        double[] result = new double[26];
        for ( int i = 0; i < attributes.length; i++ )
            result[i] = attributes[i]/distance;
        return result;
    }

    private double distance(double[] attributes ){
        double result = 0.0;
        for ( double a : attributes ) result+=Math.pow(a, 2);
        return Math.sqrt(result);
    }

    public double getProg() {
        return prog;
    }
}
