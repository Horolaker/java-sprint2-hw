import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YearlyReport {
    ArrayList<YearData> nameOfYearData = new ArrayList<>();
    ReadFile readFile = new ReadFile();

    void loadFile() {

        List<String> linesOfFile = readFile.readFileContents("resources/y.2021.csv");
        for (int i = 1; i < linesOfFile.size(); i++) {
            String line = linesOfFile.get(i);
            String[] data = line.split(",");
            YearData yearData = new YearData(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    Boolean.parseBoolean(data[2]));
            nameOfYearData.add(yearData);
        }

        System.out.println("Чтение файлов завершено!\n");
    }
}

