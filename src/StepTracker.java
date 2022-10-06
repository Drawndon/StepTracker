public class StepTracker {
    int stepsGoal = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        //int[] days = new int[] {5000, 11000, 11000, 5000, 5000, 5000, 5000, 0, 2000, 0, 0, 0, 0, 11000, 11000, 11000, 0, 0, 300, 0,0, 0, 500, 0, 11000, 11000, 11000, 11000, 11028, 20000};
        int[] days = new int[30];
    }

    public void setNewStepsGoal(int newStepsGoal) {
        stepsGoal = newStepsGoal;
    }

    public void saveSteps(int month, int day, int steps) {
        MonthData monthData = monthToData[month];
        monthData.days[day-1] = steps;
    }

    //ниже методы для выводы статистики
    public void printStepsByDay(int monthS) {
        for (int i = 0; i < 30; i++) {
            System.out.print((i+1) + " день: " + monthToData[monthS].days[i]);
            if (i < 29) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public int findStepsSum(int monthS) {
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum = sum + monthToData[monthS].days[i];
        }
        return sum;
    }

    public void getMaxSteps(int monthS) {
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if (monthToData[monthS].days[i] > maxSteps) {
                maxSteps = monthToData[monthS].days[i];
            }
        }
        System.out.println("Максимальное пройденное кол-во шагов в месяце: " + maxSteps);
    }

    public void getAvrSteps(int monthS) {
        int sum = 0;
        int avr;
        for (int i = 0; i < 30; i++) {
            sum = sum + monthToData[monthS].days[i];
        }
        avr = sum/30;
        System.out.println("Cреднее кол-во шагов: " + avr);
    }

    public void getBestInterval(int monthS) {
        int bestInterval = 1;
        int[] bestIntervalA = new int[30];
        int max = 0;

        for (int i = 0; i < 29; i++) {
            if (monthToData[monthS].days[i] >= stepsGoal) {
                if (monthToData[monthS].days[i + 1] >= stepsGoal) {
                    bestInterval++;
                }
                if ((monthToData[monthS].days[i + 1] < stepsGoal) | (i + 1 == 29)) {
                    bestIntervalA[i] = bestInterval;
                    bestInterval = 1;
                }
            }
        }
        for (int i = 0; i < 30; i++) {
            if (bestIntervalA[i] > max) {
                max = bestIntervalA[i];
            }
        }
        System.out.println("Лучшая серия (дней): " + max);
    }
}
