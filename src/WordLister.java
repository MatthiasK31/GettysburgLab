import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/*
Matthias Kim
Gettysburg Lab
10/26/2021
Runs through the Gettysburg Address which is pretty cool I guess.
Not required, but extra creates a countdown then displays list of words.
 */

public class WordLister {
    //scanner within the class scope
    static Scanner in = new Scanner(System.in);

    //fun method to display output after a countdown
    public void countdown(int outputType) throws InterruptedException {
        String input = "";
        switch (outputType) {
            case 0 -> {
                System.out.println("Press any key to display each word of the Gettysburg Address:");
                input = in.nextLine();
            }
            case 1 -> {
                System.out.println("\nPress any key to display the Gettysburg Address in lexicographic order:");
                input = in.nextLine();
            }
            case 2 -> {
                System.out.println("\nPress any key to display the Gettysburg Address without any duplicate words:");
                input = in.nextLine();
            }
        }

        System.out.print("Displaying output in...");
        for (int i = 3; i >= 0; i--) {
            System.out.printf("%d...", i);
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        WordLister w = new WordLister();

        try {
            //variable declarations
            Scanner file = new Scanner(new File("src\\gettysburg.txt"));
            ArrayList<String> words = new ArrayList<>();
            double average = 0;

            //loop through the file and allocate each item to its own spot in the arraylist
            while (file.hasNext()) {
                words.add(file.next());
            }

            //countdown
            w.countdown(0);

            //loop through the arraylist and print each item individually
            int pos = 0;
            new StringBuilder();
            StringBuilder temp;
            for (String value : words) {
                //reset temp for each iteration
                temp = new StringBuilder();
                //index each word and remove any commas or periods
                for (int i = 0; i < value.length(); i++) {
                    if (!(value.charAt(i) == ',' || value.charAt(i) == '.'))
                        temp.append(value.charAt(i));
                }
                //add the length of the newly trimmed word to the total character count
                average += temp.length();

                //change the value of the arraylist to the trimmed word, then print
                words.set(pos, temp.toString());
                System.out.println(words.get(pos));
                pos++;
            }
            //calculate average character count/word
            average /= words.size();

            //get the longest word and the length of that word
            int longestLength = words.get(0).length();
            String longestWord = words.get(0);
            for (String s : words){
                if (s.length() > longestLength) {
                    longestLength = s.length();
                    longestWord = s;
                }
            }

            //ask user what word they would like to search for
            System.out.println("What word would you like to search for in the Gettysburg Address?");
            String searchWord = in.nextLine();
            int timesFound = 0;
            for (String s : words) {
                if (s.equalsIgnoreCase(searchWord)) {
                    timesFound++;
                }
            }
            System.out.printf("The word \"%s\" was found a total of %d times!\n", searchWord, timesFound);
            System.out.printf("The average length of a word is %.2f letters.\n", average);
            System.out.printf("The longest word is %s, with a length of %d letters.\n", longestWord, longestLength);

            //lexi countdown
            w.countdown(1);
            //print in lexicographic order
            for (int i = 0; i < words.size(); i++){
                for (int j = i + 1; j < words.size(); j++){
                    if (words.get(i).compareTo(words.get(j)) > 0){
                        String t = words.get(i);
                        words.set(i, words.get(j));
                        words.set(j, t);
                    }
                }
            }
            for (String order : words){
                System.out.println(order);
            }

            //duplicate countdown
            w.countdown(2);
            //remove duplicates
            ArrayList<String> removeDuplicates = new ArrayList<>();
            for (String e : words){
                if (!removeDuplicates.contains(e))
                    removeDuplicates.add(e);
            }
            for (String removed : removeDuplicates){
                System.out.println(removed);
            }
        } catch (FileNotFoundException | InterruptedException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}