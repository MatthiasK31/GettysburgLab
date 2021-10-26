import java.text.DecimalFormat;
import java.util.*;
import java.io.*;



public class WordLister {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            //variable declarations
            String word = "";
            Scanner file = new Scanner(new File("src\\gettysburg.txt"));
            ArrayList<String> words = new ArrayList();
            int position = 0;

            //loop through the file and allocate each item to its own spot in the arraylist
            while (file.hasNext()) {
                words.add(file.next());
            }
            //loop through the arraylist and print each item individually
            for (int i = 0; i < words.size(); i++) {
                System.out.println(words.get(i));
            }

            //loop through the entire arraylist and take the average of the lengths
            double average = 0;
            int longestLength = words.get(0).length();
            String longestWord = words.get(0);
            for (int i = 0; i < words.size() - 1; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < words.get(i).length() - 1; j++) {
                    if (words.get(i).charAt(j) == ',' || words.get(i).charAt(j) == '.' || words.get(i).charAt(j) == '-')
                        continue;
                    else
                        temp.append(words.get(i).charAt(j));
                }
                if (words.get(i).length() > longestLength) {
                    longestLength = words.get(i).length();
                    longestWord = words.get(i);
                }

                average += temp.length();
            }
            average /= words.size();

            System.out.println("What word would you like to search for in the Gettysburg Address?");
            Iterator<String> i = words.iterator();
            while (i.hasNext()){

            }


            System.out.printf("The average length of a word is %.2f letters.\n", average);
            System.out.printf("The longest word is %s, with a length of %d letters.\n", longestWord, longestLength);

            //find length of longest word + longest word
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }
}
