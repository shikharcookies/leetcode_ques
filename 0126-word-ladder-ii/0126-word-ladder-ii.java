class Solution {

    String startWord;
    Map<String, Integer> wordSteps = new HashMap<>();
    List<List<String>> allPaths = new ArrayList<>();

    private void dfs(String currentWord, List<String> path) {
        if (currentWord.equals(startWord)) {
            List<String> result = new ArrayList<>(path);
            Collections.reverse(result);
            allPaths.add(result);
            return;
        }

        int currentStep = wordSteps.get(currentWord);

        for (int i = 0; i < currentWord.length(); i++) {
            char[] chars = currentWord.toCharArray();

            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String nextWord = new String(chars);

                if (wordSteps.containsKey(nextWord) && wordSteps.get(nextWord) + 1 == currentStep) {
                    path.add(nextWord);
                    dfs(nextWord, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        startWord = beginWord;
        Set<String> dictionary = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        if (!dictionary.contains(endWord)) return allPaths;

        queue.add(beginWord);
        wordSteps.put(beginWord, 1);
        dictionary.remove(beginWord);

        // BFS to build shortest path tree (wordSteps)
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int steps = wordSteps.get(word);

            if (word.equals(endWord)) break;

            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String newWord = new String(chars);

                    if (dictionary.contains(newWord)) {
                        queue.add(newWord);
                        wordSteps.put(newWord, steps + 1);
                        dictionary.remove(newWord);
                    }
                }
            }
        }

        // Backtrack using DFS to collect paths
        if (wordSteps.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, path);
        }

        return allPaths;
    }
}
