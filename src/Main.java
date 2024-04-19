import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words = readFile();

        int count = countWords(words);
        System.out.println("В файле " + count + " слов");

        String longest = findLongest(words);
        System.out.println(longest + " - самое длинное слово");

        Map<String, Integer> wosdsPeriodicity = eachWordCount(words);
        System.out.println("Частота встречаемости слов: " + wosdsPeriodicity);
    }

    public static List<String> readFile(){
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNext()){
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    public static int countWords(List<String> words){
        return words.size();
    }

    public static String findLongest(List<String> words){
        String longest = words.get(0);
        for (String word : words){
            if (word.length() > longest.length()){
                longest = word;
            }
        }
        return longest;
    }

    public static Map<String, Integer> eachWordCount(List<String> words){
        Map<String, Integer> wosdsPeriodicity = new HashMap<>();
        for (String word : words){
            wosdsPeriodicity.put(word, wosdsPeriodicity.getOrDefault(word, 0) + 1);
        }
        return wosdsPeriodicity;
    }
}


//1. Подсчет слов
//2. Самое длинное слово
//3. Подсчет каждого фрукта

//Использовать HashMap