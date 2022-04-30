import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private String trainSetPath;
    private String testSetPath;
    private List<Iris> trainIrisList;
    private List<Iris> testIrisList;
    private List<String> testIrisTypesResult;

    public Data(String trainSetPath) {
        this.trainSetPath = trainSetPath;
        trainIrisList = getTrainIrisList();
    }

    public Data(String trainSetPath, String testSetPath) {
        this.trainSetPath = trainSetPath;
        trainIrisList = getTrainIrisList();

        this.testSetPath = testSetPath;
        testIrisList = getTestIrisList();

        this.testIrisTypesResult = getTestIrisTypesResult();
    }

    public List<String> getTestIrisTypesResult() {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(testSetPath)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(";");
                list.add(splitLine[splitLine.length-1]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getTestIrisTypesResult(String name){
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(testSetPath)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(";");
                String n = splitLine[splitLine.length-1];
                if( n.equals(name) ) list.add(n);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Iris> getTestData() {
        List<Iris> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(testSetPath)));

            String line;
            while ((line = br.readLine()) != null) {
                list.add(new Iris(line));
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
            list.add(new Iris(line));
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

}