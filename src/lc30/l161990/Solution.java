package lc30.l161990;

/**
 * @author : tildev
 * @data : 2023-03-07
 */
public class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {-1, -1, -1, -1};
        int imp, limp;
        for (int i = 0; i < wallpaper.length; i++) {
            imp = wallpaper[i].indexOf("#");
            limp = wallpaper[i].lastIndexOf("#");
            if (imp != -1) {
                if (answer[0] == -1 || answer[0] > i) {
                    answer[0] = i;
                }
                if (answer[1] == -1 || answer[1] > imp) {
                    answer[1] = imp;
                }
            }
            if (limp != -1) {
                if (answer[2] == -1 || answer[2] <= i + 1) {
                    answer[2] = i + 1;
                }
                if (answer[3] == -1 || answer[3] <= limp + 1) {
                    answer[3] = limp + 1;
                }
            }
        }
        return answer;
    }

    public int[] solution1(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }

    public static void main(String[] args) {
        // String[] wallpaper = {".#...", "..#..", "...#."};
        // String[] wallpaper = {"..", "#."};
        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        int[] result = new Solution().solution1(wallpaper);

        for (int i : result) {
            System.out.println(i);
        }
    }
}