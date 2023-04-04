import java.util.*;

public class MonthlyReport {
    HashMap<Integer, ArrayList<MonthData>> nameOfMonthData = new HashMap<>();
    ReadFile readFile = new ReadFile();


    public void loadFile() {
        for (int month = 1; month < 4; month++) { // Считываем отчет за определенный месяц
            ArrayList<MonthData> monthDataArrayList = new ArrayList<>();
            List<String> linesOfFile = readFile.readFileContents("resources/m.20210" + month + ".csv");
            for (int i = 1; i < linesOfFile.size(); i++) { // Из каждой линии достаем значения и записываем их
                String line = linesOfFile.get(i);          // через конструктор в список
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

        System.out.println("Чтение файлов завершено!\n");
    }
}