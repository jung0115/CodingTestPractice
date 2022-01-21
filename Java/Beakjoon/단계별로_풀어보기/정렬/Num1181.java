//백준 > 단계별로 풀어보기 > 브루트 포스 > 단어 정렬(1181)
package Java.Beakjoon.단계별로_풀어보기.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class Num1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] words = new String[N];
        for(int i = 0; i < N; i++) {
            words[i] = bf.readLine();
        }

        //람다식(익명함수) 이용
        Arrays.sort(words, (word1, word2) -> {
            int len1, len2;
            len1 = word1.length();
            len2 = word2.length();
            if(len1 == len2) //단어의 길이가 같은 경우 사전순으로
                return checkDic(word1, word2, len1);
            else //다른 경우 단어의 길이가 짧은 순으로
                return len1 - len2;
        });

        StringBuilder printSet = new StringBuilder();
        String checkSame = "";
        for(int i = 0; i < N; i++) {
            if(!words[i].equals(checkSame))
                printSet.append(words[i]).append("\n");
            checkSame = words[i];
        }
        System.out.println(printSet);
    }
    static int checkDic(String word1, String word2, int len) {
        char[] word1Char, word2Char;
        word1Char = word1.toCharArray();
        word2Char = word2.toCharArray();
        for(int i = 0; i < len; i++) {
            if(word1Char[i] < word2Char[i]) return -1;
            else if(word1Char[i] > word2Char[i]) return 1;
        }
        return -1;
    }
}
