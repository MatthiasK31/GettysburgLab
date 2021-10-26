import java.util.*;
import java.io.*;


public class WordLister {
    public static void main(String[] args) throws FileNotFoundException {
        //variable declarations
        String word = "";
        Scanner file = new Scanner(new File("src\\gettysburg.txt"));
        ArrayList<String> words = new ArrayList();
        int position = 0;

        //loop through the file and allocate each item to its own spot in the arraylist
        while (file.hasNext())
        {
            words.add(file.next());

        }
        //loop through the arraylist and print each item individually
        for (int i = 0; i < words.size(); i++)
        {
            System.out.println(words.get(i));
        }

        //loop through the entire arraylist and take the average of the lengths
        double average = 0;
        for (int i = 0; i < words.size()-1; i++)
        {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < words.get(i).length()-1; j++) {
                if (words.get(i).charAt(j) == ',')
                    continue;
                else
                    temp.append(words.get(j).charAt(j));
            }
            average += temp.length();
        }
        average /= words.size();
        System.out.println("The average length of a word is " + average + " letters.");





    }
}
