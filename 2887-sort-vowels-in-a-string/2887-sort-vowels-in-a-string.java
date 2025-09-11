class Solution {
    public String sortVowels(String s) {
        Map<Character, Integer> vowels = new HashMap<>();
        for (char v : "AEIOUaeiou".toCharArray()) {
            vowels.put(v, 0);
        }
        for (char c : s.toCharArray()) {
            if (vowels.containsKey(c)) {
                vowels.put(c, vowels.get(c) + 1);
            }
        }
        char[] keys = {'A','E','I','O','U','a','e','i','o','u'};
        int k = 0;
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.containsKey(c)) {
                while (vowels.get(keys[k]) == 0) {
                    k++;
                }
                res[i] = keys[k];
                vowels.put(keys[k], vowels.get(keys[k]) - 1);
            } else {
                res[i] = c;
            }
        }
        return new String(res);
    }
}