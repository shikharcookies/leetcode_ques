class Node {
    Node[] links = new Node[2];

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    Node get(int bit) {
        return links[bit];
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    int findMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

public class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int q = queries.length;
        int[] res = new int[q];

        // [xi, mi, originalIndex]
        int[][] offlineQueries = new int[q][3];
        for (int i = 0; i < q; i++) {
            offlineQueries[i][0] = queries[i][0]; // xi
            offlineQueries[i][1] = queries[i][1]; // mi
            offlineQueries[i][2] = i;             // original index
        }

        // Sort by mi
        Arrays.sort(offlineQueries, Comparator.comparingInt(a -> a[1]));

        Trie trie = new Trie();
        int i = 0;
        for (int[] query : offlineQueries) {
            int xi = query[0], mi = query[1], index = query[2];

            // Insert elements into the trie while nums[i] <= mi
            while (i < n && nums[i] <= mi) {
                trie.insert(nums[i]);
                i++;
            }

            if (i == 0) {
                res[index] = -1;
            } else {
                res[index] = trie.findMax(xi);
            }
        }

        return res;
    }
}
