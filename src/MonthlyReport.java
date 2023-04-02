import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MonthlyReport {
    HashMap<Integer, ArrayList<MonthData>> nameOfMonthData = new HashMap<>();


    public void loadFile() {
        for (int month = 1; month < 4; month++) { // Считываем отчет за определенный месяц (Шапку отбрасываем)
            List<String> linesOfFile = readFileContents("resources/m.20210" + month + ".csv");
            ArrayList<MonthData> monthDataArrayList = new ArrayList<>();
            for (int i = 1; i < linesOfFile.size(); i++) {
                String line = linesOfFile.get(i);
                String[] data = line.split(",");
                MonthData monthData = new MonthData(
                        data[0],
                        Boolean.parseBoolean(data[1]),
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]));
                monthDataArrayList.add(monthData);
            }
            nameOfMonthData.put(month, monthDataArrayList);
        }
        System.out.println("Месячные отчеты считанны!\n");
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

