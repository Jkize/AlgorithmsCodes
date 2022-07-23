public class E547_Number_Of_Provinces {

    public int findCircleNum(int[][] isConnected) {

        boolean visit[] = new boolean[isConnected.length];
        int res = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visit[i]) {
                connectAll(i, visit, isConnected);
                res++;
            }
        }
        return res;
    }

    public void connectAll(int node, boolean visit[], int[][] isConnected) {

        visit[node] = true;

        for (int j = 0; j < isConnected[node].length; j++) {

            if (isConnected[node][j] == 1 && !visit[j]) {
                connectAll(j, visit, isConnected);
            }
        }
    }
}
