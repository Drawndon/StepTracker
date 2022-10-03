import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вас приветствует счётчик калорий!");

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) { //ввод кол-ва шагов
                int month;
                int day;
                int steps;
                System.out.println("Укажите месяц (число от 0 до 11)");
                month = scanner.nextInt();
                if (month >= 0 && month < 12) {
                    System.out.println("Укажите день (число от 1 до 30)");
                    day = scanner.nextInt();
                    if (day >= 1 && day < 31) {
                        System.out.println("Укажите кол-во шагов");
                        steps = scanner.nextInt();
                        if (steps >= 0) {
                            stepTracker.saveSteps(month, day, steps);
                        } else {
                            System.out.println("Такой месяц выбрать нельзя");
                        }
                    } else {
                        System.out.println("Такой день выбрать нельзя");
                    }
                } else {
                    System.out.println("Столько шагов ввести нельзя");
                }
            } else if (userInput == 2) { //вывод статистики
                System.out.println("Укажите месяц");
                int monthS = scanner.nextInt();
                stepTracker.printStepsByDay(monthS);
                System.out.println("Общее кол-во шагов за месяц: " + stepTracker.findStepsSum(monthS));
                stepTracker.findMaxSteps(monthS);
                stepTracker.findAvrSteps(monthS);
                converter.printDistance(stepTracker.findStepsSum(monthS));
                converter.printCalories(stepTracker.findStepsSum(monthS));
                stepTracker.findBestStreak(monthS);
                System.out.println();
            } else if (userInput == 3) { //изменить цель по кол-ву шагов в день
                int newStepsGoal;
                while (true) {
                    System.out.println("Укажите кол-во шагов");
                    newStepsGoal = scanner.nextInt();
                    if (newStepsGoal >= 0) {
                        break;
                    } else {
                        System.out.println("Такое число ввести нельзя");
                    }
                }
                stepTracker.changeStepsGoal(newStepsGoal);
                System.out.println("Текущая цель по шагам: " + stepTracker.stepsGoal);
            } else {
                System.out.println("Извините, такой команды пока нет");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");

    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести кол-во шагов");
        System.out.println("2 - Вывести статистику");
        System.out.println("3 - Изменить цель по кол-ву шагов в день");
        System.out.println("0 - Выход");
    }
}
