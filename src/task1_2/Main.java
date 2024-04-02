package task1_2;

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
    }
}