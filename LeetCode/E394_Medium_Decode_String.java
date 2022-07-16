import java.util.Stack;

public class E394_Medium_Decode_String {

    public static void main(String[] args) {
        E394_Medium_Decode_String sol = new E394_Medium_Decode_String();
        String sl = sol.decodeString("3[a]2[bc]");

        System.out.println(sl);
    }

    /*
     * Runtime: 4 ms, faster than 36.34% of Java online submissions for Decode
     * String.
     * Memory Usage: 42.7 MB, less than 14.57% of Java online submissions for Decode
     * String.
     */
    public String decodeString(String s) {

        Stack<String> st = new Stack<>();

        StringBuilder help = new StringBuilder();
        int rep = 0;

        for (Character c : s.toCharArray()) {

            if (c == ']') {
                if (help.length() > 0) {  //Verify if help has letter and put in the stack
                    st.add(help.toString());
                    help = new StringBuilder();
                }
                StringBuilder build = new StringBuilder("");
                String dt;
                while (!(dt = st.pop()).equals("[")) {  //Get the strings until de "["
                    build.insert(0, dt);
                }

                int rp = Integer.parseInt(st.pop());
                StringBuilder cc = new StringBuilder();
                for (int i = 0; i < rp; i++) {   //Make a repetitions
                    cc.append(build.toString());
                }
                st.add(cc.toString());  //Put the repetitions

            } else if (c - 'a' >= 0 && c - 'a' < 26) { // If a letter
                help.append(c + "");                //Append the letter in order
            } else if (Character.isDigit(c)) { // If a digit
                if (help.length() > 0) {        //Verify if help has letter and put in the stack
                    st.add(help.toString());
                    help = new StringBuilder();
                }
                rep = rep * 10 + Integer.parseInt(c + "");
            } else { // If a [
                st.add(rep + ""); //Convert the num in string
                st.add("[");
                rep = 0;    //rep start again in 0
            }

        }
        if (help.length() > 0) {  //Verify if help has letter and put in the stack
            st.add(help.toString());
            help = new StringBuilder();
        }
        while (!st.isEmpty()) {
            help.insert(0, st.pop()); //Here compiled all the data of the stack
        }

        return String.valueOf(help); //Return answer
    }
}
