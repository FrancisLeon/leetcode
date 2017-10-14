/**
 * Since we know in the search there will be some duplicate,
 * thus, we implement the dp to swap the time with the space.
 */
class lc96 {
    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) { // compute the G[n], 1, 2, 3 G[0]*G[2]
            System.out.println("" + "G[" + i + "]: " + G[i]);
            for (int j = 1; j <= i; j++) { // G[n] = F[1, n] + F[2, n] + F[3, n] + ... + F[n, n]
                System.out.println("iterate: " + j);
                G[i] = G[i] + G[j - 1] * G[i - j];
            } 
            System.out.println("after: G[" + i + "]: " + G[i]);            
        }

        return G[n];
    }

    public static void main(String[] args) {
        int res = numTrees(4);
        System.out.println(res);
    }
}