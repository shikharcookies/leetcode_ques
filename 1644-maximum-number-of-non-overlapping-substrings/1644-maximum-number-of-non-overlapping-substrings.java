class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        Map<Character, int[]> map = new HashMap<>();

        for(int i = 0; i < s.length(); ++i) {
            if(map.containsKey(s.charAt(i))) {
                int[] temp = map.get(s.charAt(i));
                temp[1] = i;
                map.put(s.charAt(i), temp);
            } else {
                map.put(s.charAt(i), new int[]{i, i});
            }
        }
        int subStart = -1;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int start = map.get(ch)[0];
            if(start == i) {
                int subEnd = getEnd(s, map, i);
                if(subEnd != -1 ) {
                    if(subEnd > subStart) 
                        res.add("");
                    subStart = subEnd;
                    res.set(res.size() - 1, s.substring(i, subStart + 1));
                }
                
            }
        }

        return res;

    }

    public int getEnd(String s, Map<Character, int[]> map, int start) {
        int end = map.get(s.charAt(start))[1];
        for(int i = start; i < end; ++i) {
            char ch = s.charAt(i);
            // System.out.println(end + " " + i);
            if(map.get(ch)[0] < start) {
                return -1;
            } else {
                end = Math.max(end, map.get(ch)[1]);
            }
        }
        return end;
    }
}