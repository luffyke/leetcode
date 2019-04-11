public class JewelsAndStones {
    
    public int numJewelsInStones(String J, String S) {
        int i = 0;
        for (char c : S.toCharArray()) {
            if (J.indexOf(c) != -1) {
                i++;
            }
        }
        return i;
    }
}