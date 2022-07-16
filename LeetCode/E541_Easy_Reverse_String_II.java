public class E541_Easy_Reverse_String_II {
    public String reverseStr(String s, int k) {
        StringBuilder st = new StringBuilder(s);
        for(int i=0, j=k-1; i<k/2;i++,j--){
            char c = s.charAt(i);
            st.setCharAt(i, s.charAt(j));
            st.setCharAt(j, c);
        }
        return st.toString();
    }
}
