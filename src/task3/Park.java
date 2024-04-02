package task3;

public class Park {
    class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printAttraction() {
            System.out.println("Аттракцион: " + name + ", Время работы: " + workingHours + ", Стоимость: " + price);
        }
    }
}