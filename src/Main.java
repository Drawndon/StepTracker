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
            switch (userInput) {
                case 1:
                    int month;
                    int day;
                    int steps;
                    System.out.println("Укажите месяц (число от 0 до 11)");
                    month = scanner.nextInt();
                    while (month < 0 || month > 11) {
                        System.out.println("Введите значение из диапазона");
                        month = scanner.nextInt();
                    }
                    System.out.println("Укажите день (число от 1 до 30)");
                    day = scanner.nextInt();
                    while (day < 0 || day > 30) {
                        System.out.println("Введите значение из диапазона");
                        day = scanner.nextInt();
                    }
                    System.out.println("Укажите кол-во шагов");
                    steps = scanner.nextInt();
                    while (steps < 0) {
                        System.out.println("Значение не может быть отрицательным");
                        steps = scanner.nextInt();
                    }
                    stepTracker.saveSteps(month, day, steps);
                    break;
                case 2:
                    System.out.println("Укажите месяц");
                    int monthS = scanner.nextInt();
                    stepTracker.printStepsByDay(monthS);
                    System.out.println("Общее кол-во шагов за месяц: " + stepTracker.findStepsSum(monthS));
                    stepTracker.getMaxSteps(monthS);
                    stepTracker.getAvrSteps(monthS);
                    converter.printDistance(stepTracker.findStepsSum(monthS));
                    converter.printCalories(stepTracker.findStepsSum(monthS));
                    stepTracker.getBestInterval(monthS);
                    System.out.println();
                    break;
                case 3:
                    int newStepsGoal;
                    System.out.println("Укажите кол-во шагов");
                    newStepsGoal = scanner.nextInt();
                    while (newStepsGoal < 0) {
                        System.out.println("Такое число ввести нельзя");
                        newStepsGoal = scanner.nextInt();
                    }

                    stepTracker.setNewStepsGoal(newStepsGoal);
                    System.out.println("Текущая цель по шагам: " + stepTracker.stepsGoal);
                    break;
                default:
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
