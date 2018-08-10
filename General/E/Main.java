import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static boolean DEBUG = false;
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]), k = Integer.parseInt(br.readLine());
        Map<String, Node> map1 = new HashMap<>();
        Map<String, Node> map2 = new HashMap<>();
        for(int i = 0; i < k; i++) {
            ss = br.readLine().split(" ");
            int x = Integer.parseInt(ss[0]), y = Integer.parseInt(ss[1]);
            Node node = new Node(x, y);

            String[] par = {
                    new StringBuilder().append(x-1).append(' ').append(y).toString(),
                    new StringBuilder().append(x).append(' ').append(y-1).toString(),
                    new StringBuilder().append(x-1).append(' ').append(y-1).toString(),
                    new StringBuilder().append(x+1).append(' ').append(y-1).toString()
            };
            String[] chd = {
                    new StringBuilder().append(x+1).append(' ').append(y).toString(),
                    new StringBuilder().append(x).append(' ').append(y+1).toString(),
                    new StringBuilder().append(x+1).append(' ').append(y+1).toString(),
                    new StringBuilder().append(x-1).append(' ').append(y+1).toString()
            };

            for(int idx = 0; idx < 4; idx++) {
                Node parent = (i%2==0 ? map1: map2).get(par[idx]);
                if(parent != null) {
                    parent.unite(node, idx);
                    if(parent.root(idx).getSize(idx) >= n) {
                        System.out.println((i%2 == 0 ? "UNI " : "RITA ") + (i+1));
                        if(DEBUG) System.out.println(System.currentTimeMillis() - start);
                        return;
                    }
                }
                Node child = (i%2==0 ? map1 : map2).get(chd[idx]);
                if(child != null) {
                    node.unite(child, idx);
                    if(node.root(idx).getSize(idx) >= n) {
                        System.out.println((i%2 == 0 ? "UNI " : "RITA ") + (i+1));
                        if(DEBUG) System.out.println(System.currentTimeMillis() - start);
                        return;
                    }
                }
            }
            (i%2==0 ? map1 : map2).put(node.toString(), node);
        }
        System.out.println("DRAW");
    }
}

class Node {
    private int x;
    private int y;
    private int[] size = {1, 1, 1, 1};
    Node[] parents = {null, null, null, null};

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.parents[0] = this; // row
        this.parents[1] = this; // col
        this.parents[2] = this; // cross_l
        this.parents[3] = this; // cross_r
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getSize(int d) { return this.size[d]; }

    public void setParent(int d, Node node) {
        this.parents[d] = node;
    }

    public void addSize(int d, int size) {
        this.size[d] += size;
    }

    public boolean equals(Node node) {
        return this.x == node.getX() && this.y == node.getY();
    }

    public String toString() {
        return new StringBuilder().append(this.x).append(' ').append(this.y).toString();
    }

    public Node root(int d) {
        if(equals(this.parents[d])){
            return this;
        }
        return parents[d] = parents[d].root(d);
    }

    public void unite(Node node, int d) {
        Node n1 = this.root(d);
        Node n2 = node.root(d);
        if(n1.equals(n2)) {
            return;
        }
        node.setParent(d, n1);
        n2.setParent(d, n1);
        n1.addSize(d, n2.getSize(d));
        // System.out.printf("Join node: %s(%d), root -> %s(%d)\n", node, node.getSize(d), n1.toString(), n1.getSize(d));
    }
}