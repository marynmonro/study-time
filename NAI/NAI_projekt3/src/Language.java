public class Language {

    private String name;
    private String text;
    private double[] attributes;

    public Language(String language, String toString) {
        name = language;
        text = toString;

        attributes = new double[26];
        int k = 0;
        for ( char i = 'a'; i <= 'z'; i++ ){
            char letter = i;
            int count = (int)text.chars().filter(character -> character == letter).count();
            attributes[k++] = count;
        }
        // przerabiamy na 26-elementowy wektor proporcji liter
        attributes = normalize(attributes);

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getAttributes() {
        return attributes;
    }
}
