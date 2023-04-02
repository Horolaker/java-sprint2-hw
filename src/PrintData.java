import java.util.ArrayList;
import java.util.HashMap;

public class PrintData {
    public MonthlyReport monthlyReport;
    public YearlyReport yearlyReport;

    public PrintData(YearlyReport yearlyReport, MonthlyReport monthlyReport) {
        this.monthlyReport = monthlyReport;
        this.yearlyReport = yearlyReport;
    }

    void printYearData() { //Печатает годовой отчет
        int sumExpense = 0;
        int sumIncome = 0;
        System.out.println("Год: 2021");
        for (int month = 1; month < 4; month++) {
            int monthProfit = 0;
            for (YearData yearData : yearlyReport.nameOfYearData) { //  Считаем доход за месяц + сумму доходов/расходов за год
                if (month == yearData.month) {
                    if (yearData.is_expense) {
                        monthProfit -= yearData.amount;
                        sumExpense += yearData.amount;
                    } else {
                        monthProfit += yearData.amount;
                        sumIncome += yearData.amount;
                    }
                }
            }
            System.out.println("Доход за " + month + " месяц составил: " + monthProfit);
        }
        System.out.println("Средний расход за все месяцы: " + sumExpense / 3);
        System.out.println("Средний доход за все месяцы: " + sumIncome / 3 + "\n");
    }

    void printMonthData() { //Печатает месячные отчеты
        for (int month : monthlyReport.nameOfMonthData.keySet()) {
            int maxExpense = 0;
            int maxIncome = 0;
            String nameMaxExpense = "";
            String nameMaxIncome = "";
            System.out.println("Месяц: " + month);
            for (MonthData monthData : monthlyReport.nameOfMonthData.get(month)) { //Достаем и считаем все траты/доходы за месяц
                int tempVar = monthData.sum_of_one * monthData.quantity;
                if (monthData.is_expense) {
                    if (tempVar > maxExpense) {
                        maxExpense = tempVar;
                        nameMaxExpense = monthData.item_name;
                    }
                } else if (tempVar > maxIncome) {
                    maxIncome = tempVar;
                    nameMaxIncome = monthData.item_name;
                }
            }
            System.out.println("Самый прибыльный товар: " + nameMaxIncome + " - " + maxIncome);
            System.out.println("Самая большая трата: " + nameMaxExpense + " - " + maxExpense + "\n");
        }
    }

    void check() { // Сравнение отчетов
        boolean check = true;
        for (int month = 1; month < 4; month++) {
            int sumExpense = 0;
            int sumIncome = 0;
            for (MonthData monthData : monthlyReport.nameOfMonthData.get(month)) { //Подсчет трат и расходов за месяц
                if (monthData.is_expense) {
                    sumExpense += monthData.sum_of_one * monthData.quantity;
                } else {
                    sumIncome += monthData.sum_of_one * monthData.quantity;
                }
            }
            for (YearData yearData : yearlyReport.nameOfYearData) { //Сравнение подсчитанных трат и расходов за месяц
                if (month == yearData.month) {
                    if (yearData.is_expense) {
                        if (yearData.amount != sumExpense) {
                            System.out.println("Данные трат за " + month + " месяц не совпадают с годовым отчетом\n");
                            check = false;
                        }
                    } else if (yearData.amount != sumIncome) {
                        System.out.println("Данные прибыли за " + month + " месяц не совпадают с годовым отчетом\n");
                        check = false;
                    }
                }
            }
        }
        if (check) {
            System.out.println("Сверка данных завершена!\nОшибок не обнаруженj!\n");
        }
    }
}

