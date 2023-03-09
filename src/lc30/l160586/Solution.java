package lc30.l160586;

/**
 * @author : tildev
 * @data : 2023-03-08
 */
public class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        int[] sum = new int[targets.length];
        int[] minArr = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            sum[i] = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                boolean hasC = false;
                minArr[i] = 101;
                for (int a = 0; a < keymap.length; a++) {
                    int value = keymap[a].indexOf(c);
                    if (value != -1) {
                        minArr[i] = Math.min(minArr[i], value);
                    }
                }
                if (minArr[i] != 101) {
                    hasC = true;
                    sum[i] += (minArr[i] + 1);
                }
                if (!hasC) {
                    sum[i] = -1;
                    break;
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        // String[] keymap = {"ABACD", "BCEFD"};
        // String[] targets = {"ABCD", "AABB"};
        // 9 4

        // String[] keymap = {"AA"};
        // String[] targets = {"B"};
        // -1

        String[] keymap = {"AGZ", "BSSS"};
        String[] targets = {"ASA", "BGZ"};
        // 4, 6

        int[] result = new Solution().solution(keymap, targets);

        for (int i : result) {
            System.out.println(i);
        }
    }
}