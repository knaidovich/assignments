public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        String[] wordsArray = {"работа", "мир", "время", "дело", "жизнь", "день", "вопрос", "работа", "слово", "место", "вопрос", "дом", "сторона", "мир", "работа"};
        UniqueWords uniqueWords = new UniqueWords(wordsArray);
        uniqueWords.printUniqueWords();

        System.out.println("Task 2");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Смирнов", "+123456789");
        phoneBook.add("Жуков", "+234567891");
        phoneBook.add("Романов", "+345678912");
        phoneBook.add("Остапов", "+456789123");
        phoneBook.add("Жуков", "+56789456");

        System.out.println("Номер телефона Смирнова: " + phoneBook.get("Смирнов"));
        System.out.println("Номер телефона Жукова: " + phoneBook.get("Жуков"));
        System.out.println("Номер телефона Романова: " + phoneBook.get("Романов"));
        System.out.println("Номер телефона Остапова: " + phoneBook.get("Остапов"));
    }
}