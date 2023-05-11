//백준 > 단계별로 풀어보기 > 정렬 > 좌표 압축(18870)
package Java.Beakjoon.단계별로_풀어보기.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class Num18870 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        ArrayList<Integer> Xdots = new ArrayList<Integer>();
        ArrayList<Integer> copys = new ArrayList<Integer>();
        for(int i = 0; i < N; i++) {
            Xdots.add(i, Integer.parseInt(st.nextToken()));
            copys.add(Xdots.get(i));
        }
    
        Collections.sort(copys); //Timsort
        
        HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();
        int rank = 0;
        for(int copy : copys) {
            if(!rankingMap.containsKey(copy)){
                rankingMap.put(copy, rank);
                rank++;
            }
        }

        StringBuilder printSet = new StringBuilder();
        for(int Xdot : Xdots)
            printSet.append(rankingMap.get(Xdot)).append(" ");
        System.out.println(printSet);
    }
}