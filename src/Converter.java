public class Converter {
    //Для подсчёта дистанции можно считать, что один шаг равен 75 см.
    //Для подсчёта количества сожжённых килокалорий можно считать,
    //что 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.
    double stepFinal = 0.00075;
    double stepKilocaloryFinal = 0.050;


    public void printCalories(int steps) {

        int calories = (int) (steps * stepKilocaloryFinal);
        System.out.println("Сожжённых килокалорий: " + calories);
    }

    public void printDistance(double steps) {
        double distance = steps * stepFinal;
        System.out.println("Пройденная дистанция: " + distance + " км.");
    }
}
