package com.yew1eb.others;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author zhouhai
 * @createTime 16/4/5
 * @description
 */


public class BingoCard {

    private static final Random random = new Random(System.currentTimeMillis());

    private static List randomeCard(char ch, int len, int start, int end) {
        List<String> list = new ArrayList(end - start + 1);
        for (int i = start; i <= end; ++i) {
            list.add(ch + "" + i);
        }
        Collections.shuffle(list, random);
        return list.subList(0, len);
    }

    public static String[] getCard() {
        List<String> seq = new ArrayList(24);
        seq.addAll(randomeCard('B', 5, 1, 15));
        seq.addAll(randomeCard('I', 5, 16, 30));
        seq.addAll(randomeCard('N', 4, 31, 45));
        seq.addAll(randomeCard('G', 5, 46, 60));
        seq.addAll(randomeCard('O', 5, 61, 75));
        String ret[] = new String[24];
        seq.toArray(ret);
        return ret;
    }

    public static void print() {
        for (String s : getCard()) {
            System.out.print(s + ",");
        }
    }

    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static BigInteger fib(BigInteger n) {
        int sign = n.signum();
        BigInteger f0 = BigInteger.ZERO;
        BigInteger f1 = BigInteger.ONE;
        BigInteger temp = null;
        int N = n.abs().intValue();
        if (N == 0) {
            return f0;
        }
        for (int i = 0; i < N - 1; ++i) {
            temp = f1;
            f1 = f1.add(f0);
            f0 = temp;
        }
        return f1.multiply(BigInteger.valueOf(sign));
    }

    private static List<Integer> genPrime(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; ++i) {
            boolean flag = true;
            for (int j = 2; j <= i / j; ++j) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static String sumOfDivided(int[] l) {
        int limit = 0;
        for (int i = 0; i < l.length; ++i) {
            if (Math.abs(l[i]) > limit) {
                limit = Math.abs(l[i]);
            }
        }
        List<Integer> primes = genPrime(limit / 2);
        StringBuilder sb = new StringBuilder();
        for (Integer prime : primes) {
            long sum = 0;
            for (int j = 0; j < l.length; ++j) {
                if (l[j] % prime == 0) {
                    sum += l[j];
                }
            }
            if (sum > 0) sb.append("(" + String.valueOf(prime) + " " + String.valueOf(sum) + ")");
        }
        return sb.toString();
    }

    public static int LCS(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int[][] opt = new int[len1 + 1][len2 + 1];

        for (int i = len2; i >= 0; --i) {
            opt[len1][i] = len2 - i;
        }
        for (int i = len1; i >= 0; --i) {
            opt[i][len2] = len1 - i;
        }

        for(int i=len1 - 1; i>=0; --i) {
            for(int j=len2 -1; j>=0; --j) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    opt[i][j] = opt[i+1][j+1];
                } else {
                    opt[i][j] = opt[i+1][j+1] + 1;
                    opt[i][j] = Math.min(opt[i][j], opt[i][j+1]+1);
                    opt[i][j] = Math.min(opt[i][j], opt[i+1][j]+1);
                }
            }
        }
        return opt[0][0];
    }

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/yew1eb/Downloads/61244.jpg");
        BufferedImage bi = ImageIO.read(file);
        int pixel = bi.getRGB(0, 0);
        int r = (pixel & 0xff0000) >> 16;// red
        int g = (pixel & 0xff00) >> 8;// green
        int b = (pixel & 0xff); // blue
        System.out.println("r is :" + r +"\n"+
                "g is :" + g +"\n"
                        +"b is :" + b +"\n" );

    }

}
