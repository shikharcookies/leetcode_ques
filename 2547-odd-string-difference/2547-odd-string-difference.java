class Solution {
    public String oddString(String[] words) {
        HashMap<List<Integer>, String> map = new HashMap<>();

        for(String s:words)
        {
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<s.length()-1;i++)
            {
                temp.add(i,(s.charAt(i+1)-s.charAt(i)));
            }

            if(map.containsKey(temp))
            {
                map.put(temp,null);
            }
            else
            {
                map.put(temp,s);
            }
        }

            for(Map.Entry<List<Integer>, String> mapElement : map.entrySet())
            {
                String value = mapElement.getValue();
                if(value!=null)
                {
                    return value;
                }
            }
        return null;
    }
}