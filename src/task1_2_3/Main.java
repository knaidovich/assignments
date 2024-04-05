package task1_2_3;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 2000.50, 30);
        employees[1] = new Employee("Petrova Anna", "Accountant", "petrova@mailbox.com", "892312313", 3500.10, 28);
        employees[2] = new Employee("Sidorov Alex", "Manager", "sidorov@mailbox.com", "892312314", 4000.50, 33);
        employees[3] = new Employee("Dmitriev Dmitry", "Developer", "dmitriev@mailbox.com", "892312315", 5000.90, 26);
        employees[4] = new Employee("Kuznetsova Maria", "Designer", "kuznetsova@mailbox.com", "892312316", 2050.50, 41);

        for (Employee employee : employees) {
            employee.printEmployee();
        }

        Park park = new Park();
        Park.Attraction attraction1 = park.new Attraction("Батут", "09:00 - 20:00", 1.5);
        Park.Attraction attraction2 = park.new Attraction("Лабиринт", "09:00 - 20:00", 2.0);
        Park.Attraction attraction3 = park.new Attraction("Колесо обозрения", "09:00 - 20:00", 4.5);

        attraction1.printAttraction();
        attraction2.printAttraction();
        attraction3.printAttraction();
    }
}