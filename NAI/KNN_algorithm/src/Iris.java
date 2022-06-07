import java.util.ArrayList;

public class Iris {
    private ArrayList<Double> values;
    private String name;

    public Iris(String string){
        String[] arr = string.split(";");
        values = new ArrayList<>();
        for ( int i = 0; i < arr.length; i++ ){
            if ( i == arr.length-1 ) name = arr[arr.length-1];
            values.add(Double.parseDouble(arr[i]));
        }
        name = null;
    }

    public Iris( ArrayList<Double> values, String name ){
        this.values = values;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Iris{" +
                "values=" + values +
                ", name='" + name + '\'' +
                '}';
    }
}