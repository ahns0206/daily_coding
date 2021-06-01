package com.algo.top50.stringandarray;

/*String, StringBuffer, StringBuilder 차이점
- String : 문자열 연산이 적고 멀티쓰레드 환경일 경우
            연산이나 concat시 새로운 객체를 생성하기에 메모리 많이 사용함
- StringBuffer : 문자열 연산이 많고 멀티쓰레드 환경이며 synchronized 해야하는 경우
- StringBuilder : 문자열 연산이 많고 단일쓰레드 환경이며 asynchronized 해도되는 경우
*/

/*문제 이해
1. 하이픈 제거
2. 대문자로 변경
3. 뒤에서 4개씩 끊어서 - 넣기*/
public class LicenseKeyFormatting_08 {

    public static void main(String[] args) {

        String S1 = "5F3Z-2e-9-w";
        String S2 = "8-5g-3-J";
        int k = 4;

        System.out.println(licenseKeyFormatting(S1, k));
        System.out.println(licenseKeyFormatting(S2, k));
    }

    public static String licenseKeyFormatting(String S, int K) {
        String s1 = S.toUpperCase();
        s1 = S.replaceAll("-", "");

        StringBuilder sb = new StringBuilder();
        for (char s : s1.toCharArray()) {
            sb.append(s); //마지막 인덱스에 추가
        }

        int sbLength = sb.length();
        for (int i = K; i < sbLength; i = i + K) {
            sb.insert(sbLength - i, "-"); //특정 인덱스에 추가
        }

        return sb.toString();
    }


    public static String licenseKeyFormatting2(String S, int K) {

        String S1 = S.replace("-", "");
        S1 = S1.toUpperCase();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S1.length(); i++) {
            sb.append(S1.charAt(i));
        }
        int len = sb.toString().length();
        for (int i = K; i < len; i = i + K) {
            sb.insert(len - i, '-');
        }
        return sb.toString();
    }
}
