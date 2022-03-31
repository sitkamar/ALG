import java.util.Stack;

public class Vrchol {
    public int info;
    public Vrchol left;
    public Vrchol right;
    public Vrchol(int info, Vrchol left, Vrchol right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
    public void addLeft(int info) {
        this.left = new Vrchol(info, null, null);
    }
    public void addRight(int info) {
        this.right = new Vrchol(info, null, null);
    }
    public void print(){
        System.out.print(this.info);
        if(this.left != null) {
            System.out.print("L:{");
            this.left.print();
            System.out.print("}, ");
        }
        if(this.right != null) {
            System.out.print("R:{");
            this.right.print();
            System.out.print("}");
        }
    }
    public void print2(){
        Stack<Vrchol> zas = new Stack<Vrchol>();
        zas.push(this);
        while(!zas.isEmpty()){
            Vrchol q = zas.pop();
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
    
    public static void main(String[] args) {
        Vrchol root = new Vrchol(1, null, null);
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
