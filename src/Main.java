import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        int[] input  =   {25, 14, 9, 7, 5, 3, 0, 21, 6, 33, 25, 42, 24, 107};
        String[] input1 = {"google", "gojo", "amazingly", "jogo", "luna",
                            "pup", "solas", "solo", "pupperino", "amaterasu",
                             "amazon", "puppy", "hydra", "amazonia", "vueltiao"};
         int i = 0;

         System.out.println("Hashing Results");
         for(int x: input){
             System.out.print(hash(x) + " ");
         }
         System.out.println('\n');

System.out.println("Unsorted String list");
        for(String x: input1){
            System.out.println(x);
        }

        input1 = radixSort(input1);
        System.out.println('\n');
        System.out.println("The Sorted String list using Radix Sort" + '\n');

        for(String x: input1){
            System.out.println(x);
        }

        String p = "abba";
        char delim = '?';
        String s = "dog?cat?cat?dog";

        String p1 = "aaaa";
        char delimiter =  ',';
        String s1 = "dog,cat,cat,dog";

        String p2 = "aaaa";
        char delimiter1  = ' ';
        String s2 = "ice cream taco day";


        String  p3 = "adxp";
        char delimiter2 = ' ';
        String s3 = "ice cream taco day";




        System.out.println("\n Word Pattern");

            System.out.println(wordPattern(p, delim, s));

            System.out.println(wordPattern(p1, delimiter, s1));

            System.out.println(wordPattern(p2, delimiter1, s2));

            System.out.println(wordPattern(p3, delimiter2, s3));

    }

    public static String[] countSort(String[] input, int length, int pos) {

        String ret[] = new String[length];
        int count[] = new int[256];


        for (int i = 0; i < length; i++) {
            int charPos;
            if (input[i].length()    > pos) {
                charPos = input[i].charAt(pos);
            } else {
                charPos = 0;
            }
            count[charPos]++;
        }

        for(int i = 1; i < 256; i++){
            count[i] += count[i-1];
        }

        for(int i = length - 1; i >= 0; i--){
            int charPos;
            if(input[i].length() > pos){
                charPos = input[i].charAt(pos);
            }else{
                charPos =  0;
            }
            ret[count[charPos] - 1 ] = input[i];
            count[charPos]--;
        }

        for(int i = 0; i < length; i++){
            input[i] = ret[i];
        }

        return input;
    }

    public static String[] radixSort(String[] s) {

        int longestLen = getMaxLength(s) - 1;


        for (int i = longestLen; i >= 0; i--) {
            countSort(s, s.length, i);
        }

        return s;
    }

    public static int getMaxLength(String[] s){

        int max = 0;
        for(int i = 0; i < s.length; i++){
            if(max < s[i].length()){
                max = s[i].length();
            }
        }

        return max;
    }

    public static int hash(int x) {
        int y;
        y = (x + 19) * (x + 11);
        y = y / 15;
        y = y + x;
        y = y % 26;
        return y;
    }

   public static boolean wordPattern(String p, char delim, String s){

        String delimiter = "\\" + delim;
        String[] strings = s.split(String.valueOf(delimiter));

        System.out.println("Pattern P: " + p + " " + "Deliminter : " + delim +
                " " + "String Input: " + s);


        if(strings.length != p.length()){
            return false;
        }

        HashMap<Character, String> charMapString = new HashMap<>();
        HashMap<String, Character> stringMapCharacter = new HashMap<>();

        for(int i = 0; i < p.length(); i++ ){

            if(charMapString.containsKey(p.charAt(i))){
                if(!charMapString.get(p.charAt(i)).equals(strings[i])){
                    return false;
                }
            }
            else {
                charMapString.put(p.charAt(i), strings[i]);
            }

            if(stringMapCharacter.containsKey(strings[i])){
                if(stringMapCharacter.get(strings[i]) != p.charAt(i)){
                    return false;
                }
            }else {
                stringMapCharacter.put(strings[i],p.charAt(i));
            }
        }

        return true;
   }

   public static String[] split(String s, int length, char delim){
        String[] ret = new String[length];
        StringBuilder  stringBuilder = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != delim){
                stringBuilder.append(s.charAt(i));
            }
            else{
                stringBuilder.reverse().toString();
            }
        }

        return ret;
   }

   public static int[] subArray(int[] a, int k){

        int[] notTrue = {-1,-1};
        return notTrue;

   }
}