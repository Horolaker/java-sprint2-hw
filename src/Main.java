import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        YearlyReport yearlyReport = new YearlyReport();
        MonthlyReport monthlyReport = new MonthlyReport();
        PrintData printData = new PrintData(yearlyReport, monthlyReport);
        while (true) {
            printMenu();
            int command = scan.nextInt();

            if (command == 1) {
                monthlyReport.loadFile();

            } else if (command == 2) {
                yearlyReport.loadFile();

            } else if (command == 3) {
                if (!yearlyReport.nameOfYearData.isEmpty() && !monthlyReport.nameOfMonthData.isEmpty()) {
                    printData.check();
                } else {
                    System.out.println("Отчеты не считанны!\n");
                }

            } else if (command == 4) {
                if (!monthlyReport.nameOfMonthData.isEmpty()) {
                    printData.printMonthData();
                } else {
                    System.out.println("Месячные отчеты не считанны!\n");
                }

            } else if (command == 5) {
                if (!yearlyReport.nameOfYearData.isEmpty()) {
                    printData.printYearData();
                } else {
                    System.out.println("Годовые отчеты не считанны!\n");
                }

            } else if (command == 0) {
                break;
            } else {
                System.out.println("Такой команды нет!\n");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}

