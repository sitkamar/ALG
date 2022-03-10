public class FancyVrchol {
    public int info;
    public FancyVrchol sun;
    public FancyVrchol brother;
    public FancyVrchol(int info, FancyVrchol sun, FancyVrchol brother) {
        this.info = info;
        this.sun = sun;
        this.brother = brother;
    }
    public void addSun(int info) {
        this.sun = new FancyVrchol(info, null, null);
    }
    public void addBrother(int info) {
        this.brother = new FancyVrchol(info, null, null);
    }
public static void main(String[] args) {
    FancyVrchol root = new FancyVrchol(1, null, null);
    root.addSun(2);
    root.addBrother(3);
    root.sun.addBrother(4);
    root.sun.addSun(5);
    root.brother.addBrother(6);
    root.brother.addSun(7);
    root.print();
}
    public void print() {
        System.out.print(this.info);
        if(this.brother != null) {
            System.out.print("B:{");
            this.brother.print();
            System.out.print("}");
        }
        if(this.sun != null) {
            System.out.print(" S:{");
            this.sun.print();
            System.out.print("}, ");
        }
    }
}

