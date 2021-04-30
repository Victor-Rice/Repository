package Practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> masterStrings = new ArrayList<>();
        String placeholder;
        Scanner userInput = new Scanner(System.in);
        String search;
        System.out.println("Enter Search term: ");
        search=userInput.next();
        int counter=1;
        ArrayList<Integer> counterPlaceholder = new ArrayList<>();



        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br =new BufferedReader(fr);

        while ((placeholder=br.readLine())!=null){
            masterStrings.add(placeholder);
            if(placeholder.contains(search)){
                counterPlaceholder.add(counter);
            }else;
            counter++;
        }
        System.out.println("Lines: "+counterPlaceholder);

        FileWriter fw = new FileWriter("out.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for(String s:masterStrings){
            bw.write(s+"\n");
        }
        bw.close();
    }
}
