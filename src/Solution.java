public class Solution {
    public boolean isValid(String s) {
        int l = s.length();
        String lefts = "{[(";
        String rights = "}])";
        boolean res = true;

        if (l % 2 != 0 ||
                rights.contains(String.valueOf(s.charAt(0))) ||
                lefts.contains(String.valueOf(s.charAt(l - 1))))
            return false;

        for (int i = 0; i < l; i+=2) {
            String pattern = String.valueOf(s.charAt(i)) + s.charAt(i + 1);
            res = switch (pattern){
                case"{}" -> true;
                case"()" -> true;
                case"[]" -> true;
                default -> false;
            };
            if (!res) break;
        }
        return res;
    }
}
