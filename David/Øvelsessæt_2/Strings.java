package David.Øvelsessæt_2;

public class Strings {
    public static int count(char c, String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == c){
                count++;
            }
        }
        return count;
    }
    public static boolean member(char c, String s){
        
        return s.contains(""+ c);
    }
    public static boolean isPrefix(String s1, String s2){
        int i = 0;
        boolean equal = true;
        while(i < s1.length() && equal){
            equal = s1.charAt(i) == s2.charAt(i);
            i++;
        }
        return equal;
    }

    public static boolean isSuffix(String s1, String s2){
        int i = s1.length();
        boolean equal = true;
        while(i >= 0 && equal){
            equal = s1.charAt(i) == s2.charAt(s2.length()-s1.length()+i);
            i++;
        }
        return equal;
    }
    public static boolean isSubstring(String s1, String s2){
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            else{
                i = 0;
            }
            j++;
        }
        return s1.length() == i;
    }
    public static boolean contains(String s1, String s2){
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            j++;
        }
        return s1.length() == i;
    }

    public static String toUppercase(String s){
        String UPPERCASE = new String();
        for (int i = 0; i < s.length(); i++){
            if ( 97 <= (int) s.charAt(i) && (int) s.charAt(i) <= 122){
                UPPERCASE = UPPERCASE + (char)((int)(s.charAt(i)-32));
            }
            else{
                UPPERCASE = UPPERCASE + s.charAt(i);
            }
            i++;
        }
        return UPPERCASE;
    }

    public static String toLowercase(String s){
        String lowercase = new String();
        for (int i = 0; i < s.length(); i++){
            if ( 65 <= (int) s.charAt(i) && (int) s.charAt(i) <= 90){
                lowercase = lowercase + (char)((int)(s.charAt(i)+32));
            }
            else{
                lowercase = lowercase + s.charAt(i);
            }
            i++;
        }
        return lowercase;
    }
    public static String toCamelCase(String s){
        String camelCase = new String();
        for (int i = 0; i < s.length(); i++){
            if ((int)s.charAt(i) == 32 && 97 <= (int) s.charAt(i+1) && (int) s.charAt(i+1) <= 122){
               i++;
                camelCase = camelCase + (char)((int)(s.charAt(i)-32));
                
            }
            else{
                camelCase = camelCase + s.charAt(i);
            }
        }
        return camelCase;
    }
    public static boolean equalsIgnoreCase(String s1, String s2){
        int i = 0;
        boolean equals = true;
        while (i < s1.length() && equals){
           equals = (s1.charAt(i) == s2.charAt(i) || 
            97 <= (int) s1.charAt(i) && (int) s1.charAt(i) <= 122 && 
            (int) s1.charAt(i) - (int) s2.charAt(i) == 32 ||
            97 <= (int) s2.charAt(i) && (int) s2.charAt(i) <= 122 && 
            (int) s2.charAt(i) - (int) s1.charAt(i) == 32);
            i++;
           }
           return equals;
           //return s1.equalsIgnoreCase(s2);
        }
    
    public static boolean isPermutation(String s1, String s2){
        return true;
        //TODO: fix this
        // when we get paid more
    }

    public static String reverse(String s){
        String reversed = new String();
        for(int i = s.length(); i >= 0; i--){
            reversed = reversed + s.charAt(i);
        }
        return reversed;
    }
    public static String reverseWords(String s){
        String reversed = new String();
        int nextSpace = 0;
        int i = 0;
        while( i < s.length()){
            nextSpace = s.indexOf(" ", i);
            int j = nextSpace;
                while(j >= i){
                    reversed = reversed + s.charAt(j);
                    j--;
                }
            if (nextSpace == -1){
                int n = s.length();
                while(n >= i){
                    reversed = reversed + s.charAt(n);
                    n--;
                }
                i = s.length();
            }
            else{
            reversed = reversed + " ";
            i = nextSpace + 1;
            }
            
    }
    return reversed;
    }
    public static String removeVowels(String s){
        String consonants = new String();
        for (int i = 0; i < s.length(); i++){
            // ASCII Values of vowels are 97, 101, 105, 111, 117, 65, 69, 73, 79, and 85
            if ((int)s.charAt(i) != 65 && (int)s.charAt(i) != 97 && (int)s.charAt(i) != 69 && (int)s.charAt(i) != 101 &&
            (int)s.charAt(i) != 73 && (int)s.charAt(i) != 105 && (int)s.charAt(i) != 79 && (int)s.charAt(i) != 111 &&
            (int)s.charAt(i) != 85 && (int)s.charAt(i) != 117){
                consonants = consonants + s.charAt(i);
            }
            i++;
        }
    return consonants;
    }
    public static String ceasarCode(String s, int n){
        String cryptid = new String();
        for (int i = 0; i < s.length(); i++){
            cryptid = cryptid + (char)(((int)s.charAt(i) + n ) % 256) ;
        }
    return cryptid;
    }
}

