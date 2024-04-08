package task2;

public interface Shape {
    double calculatePerimeter();

    double calculateArea();

    String getFillColor();

    String getBorderColor();

    default void printInfo() {
        System.out.println("Периметр: " + this.calculatePerimeter() + ", Площадь: " + this.calculateArea() + ", Цвет заливки: " + this.getFillColor() + ", Цвет границы: " + this.getBorderColor());
    }
}