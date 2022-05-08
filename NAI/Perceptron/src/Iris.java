import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Iris {

    private String name;
    private List<Double> atrybuty;

    public Iris(Iris iris) {
        atrybuty = new ArrayList<>();
        atrybuty.addAll(iris.getAtrybuty());
    }


    public Iris(String string) {
        String[] arr = string.split(";");
        atrybuty = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            atrybuty.add(Double.parseDouble(arr[i]));
        }

        this.name = arr[arr.length - 1];

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getAtrybuty() {
        return atrybuty;
    }

    @Override
    public String toString() {
        return "Iris{" + atrybuty + '}';
    }
}