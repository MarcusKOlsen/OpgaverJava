public class reverse {

    public String reverse_string(String text){

        String[] words = text.split(" ");
        String[] reversed = new String[words.length];

        for(int cur_index = 0; cur_index < words.length; cur_index++){
            String reversed_string = new String(); 
            for(int x = words[cur_index].length() - 1; x >= 0; x--){
                reversed_string += words[cur_index].charAt(x);
                
            }
            reversed[cur_index] = reversed_string;
        }

        String finished = new String("");
        for(int i = 0; i < reversed.length; i++) {
            finished += reversed[i] + " ";
        }

        return finished;
    }

    public static void main(String[] args) {
    
        reverse penis = new reverse();
        String a = "Hello my name is";
        System.out.println(penis.reverse_string(a));

    }
}

