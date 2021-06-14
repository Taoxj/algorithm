package com.xjt.algorithm;

/**
 * 比较版本号
 * 
 * @author kevin
 * @date 2021/4/15
 */
public class CompareVersion {

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));
    }

    public static int compareVersion(String version1, String version2) {
        int s1 = version1.length();
        int s2 = version2.length();

        int i = 0;
        int j = 0;
        while (i < s1 || j < s2) {
            // 用v1,v2来计算每一个块中版本号的大小
            int v1 = 0;
            int v2 = 0;
            while (i < s1 && version1.charAt(i) != '.') {
                v1 = v1 * 10 + Integer.parseInt(version1.charAt(i) + "");
                i++;
            }
            while (j < s2 && version2.charAt(j) != '.') {
                v2 = v2 * 10 + Integer.parseInt(version2.charAt(j) + "");
                j++;
            }
            // 判断当前块中的版本号是否一致
            if (v1 != v2) {
                if (v1 > v2) {
                    return 1;
                }
                return -1;
            }
            // 跳过分隔符
            i++;
            j++;
        }
        return 0;

    }
}
