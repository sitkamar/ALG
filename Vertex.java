import java.util.ArrayList;
import java.util.Stack;

public class Vertex {
    public int info;
    public Vertex left;
    public Vertex right;
    public Vertex(int info, Vertex left, Vertex right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
    public void addLeft(int info) {
        this.left = new Vertex(info, null, null);
    }
    public void addRight(int info) {
        this.right = new Vertex(info, null, null);
    }
    public void print(){
        System.out.print(this.info+ " :{");
        if(this.left != null) {
            System.out.print("L:{");
            this.left.print();
            System.out.print("}, ");
        }
        if(this.right != null) {
            System.out.print("R:{");
            this.right.print();
            System.out.print("}}");
        }
    }
    public void print2(){
        Stack<Vertex> zas = new Stack<Vertex>();
        zas.push(this);
        while(!zas.isEmpty()){
            Vertex q = zas.pop();
            System.out.print(q.info + " ");
            if(q.right != null) zas.push(q.right);
            if(q.left != null) zas.push(q.left);
        }
    }
    public int max(){
        int max = this.info;
        if(this.left != null) max = Math.max(max, this.left.max());
        if(this.right != null) max = Math.max(max, this.right.max());
        return max;
    }
    public int min(){
        int min = this.info;
        if(this.left != null) min = Math.min(min, this.left.min());
        if(this.right != null) min = Math.min(min, this.right.min());
        return min;
    }
    public int lenght(){
        int lenght = 1;
        if(this.left != null) lenght += this.left.lenght();
        if(this.right != null) lenght += this.right.lenght();
        return lenght;
    }
    public int countLeafs(){
        int count = 0;
        if(this.left == null && this.right == null) count++;
        if(this.left != null) count += this.left.countLeafs();
        if(this.right != null) count += this.right.countLeafs();
        return count;
    }
    public static int countLeafs(Vertex v){
        if(v == null) return 0;
        if(v.left == null && v.right == null) return 1;
        return countLeafs(v.left) + countLeafs(v.right);
    }
    public int countInHeight(int h){
        if(h == 0) return 1;
        int count = 0;
        if(this.left != null) count+= this.left.countInHeight(h-1);
        if(this.right != null) count+= this.right.countInHeight(h-1);
        return count;
    }
    public static int countInHeight(Vertex v, int h){
        if(v == null) return 0;
        if(h == 0) return 1;
        return countInHeight(v.left, h-1) + countInHeight(v.right, h-1);
    }
    public static int countOnLastHeight(Vertex v, int h){
        ArrayList<Vertex> zas = new ArrayList<Vertex>();
        zas.add(v);
        ArrayList<Vertex> newZas = new ArrayList<Vertex>();
        while(h > 0 && zas.size() > 0){
            newZas.clear();
                for(Vertex q : zas){
                    if(q.left != null) newZas.add(q.left);
                    if(q.right != null) newZas.add(q.right);
                }
            zas = newZas;
        }
        return newZas.size();
    }
    public static int largestHeight(Vertex v, int h){
        ArrayList<Vertex> zas = new ArrayList<Vertex>();
        zas.add(v);
        ArrayList<Vertex> newZas = new ArrayList<Vertex>();
        int max = 1;
        while(h > 0 && zas.size() > 0){
            newZas.clear();
                for(Vertex q : zas){
                    if(q.left != null) newZas.add(q.left);
                    if(q.right != null) newZas.add(q.right);
                }
            if(newZas.size() > max) max = newZas.size();
            zas = newZas;
        }
        return max;
    }
    public int height(){
        int h = 0;
        if(this.left != null) h = Math.max(h, this.left.height()+1);
        if(this.right != null) h = Math.max(h, this.right.height()+1);
        return h;
    }
    public boolean isSymetric(){
        return isSymetric(this.left, this.right);
    }
    private static boolean isSymetric(Vertex v1, Vertex v2){
        if(v1 == null && v2 == null) return true;
        if(v1 == null || v2 == null) return false;
        return isSymetric(v1.left, v2.right) && isSymetric(v1.right, v2.left);
    }
    public boolean isFull(){
        return isFull(this.left) && isFull(this.right);
    }
    private static boolean isFull(Vertex v){
        if(v == null) return true;
        if(v.left == null || v.right == null) return false;
        return isFull(v.left) && isFull(v.right);
    }
    public static int maxLeafHeight(Vertex v){
        if(v == null) return -1;
        if(v.left == null && v.right == null) return 0;
        if(v.left != null && v.right != null) return 1 + Math.max(maxLeafHeight(v.left), maxLeafHeight(v.right));
        if(v.left != null) return 1 + maxLeafHeight(v.left);
        return 1 + maxLeafHeight(v.right);
    }
    public static void main(String[] args) {
        Vertex root = new Vertex(1, null, null);
        root.addLeft(2);
        root.addRight(3);
        root.left.addLeft(4);
        root.left.addRight(5);
        root.right.addLeft(6);
        root.right.addRight(7);
        root.print();
        System.out.println(root.max());
    }
}
