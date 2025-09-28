class Solution {
    public String pushDominoes(String dominoes) {
        Domino newDomino = new Domino();
        int lastL=-1, lastR = -1;
        int n = dominoes.length();
        StringBuilder sb = new StringBuilder(dominoes);

        for(int pos=0;pos<n;pos++)
        {
            if(sb.charAt(pos)=='L')
            {
                if(lastR>lastL)
                {
                    newDomino.doubleDominoPush(lastR,pos,sb);
                }
                else if((lastL>lastR)|| lastL==-1)
                {
                    newDomino.leftDominoPush(lastL+1,pos-1,sb);
                }
                lastL = pos;
            }
            else if(sb.charAt(pos)=='R')
            {
                if(lastR>lastL)
                {
                    newDomino.rightDominoPush(lastR,pos-1,sb);
                }
                lastR=pos;
            }
        }
        if(lastR>lastL)
        {
            newDomino.rightDominoPush(lastR,n-1,sb);
        }
        return sb.toString();
    }
}

class Domino {
    public void doubleDominoPush(int lastR, int pos, StringBuilder dominoes)
    {
        while(lastR<pos)
        {
            dominoes.setCharAt(lastR++,'R');
            dominoes.setCharAt(pos--,'L');
        }
    }

    public void leftDominoPush(int start,int end, StringBuilder dominoes)
    {
        while(start<=end)
        {
            dominoes.setCharAt(start++,'L');
        }
    }

    public void rightDominoPush(int lastR, int pos, StringBuilder dominoes)
    {
        while(lastR<=pos)
        {
            dominoes.setCharAt(lastR++,'R');
        }
    }
}