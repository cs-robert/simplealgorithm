package com.algorithm.sort;

import java.util.Arrays;

public class Dijkstra {

    static int[][] map;

    static int[] distance;

    static boolean[] visited;

    public static void dijkstra(int beginIndex) {
        int nodeNum = map.length - 1;
        distance[beginIndex] = 0;
        // 所有结点都要访问一次，共nodeNum次
        // 第一次从beginIndex的结点开始
        // 然后每次从未访问过、并且可以访问的最近的结点开始
        for (int i = 0; i < nodeNum; i++) {
            int index = beginIndex;// index代表当前结点的下标
            int minDistance = Integer.MAX_VALUE;// minDistance代表起点到当前结点的最短距离
            for (int j = 1; j <= nodeNum; j++) {
                if (distance[j] < minDistance && !visited[j]) {
                    index = j;
                    minDistance = distance[j];
                }
            }

            for (int j = 1; j <= nodeNum; j++) {
                if (map[index][j] != 0 && minDistance + map[index][j] < distance[j]) {
                    distance[j] = minDistance + map[index][j];
                }
            }
            System.err.println(Arrays.toString(distance));
            visited[index] = true;
        }
    }

    public static void initResources() {
        map = new int[7][7];
        map[1][2] = 1;
        map[1][3] = 12;
        map[2][3] = 9;
        map[2][4] = 3;
        map[3][5] = 5;
        map[4][3] = 4;
        map[4][5] = 13;
        map[4][6] = 15;
        map[5][6] = 4;
        distance = new int[7];
        for (int i = 0; i < 7; i++) distance[i] = Integer.MAX_VALUE;
        visited = new boolean[7];
    }

    public static void main(String[] args) {
        initResources();
        dijkstra(1);
        System.err.println(Arrays.toString(distance));
    }

}