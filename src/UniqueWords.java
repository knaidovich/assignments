import java.util.HashMap;
import java.util.Map;

public class UniqueWords {
    private final String[] wordsArray;

    public UniqueWords(String[] wordsArray) {
        this.wordsArray = wordsArray;
    }

    public void printUniqueWords() {
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : wordsArray) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова: " + wordsCount.keySet());

        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            System.out.println("Слово " + entry.getKey() + " встречается " + entry.getValue() + " раз(а).");
        }
    }
}