import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Data {

    private final ArrayList<String> atrybuty;

    public Data(String fileName ){
        atrybuty = new ArrayList<>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(new File(fileName)));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null && i < 3) {
                atrybuty.add( line );
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAtrybuty() {
        return atrybuty;
    }

}
