package application;

import task1.Cat;
import task1.Dog;
import task1.Bowl;
import task1.Animal;
import task2.Circle;
import task2.Rectangle;
import task2.Shape;
import task2.Triangle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        Cat[] cats = {
                new Cat("Кот_1"),
                new Cat("Кот_2"),
                new Cat("Кот_3")
        };

        Dog[] dogs = {
                new Dog("Собака_1"),
                new Dog("Собака_2"),
                new Dog("Собака_3")
        };

        int[] runDistances = {150, 200, 550};
        int[] swimDistances = {5, 10, 15};

        for (int i = 0; i < cats.length; i++) {
            cats[i].run(runDistances[i]);
            cats[i].swim(swimDistances[i]);
        }

        for (int i = 0; i < dogs.length; i++) {
            dogs[i].run(runDistances[i]);
            dogs[i].swim(swimDistances[i]);
        }

        Bowl bowl = new Bowl(25);
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(bowl, 10);
            if (!cats[i].isFull() && i == cats.length - 1) {
                System.out.println("В миске осталось " + bowl.getFoodAmount() + " единиц еды. Добавляем в миску 25 единиц еды");
                bowl.addFood(25);
                System.out.println("В миске " + bowl.getFoodAmount() + " единиц еды");
                cats[i].eat(bowl, 10);
            }
            System.out.println("В миске осталось " + bowl.getFoodAmount() + " единиц еды. Сытость " + cats[i].getName() + ": " + cats[i].isFull());
        }

        System.out.println("Всего животных: " + Animal.getCount());
        System.out.println("Всего котов: " + Cat.getCount());
        System.out.println("Всего собак: " + Dog.getCount());

        System.out.println("\nTask 2");
        Shape circle = new Circle(3, "оранжевый", "зеленый");
        Shape rectangle = new Rectangle(4, 6, "синий", "черный");
        Shape triangle = new Triangle(6, 8, 7, "бежевый", "серый");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}