class Solution {
    static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    static boolean union(int[] parent, int[] rank, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);
        if (pu == pv)
            return false;
        if (rank[pu] < rank[pv]) {
            int t = pu;
            pu = pv;
            pv = t;
        }
        parent[pv] = pu;
        if (rank[pu] == rank[pv])
            rank[pu]++;
        return true;
    }

    static int spanningTree(int V, int[][] edges) {
        java.util.Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;
        int mstWeight = 0, edgesUsed = 0;
        for (int[] edge : edges) {
            if (union(parent, rank, edge[0], edge[1])) {
                mstWeight += edge[2];
                if (++edgesUsed == V - 1)
                    break;
            }
        }
        return mstWeight;
    }
}