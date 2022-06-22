package lzf.UnionFind;

import java.util.*;

public class Code_399 {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<>();

        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }
        int[] f = new int[nvars];
        double[] w = new double[nvars];
        Arrays.fill(w, 1.0);
        for (int i = 0; i < nvars; i++) {
            f[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
            merge(f, w, va, vb, values[i]);
        }
        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                int fa = findf(f, w, ia), fb = findf(f, w, ib);
                if (fa == fb) {
                    result = w[ia] / w[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }

    public void merge(int[] f, double[] w, int x, int y, double val) {
        int fx = findf(f, w, x);
        int fy = findf(f, w, y);
        f[fx] = fy;
        w[fx] = val * w[y] / w[x];
    }

    public int findf(int[] f, double[] w, int x) {
        if (f[x] != x) {
            int father = findf(f, w, f[x]);
            w[x] = w[x] * w[f[x]];
            f[x] = father;
        }
        return f[x];
    }
    /*class UF{
        private int[] parent;
        private int[] size;
        private double[] weight;
        public UF(int n){
            parent = new int[n];
            weight = new double[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }
        public void union(int p, int q, double value){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ){
                return;
            }
            // 不是同一个根节点, 则需要合并
            parent[rootP] = rootQ;
            weight[rootP] = weight[q] * value / weight[p];
        }

        private int find(int x){
            //  路径压缩
            if(parent[x] != x){
                int temp = parent[x];
                parent[x] = find(temp);
                weight[x] *= weight[temp];
            }
            return parent[x];
        }
        public double connected(int p, int q){
            if(find(p) == find(q)){
                return weight[p] / weight[q];
            }else{
                return -1.0d;
            }
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 预处理 构造并查集
        int n = equations.size();
        HashMap<String, Integer> map = new HashMap<>(2*n);
        UF uf = new UF(2*n);
        int id = 0;
        for(int i=0; i<n; i++){
            List<String> list = equations.get(i);
            String p = list.get(0);
            String q = list.get(1);
            if(!map.containsKey(p)){
                map.put(p, id);
                id++;
            }
            if(!map.containsKey(q)){
                map.put(q, id);
                id++;
            }
            uf.union(map.get(p), map.get(q), values[i]);
        }
        // System.out.println(map);
        double[] ans = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            List<String> list = queries.get(i);
            String p = list.get(0);
            String q = list.get(1);
            if(map.get(p) == null || map.get(q) == null){
                ans[i] = -1.0d;
            }else{
                ans[i] = uf.connected(map.get(p), map.get(q));
            }
        }
        return ans;
    }*/
}
