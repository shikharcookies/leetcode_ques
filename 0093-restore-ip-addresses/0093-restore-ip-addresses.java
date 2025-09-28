class Solution {
    public List<String> restoreIpAddresses(String s) {
        

        List<String> res = new ArrayList<>();

        if(s.length()>12)
        {
            return res;
        }

        backtrack(0,0,"",s,res);
        return res;
    }

    private void backtrack(int i, int dots, String currIP, String s, List<String> res)
    {
        if(dots==4 && i==s.length())
        {
            res.add(currIP.substring(0,currIP.length()-1));
            return;
        }
        if(dots>4)
        {
            return;
        }

        for(int j=i;j<Math.min(i+3,s.length());j++)
        {
            String segment = s.substring(i,j+1); // i tells where we start and j tells where we end

            int segmentValue = Integer.parseInt(segment);

            if(segmentValue<256 && (i==j || s.charAt(i)!='0'))
            {
                backtrack(j+1,dots+1,currIP + segment + ".",s,res);
            }
        }
    }
}