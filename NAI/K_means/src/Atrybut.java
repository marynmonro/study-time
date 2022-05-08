import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Atrybut {

    private ArrayList<Double> values;

    public Atrybut(String dane){
        values = new ArrayList<>();
        List<String> split = Arrays.asList(dane.split(";"));
        split.forEach(s -> values.add( Double.parseDouble(s) ) );
    }

    public Atrybut(){}

    public Atrybut(ArrayList<Double> array){
        values = new ArrayList<>();
        values.addAll(array);
    }

    public ArrayList<Double> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Atrybut{" +
                "values=" + values +
                '}';
    }
}
