class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> sadUsers = new HashSet<>();

        for(int[]friends : friendships)
        {
            int u = friends[0]-1;
            int v = friends[1]-1;


            Set<Integer> langSet = new HashSet<>();
            for(int lang : languages[u])
            {
                langSet.add(lang);
            }

            boolean canTalk = false;
            for(int lang : languages[v])
            {
                if(langSet.contains(lang))
                {
                    canTalk = true;
                    break;
                }
            }

            if(!canTalk)
            {
                sadUsers.add(u);
                sadUsers.add(v);
            }
        }

        int[] langCount = new int[n+1];
        int mostKnownLang = 0;
        for(int user : sadUsers)
        {
            for(int lang : languages[user])
            {
                langCount[lang]++;
                mostKnownLang = Math.max(mostKnownLang,langCount[lang]);
            }
        }

        return sadUsers.size()-mostKnownLang;
    }
}