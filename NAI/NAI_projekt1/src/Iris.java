public class Iris {
    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private IrisType type;
    private String name;

    public Iris(String string){
        String[] arr = string.split(";");
        this.sepalLength = Double.parseDouble(arr[0]);
        this.sepalWidth = Double.parseDouble(arr[1]);
        this.petalLength = Double.parseDouble(arr[2]);
        this.petalWidth = Double.parseDouble(arr[3]);
        if ( arr.length>4 ) name = arr[4];
    }

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        type = null;
    }

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String name) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.name = name;
    }

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, IrisType type) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.type = type;
    }

//    public Iris(double parseDouble, double parseDouble1, double parseDouble2, double parseDouble3, String s) {
//    }

    public double getPetalLength() {
        return petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public double getSepalLength() {
        return sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public IrisType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "sepalLength=" + sepalLength +
                ", sepalWidth=" + sepalWidth +
                ", petalLength=" + petalLength +
                ", petalWidth=" + petalWidth +
                '}';
    }
}

enum IrisType { SETOSA, VERSICOLOR, VIRGINICA }
