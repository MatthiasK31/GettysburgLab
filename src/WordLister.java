import java.util.*;
import java.io.*;


public class WordLister {
    public static void main(String[] args) throws FileNotFoundException {
        String word = "";
        Scanner file = new Scanner(new File("src\\fish.txt"));
        ArrayList<String> words = new ArrayList();
        int position = 0;
        // assume filename stores the name of the file
        while (file.hasNext())
        {
            String temp = "";
            words.add(file.next());
            for (int i = 0; i < words.get(position).length(); i++) {
                if (words.get(position).charAt(i) == ',')
                    continue;
                else
                    temp += words.get(position).charAt(i);
            }
            words.set(position, temp);
            position++;
        }

        System.out.println(words);
        System.out.println(word);

    }
}
