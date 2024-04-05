package task1_2_3;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String name, String position, String email, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployee() {
        System.out.println("ФИО: " + name + ", Должность: " + position + ", Email: " + email + ", Телефон: " + phone + ", Зарплата: " + salary + ", Возраст: " + age);
    }
}