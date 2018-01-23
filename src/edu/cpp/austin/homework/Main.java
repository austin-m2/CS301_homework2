package edu.cpp.austin.homework;

public class Main {

    public static void main(String[] args) {
	// write your code here
        exercise_2_1_1();
    }

    private static void exercise_2_1_1() {
        test_nge();
    }

    private static void naive_gauss(int n, float[][] a, float[] b, float[] x) {
        float sum, xmult;


        for (int k = 0; k < n - 1; k++) {

            for (int i = k + 1; i < n; i++) {
                xmult = a[i][k] / a[k][k];
                a[i][k] = xmult;

                for (int j = k + 1; j < n; j++) {
                    a[i][j] = a[i][j] - xmult * a[k][j];
                }
                b[i] = b[i] - xmult * b[k];
            }

        }

        x[n-1] = b[n-1] / a[n-1][n-1];

        for (int i = n - 1; i > 0; i--) {
            sum = b[i];
            for (int j = i + 1; j < n; j++) {
                sum = sum - a[i][j] * x[j];
            }
            x[i] = sum / a[i][i];
        }

    }

    private static void test_nge() {
        int m = 10;
        int i, j, n;
        float[][] a = new float[m][m];
        float[] b = new float[m];
        float[] x = new float[m];

        for (n = 4; n < 10; n++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    a[i][j] = (float) Math.pow(i + 2, j);
                }
                b[i] = ((float) Math.pow(i + 2, n + 1) - 2) / (i + 1);
            }
            System.out.println("naive gauss " + n);
            naive_gauss(n,a,b,x);
            System.out.println(n);
            for (int q = 0; q < n; q++) {
                System.out.print(x[q] + " ");
            }
            System.out.println();
        }
    }


}
