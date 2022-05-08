import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kmeans {
    private ArrayList<Atrybut> atrybuty;
    private Map<Atrybut, ArrayList<Atrybut>> obliczenia;
    private int k;
    private double E = -1;
    private int iloscV = 0;

    public Kmeans( ArrayList<Atrybut> atrybuty, int k ){
        this.atrybuty = atrybuty;
        this.k = k;
        iloscV = atrybuty.get(0).getValues().size();

        // krok 1: losowe wybieranie centroidow
        obliczenia = new HashMap<>();
        for ( int i = 1; i <= k; i++ ){
            int randomIndex = (int) (Math.random() * (atrybuty.size() - 1));
            obliczenia.put(atrybuty.get(randomIndex), new ArrayList<Atrybut>());
            System.out.println("Centroid (" + i + ") => " + atrybuty.get(randomIndex));
        }

        System.out.println(obliczenia.toString());

        boolean iteracja = true;
        int ii = 0;
        while ( iteracja ) {

            for ( Atrybut key : obliczenia.keySet() ) obliczenia.get(key).clear();

            // krok 2: przyporządkowanie punktów do zbiorów
            for (Atrybut atrybut : atrybuty) {
                double distance = -1;
                Atrybut result = new Atrybut();

                for ( Atrybut key : obliczenia.keySet() ){
                    double newdistance = distance(atrybut, key);
                    if( newdistance <= distance || distance == -1 ) {
                        result = key;
                        distance = newdistance;
                    }
                }

                for ( Atrybut key : obliczenia.keySet() )
                    if ( key.equals(result) ) {
                        obliczenia.get(key).add(atrybut);
                    }
            }

            // krok 3: wyznaczenie nowych centroidów
            Map<Atrybut, ArrayList<Atrybut>> newMap = new HashMap<>();
            for (  Atrybut key : obliczenia.keySet() ){
                ArrayList<Double> res = new ArrayList<>();

                for ( int i = 0; i < iloscV; i++ ){
                    double newValue = 0;
                    for ( Atrybut a : obliczenia.get(key) )
                        newValue += a.getValues().get(i);
                    res.add(newValue/obliczenia.get(key).size());
                }
                newMap.put(new Atrybut(res), obliczenia.get(key));
            }

            // krok 4: obliczenia nowego E
            double newE = calculateNewE(newMap);

            // krok 5: jeżeli chociaż 1 punkt zmieni swoją grupę (E będzie różne od wcześniejszej iteracji) => krok 2
            if (E == newE) iteracja = false;
            this.E = newE;

            System.out.println("Iteracja (" + ii++ + ") " + " -> E=" + newE );
        }
    }

    private double calculateNewE(Map<Atrybut, ArrayList<Atrybut>> map){
        double sum = 0.0;
        for ( Atrybut key : map.keySet() )
            for ( Atrybut a : map.get(key) )
                sum += distance(a, key);
        return sum;
    }

    private double distance(Atrybut x, Atrybut y){
        double sum = 0;
        for( int i = 0; i < x.getValues().size(); i++ )
            sum += Math.pow( (x.getValues().get(i)-y.getValues().get(i) ), 2 );
        return sum;
    }

    public void result(){
        int counter = 1;
        for ( Atrybut key : obliczenia.keySet() ){
            System.out.println("Grupa " + counter++ + " (" + key + "): ");
            System.out.println(obliczenia.get(key));
            System.out.println("- - -");
        }
    }

}
