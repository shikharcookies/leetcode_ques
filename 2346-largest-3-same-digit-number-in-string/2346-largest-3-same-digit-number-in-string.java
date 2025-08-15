class Solution {
    public String largestGoodInteger(String num) {
        String[] p = {"999","888","777","666","555","444","333","222","111","000"};
        for(int i=0;i<p.length;i++)
        {
            if(num.contains(p[i]))
            {
                return p[i];
            }
        }
        return "";
    }
}