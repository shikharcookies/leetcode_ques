class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<WordStep> queue = new LinkedList<>();
        queue.add(new WordStep(beginWord, 1));
        wordSet.remove(beginWord);

        while (!queue.isEmpty()) {
            WordStep current = queue.poll();
            String currWord = current.word;
            int steps = current.steps;

            if (currWord.equals(endWord)) return steps;

            for (int i = 0; i < currWord.length(); i++) {
                char[] wordChars = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wordChars[i] = c;
                    String newWord = new String(wordChars);
                    if (wordSet.contains(newWord)) {
                        queue.add(new WordStep(newWord, steps + 1));
                        wordSet.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }
}

class WordStep {
    String word;
    int steps;

    WordStep(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}
