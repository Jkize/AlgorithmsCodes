public class E344_Easy_Reverse_string {
    public void reverseString(char[] s) {
        for(int i=0, j=s.length-1; i<s.length/2; i++,j--){
            char save = s[i];
            s[i]=s[j];
            s[j]=save;
        }
    }
}
