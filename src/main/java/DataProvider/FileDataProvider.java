package DataProvider;

import Data.Dau;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class provide list of DAU from a given file
 */
public class FileDataProvider implements DataProvider {

    private final String filePath;

    public FileDataProvider(String filePath){
        this.filePath = filePath;
    }

    public List<Dau> provideDau() {

        ArrayList<Dau> daus = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(this.filePath))) {

            stream.forEach(s -> {
                String[] idAndDate = s.split(",");
                String [] dataAndHour = idAndDate[1].split(" ");
                daus.add(new Dau(Integer.parseInt(idAndDate[0]), dataAndHour[0], dataAndHour[1]));
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return daus;
    }
}
