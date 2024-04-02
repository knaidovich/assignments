package task3;

public class Main {
    public static void main(String[] args) {
        Park park = new Park();
        Park.Attraction attraction1 = park.new Attraction("Батут", "09:00 - 20:00", 1.5);
        Park.Attraction attraction2 = park.new Attraction("Лабиринт", "09:00 - 20:00", 2.0);
        Park.Attraction attraction3 = park.new Attraction("Колесо обозрения", "09:00 - 20:00", 4.5);

        attraction1.printAttraction();
        attraction2.printAttraction();
        attraction3.printAttraction();
    }
}