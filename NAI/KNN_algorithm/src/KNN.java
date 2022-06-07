import java.util.*;
import java.util.List;

public class KNN {

    private Data data;
    private int k = 0;

    private KNN(Data data, int k) {
        this.data = data;
        this.k = k;
    }

    public Data getData() {
        return data;
    }

    public static void TestSetKNN(Data data, int k) {
        KNN knn = new KNN(data, k);
        for (Iris i : knn.getData().getTestData()) {
            System.out.println( i.getName() + " " + knn.testKKN(i));
        }
    }

    public static void TestArgumentKNN(Data data, Iris iris, int k) {
        KNN irisKnn = new KNN(data, k);
        System.out.println("Hiperparametr: " + iris + " -> " + irisKnn.testKKN(iris));
    }

    public int getK() {
        return k;
    }

    private String testKKN(Iris iris) {

        List<Iris> closest = new ArrayList<>();
        List<Double> distances = new ArrayList<>();
        for (Iris j : data.getTrainData()) {
            double tmp = distance(iris, j);

            if (closest.size() >= k) {
                int index = 0;
                for (int l = 1; l < k; l++) {
                    if (distances.get(index) < distances.get(l)) index = l;
                }
                if (distances.get(index) > tmp) {
                    closest.set(index, j);
                    distances.set(index, tmp);
                }
            } else {
                closest.add(j);
                distances.add(tmp);
            }
        }

        Map<String, Integer> count = new HashMap<>();
        closest.forEach(i ->
        {
            if (count.containsKey(i.getName())) count.replace(i.getName(), count.get(i.getName()) + 1);
            else count.put(i.getName(), 1);
        });

        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) maxEntry = entry;
        }

        double accuracy = 0.0;
        String result = "";
        if (maxEntry != null) {
            accuracy = maxEntry.getValue().doubleValue()/k;
            for ( String name : data.names() ){
                if ( maxEntry.getKey().equals(name) ) result = name;
            }
        }
        return result + " accurancy=" + accuracy;
    }

    private double distance(Iris x, Iris y) {
        double result = 0.0;
        for ( int i = 0; i < x.getValues().size(); i++ ){
            result += Math.pow(y.getValues().get(i) - x.getValues().get(i), 2.0);
        }
        return Math.sqrt(result);
    }



}