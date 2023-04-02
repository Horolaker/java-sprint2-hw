import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YearlyReport {
    ArrayList<YearData> nameOfYearData = new ArrayList<>();

    void loadFile() {
        List<String> linesOfFile = readFileContents("resources/y.2021.csv");
        for (int i = 1; i < linesOfFile.size(); i++) {
            String line = linesOfFile.get(i);
            String[] data = line.split(",");
            YearData yearData = new YearData(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    Boolean.parseBoolean(data[2]));
            nameOfYearData.add(yearData);
        }
        System.out.println("Годовые отчеты считанны!\n");
    }

    List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.\n");
            return Collections.emptyList();
        }
    }
}

