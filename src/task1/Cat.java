package task1;

public class Cat extends Animal {
    private static int count = 0;
    private boolean isFull = false;

    public Cat(String name) {
        super(name, 200, 0);
        count++;
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            isFull = true;
            System.out.println(getName() + " поел");
        } else {
            System.out.println(getName() + " не поел");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCount() {
        return count;
    }
}