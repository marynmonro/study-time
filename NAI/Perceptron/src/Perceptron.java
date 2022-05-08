import java.util.*;
import java.util.List;

public class Perceptron {

    private Data data;
    private double a = 0.0; //stala uczenia
    private List<Double> wektorWag;
    private double prog = randomForProg(); //theta
    private int iloscAtrybutow;
    private List<String> listOfNames;

    public Perceptron(Data data) {
        this.data = data;
    }

    private double randomForProg() { //random value from -5 to 5
        return -5.0 + 10*new Random().nextDouble();
    }

    public Data getData() {
        return data;
    }

    public double getA() {
        return a;
    }

    public void learn(double a) {
        classNames();
        this.a = a;
        iloscAtrybutow = data.getTrainData().get(0).getAtrybuty().size();
        wektorWag = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < iloscAtrybutow; i++) {
            wektorWag.add(-3.0 + 6*r.nextDouble());
        }

        for (Iris iris : data.getTrainData()) {
            int d = iris.getName().equals(listOfNames.get(0)) ? 1 : 0;
            double net = 0.0;
            for (int i = 0; i < iloscAtrybutow; i++) {
                net += wektorWag.get(i)*iris.getAtrybuty().get(i);
            }
            int y = prog <= net ? 1 : 0;

            if (d != y) {  // regula delta
                double m = (d - y)*a;  // d-y => error, a=> alfa
                for (int i = 0; i < iris.getAtrybuty().size(); i++)
                    wektorWag.set(i, wektorWag.get(i) + (m*iris.getAtrybuty().get(i)));

                prog += -1 * m;
            }
        }

    }


    public void TestSetPerceptron() {
        List<Iris> list = new ArrayList<>();
        if (!wektorWag.isEmpty()) {
            System.out.println(prog);
            System.out.println(wektorWag);

            ArrayList<Iris> list1 = new ArrayList<>();
            ArrayList<Iris> list2 = new ArrayList<>();

            for (Iris i : data.getTestData()) {
                Iris res = perceptron(i);
                list.add(res);
                System.out.println(i.getName() + " " + res.getName());

                if( res.getName().equals(listOfNames.get(0)) )
                    list1.add(res);
                else list2.add(res);

            }
            System.out.println(getAcurracy(list, data.getTestIrisTypesResult()));
            double accAll1 = 0.0;
            double accAll2 = 0.0;

            for ( int i = 0; i<data.getTestIrisTypesResult().size(); i++  ){
                if ( data.getTestIrisTypesResult().get(i).equals(listOfNames.get(0)) )accAll1++;
                else accAll2++;
            }

            System.out.println( "acurracy " + listOfNames.get(0) + " -> " + list1.size()/accAll1);//getAcurracy(list1, data.getTestIrisTypesResult()) );
            System.out.println( "acurracy " + listOfNames.get(1) + " -> " + list2.size()/accAll2);//getAcurracy(list2, data.getTestIrisTypesResult()) );


        } else System.out.println("Perceptron sie nie nauczyl");
    }

    private double getAcurracy(List<Iris> irisList, List<String> listResult) {
        int res = irisList.size();
        for ( int i = 0; i < irisList.size(); i++) {
            if (!irisList.get(i).getName().equals(listResult.get(i))) res--;
        }
        double size = irisList.size();
        double result = res/size;
        return result;
    }

    public void TestArgumentPerceptron(Iris iris) {
        if (!wektorWag.isEmpty()) {
            System.out.println("Hiperparametr -> " + perceptron(iris).getName());
        } else System.out.println("Perceptron sie nie nauczyl");
    }

    public Iris perceptron(Iris iris) {
        double sum = 0.0;   //net
        for (int i = 0; i < iris.getAtrybuty().size() ; i++) {
            sum += wektorWag.get(i)*iris.getAtrybuty().get(i);
        }
        Iris result = new Iris(iris);
        if (prog <= sum) result.setName(listOfNames.get(0));
        else result.setName(listOfNames.get(1));
        return result;
    }

    public void classNames(){  // searching for names
        listOfNames = new ArrayList<>();
        listOfNames.add(data.getTrainData().get(0).getName());
        for ( Iris i : data.getTrainData() ){
            if( !i.getName().equals(listOfNames.get(0))){
                listOfNames.add(i.getName());
                break;
            }
        }
    }

}