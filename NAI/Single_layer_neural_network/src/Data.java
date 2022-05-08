import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Data {

    static ArrayList<Language> langs;

    public static ArrayList<Language> getDataFromDir(String dir){
        langs = new ArrayList<>();

        try{
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dir));

            String language = "";
            for (Path d : directoryStream) {
                StringBuilder str = new StringBuilder();
                if ( Files.isDirectory(d) ){
                    language = d.getFileName().toString();
                    Stream<Path> tekstFiles = Files.walk(d);

                    for( Path f : tekstFiles.filter(Files::isRegularFile).collect(Collectors.toList()) ){
                        String line = "";
                        BufferedReader br = new BufferedReader(new FileReader(f.toFile()));
                        while ( (line = br.readLine()) != null ){
                            str.append(line.toLowerCase().replace("[^a-zA-Z]", ""));  // wyrzucamy wszystkie znaki poza literami alfabetu angielskiego (ASCII)
                        }
                    }
                }
            langs.add(new Language(language, str.toString()));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return langs;
    }

}
