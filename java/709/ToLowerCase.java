public class ToLowerCase {
    
    public String toLowerCase(String str) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c >= 65 && c <= 90) {
                c += 32;
            }
            cs[i] = c;
        }
        return new String(cs);
    }
}