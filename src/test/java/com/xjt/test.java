package com.xjt;

public class test {

    public static void main(String[] args) {
        int index = 0;
        for (int i = 1; i < 43; i++) {
            index = i;
        }
//        System.out.println(index);

        System.out.println(GetUglyNumber_Solution(4));
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        if (index == 1)
            return 1;
        int t2 = 0, t3 = 0, t5 = 0;
        int[] res = new int[index];
        res[0] = 1;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2) t2++;
            if (res[i] == res[t3] * 3) t3++;
            if (res[i] == res[t5] * 5) t5++;
        }
        return res[index - 1];
    }
}
