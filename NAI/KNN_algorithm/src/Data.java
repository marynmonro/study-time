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
                String[] splitLine = line.split(";");
                list.add(new Iris(
                        Double.parseDouble(splitLine[0]),
                        Double.parseDouble(splitLine[1]),
                        Double.parseDouble(splitLine[2]),
                        Double.parseDouble(splitLine[3]),
                        splitLine[4]
                ));
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
            String[] splitLine = line.split(";");
            switch (splitLine[4]) {
                case "Iris-setosa":
                    list.add(new Iris( Double.parseDouble(splitLine[0]),
                            Double.parseDouble(splitLine[1]),
                            Double.parseDouble(splitLine[2]),
                            Double.parseDouble(splitLine[3]),
                            IrisType.SETOSA));
                    break;
                case "Iris-versicolor":
                    list.add(new Iris( Double.parseDouble(splitLine[0]),
                            Double.parseDouble(splitLine[1]),
                            Double.parseDouble(splitLine[2]),
                            Double.parseDouble(splitLine[3]),
                            IrisType.VERSICOLOR));
                    break;
                case "Iris-virginica":
                    list.add(new Iris( Double.parseDouble(splitLine[0]),
                            Double.parseDouble(splitLine[1]),
                            Double.parseDouble(splitLine[2]),
                            Double.parseDouble(splitLine[3]),
                            IrisType.VIRGINICA));
                    break;
            }
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