import java.io.*;
import java.util.*;

class Pair<T, U> { // use first as line no. and second as position in line
    T first;
    U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return ("{ " + first.toString() + " , " + second.toString() + " }");
    }
}

public class Five {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter file name : ");
        // String fName = sc.nextLine(); // take file name from user
        FileReader file = new FileReader("D:\\Assignment\\Sem4\\Oops\\assignment1\\test.txt");
        sc = new Scanner(file); // open BufferedReader with file
        TreeMap<String, ArrayList<Pair<Integer, Integer>>> alphaIndex = new TreeMap<>();
        String line;
        // create TreeMap to store words with their line nos.
        
        for (int i = 1;true;i++){
            line=sc.nextLine();
            String arr[] = line.toLowerCase().split("[\s,;:.?!(){}\"]");
            // regex to split using whitespaces and punctuations
            for (int j = 0; j < arr.length; ++j) {
                if (arr[j].isEmpty())
                    continue;
                // if string is not there add it Tree map and its corresponding new ArrayList
                if (!alphaIndex.containsKey(arr[j]))
                    alphaIndex.put(arr[j], new ArrayList<Pair<Integer, Integer>>());
                // add line no. position pair to ArrayList of corresponding String
                alphaIndex.get(arr[j]).add(new Pair<Integer, Integer>(i, j + 1));
            }
            if(!sc.hasNextLine())break;
        }
        file.close();
        // close BufferedReader and FileReader and print corresponding key value pairs
        for (Map.Entry<String, ArrayList<Pair<Integer, Integer>>> mapElement : alphaIndex.entrySet()) {
            System.out.println(mapElement.getKey() + " :- " + mapElement.getValue().toString());
        }
    }
}
