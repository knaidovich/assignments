package task3;

public class Park {
    class Attraction {
        String name;
        String workingHours;
        double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printAttraction() {
            System.out.println("Аттракцион: " + this.name + ", Время работы: " + this.workingHours + ", Стоимость: " + this.price);
        }
    }
}