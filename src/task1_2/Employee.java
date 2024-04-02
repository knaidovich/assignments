package task1_2;

public class Employee {
    String name;
    String position;
    String mail;
    String phone;
    double salary;
    int age;

    public Employee(String name, String position, String mail, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployee() {
        System.out.println("ФИО: " + this.name + ", Должность: " + this.position + ", Mail: " + this.mail + ", Телефон: " + this.phone + ", Зарплата: " + this.salary + ", Возраст: " + this.age);
    }
}