package unionfindset;

/*
    并查集定义
 */

public class UnionFS {
    int[] parent;
    int[] size; // 门派规模
    // int count; // 门派个数 不一定派上用场
    public UnionFS(int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 重要
    public int findParent(int x) {
        while (x != parent[x]) {
            x = parent[parent[x]];
        }
        return x;
    }

    public boolean isConnected(int x, int y) {
        return findParent(x) == findParent(y);
    }

    public void unionP(int x, int y) {
        int xP = findParent(x);
        int yP = findParent(y);
        if (xP != yP) {
            parent[yP] = xP;
            size[xP] += size[yP];
        }
    }
}
