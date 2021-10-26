import java.text.DecimalFormat;
import java.util.*;
import java.io.*;



public class WordLister {
    public static void main(String[] args) {
        try {
            //variable declarations
            String word = "";
            Scanner in = new Scanner(System.in);
            Scanner file = new Scanner(new File("src\\gettysburg.txt"));
            ArrayList<String> words = new ArrayList<>();

            //loop through the file and allocate each item to its own spot in the arraylist
            while (file.hasNext()) {
                words.add(file.next());
            }
            //loop through the arraylist and print each item individually
            for (String value : words) {
                System.out.println(value);
            }

            //can do enhanced for loop to sort

            //loop through the entire arraylist and take the average of the lengths

            double average = 0;
            int longestLength = words.get(0).length();
            String longestWord = words.get(0);
            for (String s : words){
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == ',' || s.charAt(i) == '.' || s.charAt(i) == '-')
                        continue;
                    else
                        temp.append(s.charAt(i));
                }
                if (s.length() > longestLength) {
                    longestLength = s.length();
                    longestWord = s;
                }
                average += temp.length();
            }
            average /= words.size();

            System.out.println("What word would you like to search for in the Gettysburg Address?");
            String searchWord = in.nextLine();
            int timesFound = 0;
            for (String s : words) {
                if (s.equalsIgnoreCase(searchWord)) {
                    timesFound++;
                }
            }
            System.out.printf("The word %s was found a total of %d times.\n", searchWord, timesFound);


            System.out.printf("The average length of a word is %.2f letters.\n", average);
            System.out.printf("The longest word is %s, with a length of %d letters.\n", longestWord, longestLength);

            //find length of longest word + longest word
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }
}
