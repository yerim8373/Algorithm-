import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;

import java.lang.*;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 이미 심어져 있는 가로수의 수
        // 둘째줄부터 N개의 줄에는 각 줄마다 심어져 있는 가로수의 위치가 양의 정수로 주어짐
        // KOI 시에서는 예산 문제로 가능한 한 가장 적은 수의 나무를 심고 싶다
        // 예를 들어, 가로수가 1,3,7,13 위치에 있으면 5,9,11 위치에 가로수를 더 심으면 모든 가로수 간격이 동일해짐

        int num = Integer.parseInt(br.readLine());
        // 가로수 위치 배열
        int[] trees = new int[num];

        // 가로수 사이 간격 배열
        int[] distance = new int[num-1];

        for(int i = 0; i<num; i++){
            int n = Integer.parseInt(br.readLine());
            trees[i] = n;
        }

        // 첫 번째 간격
        distance[0] = trees[1] - trees[0];
        // 최대공약수 선언
        int gcdNum = distance[0];
        for(int i = 1; i<num-1; i++){
            distance[i] = trees[i+1] - trees[i]; // 가로수들 간의 간격 구하기
            gcdNum = gcd(distance[i],gcdNum); // 최대공약수 메서드로 가로수 사이 간격들의 최대공약수를 저장
        }

        int cnt =0; // 필요한 최소 횟수

        for (int i = 0; i < distance.length; i++){
            if (distance[i]==gcdNum){
                continue;
            }
            else{
                cnt = cnt + distance[i]/gcdNum -1; // 최대공약수가 2인데 간격이 4라면 그 사이 하나의 나무만 있으면 된다
            }
        }

        bw.write(cnt+"");

        bw.flush();
        br.close();
        bw.close();
    }

    // 최대공약수를 구하기 위한 유클리드 호제법
    public static int gcd(int a, int b){
        // 아래 while 문에 맞게 a가 b 보다 무조건 크게 만들어주는 조건문
        if (a<b){
            int temp = a;
            a=b;
            b=temp;
        }
        // 나누는 수가 0이 될때까지
        // 몫을 다시 나누는 수로
        while (b!=0){
            int r = a%b;
            a=b;
            b=r;
        }

        return a;
    }

}