import java.io.*;
import java.util.ArrayList;

public class Data {

    private ArrayList<Atrybut> atrybuty;

    public Data( String fileName ){
        atrybuty = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(fileName)));
            String line;
            while ((line = br.readLine()) != null) {
                atrybuty.add( new Atrybut(line) );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Atrybut> getAtrybuty() {
        return atrybuty;
    }

}
