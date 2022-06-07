import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private String trainSetPath;
    private String testSetPath;
    private List<Iris> trainIrisList;
    private List<Iris> testIrisList;

    public Data(String trainSetPath) {
        this.trainSetPath = trainSetPath;
        trainIrisList = getTrainIrisList();
    }

    public Data(String trainSetPath, String testSetPath) {
        this.trainSetPath = trainSetPath;
        trainIrisList = getTrainIrisList();

        this.testSetPath = testSetPath;
        testIrisList = getTestIrisList();
    }

    public List<Iris> getTestData() {
        List<Iris> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(testSetPath)));

            String line;
            while ((line = br.readLine()) != null) {
                list.add(lineToIris(line));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Iris> getTrainData() {
        List<Iris> list = new ArrayList<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(new File(trainSetPath)));
        String line;
        while ((line = br.readLine()) != null) {
            list.add(lineToIris(line));
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Iris> getTestIrisList() {
        return testIrisList;
    }

    public List<Iris> getTrainIrisList() {
        return trainIrisList;
    }

    public Iris lineToIris(String line){
        String[] splitLine = line.split(";");
        ArrayList<Double> values = new ArrayList<>();
        for ( int i = 0; i < splitLine.length; i++ ){
            if ( i == splitLine.length-1 ) break;
            values.add(Double.parseDouble(splitLine[i]));
        }

        return new Iris(
                values,
                splitLine[splitLine.length-1]
        );
    }

    public ArrayList<String> names(){
        ArrayList<String> result = new ArrayList<>();
        for ( Iris iris : getTrainData() ) {
            if ( !result.contains(iris.getName()) ) result.add(iris.getName());
        }
        return result;
    }

}