public class Main {
    static int problemOne(String s){
        int answer = 0;
        //loop to find vowels and add to answer counter
        for (int Y=0;Y<s.length();Y++){
            switch(s.substring(Y,Y+1)) {
                case "a":
                    answer++;
                    break;
                case "e":
                    answer++;
                    break;
                case "i":
                    answer++;
                    break;
                case "o":
                    answer++;
                    break;
                case "u":
                    answer++;
                    break;
            }
        }
        return answer;
    }
    static int problemTwo(String s){
        int answer = 0;
        //loop to scan 3 letters at a time, moving by one letter per scan to find bob which then adds +1 to counter.
        String isItBob;
        for(int i=0;i<s.length()-2;i++){
            isItBob = s.substring(i,i+3);
            if (isItBob.equals("bob")){
                answer++;
            }
        }
        return answer;
    }
    static String problemThree(String s){
       // defines things
        char letter1;
        char letter2;
        int counter=1;
        int marker=0;
        String longest=s.substring(0,1);
        String currentS=s.substring(0,1);

        //loop for checking letters, moving marker to check the length of alphabetical
        for(int i=0;i<s.length()-1;i++){
            letter1 = s.charAt(i);
            letter2 = s.charAt(i+1);
            if(letter1<=letter2){
                currentS=s.substring(marker,marker+counter+1);
                counter++;
            }
            //resets counter and moves marker
            else{
                marker=i+1;
                counter=1;
            }
            //remembers longest of the string
            if (currentS.length()>longest.length()){
                longest=currentS;
            }
        }
        return longest;
    }
    public static void main(String[] args) {

        String s = "";
        //transfers method answer and prints out counters
        int problemOneAnswer = problemOne(s);
        System.out.println(problemOneAnswer);

        int problemTwoAnswer = problemTwo(s);
        System.out.println(problemTwoAnswer);

        String problemThreeAnswer = problemThree(s);
        System.out.println(problemThreeAnswer);
    }
}
