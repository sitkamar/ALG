public class Uzel {
    int info;
    Uzel next;

    public Uzel(int info, Uzel next) {
        this.next = next;
        this.info = info;
    }

    public static void main(String[] args) {
        Uzel q = new Uzel(1, null);
        q.addLast(3);
        q.addLast(2);
        q.addLast(5);
        q.addLast(4);
        q.printList();
        q.miss();
        q.printList();
    }

    public void printList() {
        Uzel q = this;
        System.out.print(q.info + " ");
        q = q.next;
        while (q != null) {
            System.out.print(q.info+" ");
            q = q.next;
        }
        System.out.println();
    }

    public void addLast(int info) {
        Uzel q = this;
        while (q.next != null) {
            q = q.next;
        }
        q.next = new Uzel(info, null);
    }

    public void addFirst(int info) {
        Uzel q = this;
        this.info = info;
        this.next = q;
    }

    public void removeLast() {
        Uzel q = this;
        while (q.next.next != null) {
            q = q.next;
        }
        q.next = null;
    }

    public Uzel revert() {
        Uzel q = this;
        Uzel r = null;
        while (q != null) {
            Uzel p = q.next;
            q.next = r;
            r = q;
            q = p;
        }
        return r;
    }
    public Uzel selectSort() {
        Uzel q = this;
        Uzel r = null;
        while (q != null) {
            Uzel p = q.next;
            Uzel min = q;
            while (p != null) {
                if (p.info < min.info) {
                    min = p;
                }
                p = p.next;
            }
            q.next = min.next;
            min.next = r;
            r = min;
            q = q.next;
        }
        return r.next;
    }
    public Uzel[] split() {
        Uzel q = this;
        Uzel l = new Uzel(-1,null);
        Uzel s = new Uzel(-1,null);
        Uzel kl = l;
        Uzel ks = s;
        while (q != null) {
            Uzel p = q;
            q = q.next;
            if (p.info % 2 == 0) {
                ks.next = p;
                ks = ks.next;
            } else {
                kl.next = p;
                kl = kl.next;
            }
        }
        ks.next = null;
        kl.next = null;
        return new Uzel[]{l.next, s.next};
    }
    public Uzel bubbleSort() {
        Uzel q = this;
        Uzel r = null;
        while (q != null) {
            Uzel p = q.next;
            Uzel min = q;
            while (p != null) {
                if (p.info < min.info) {
                    min = p;
                }
                p = p.next;
            }
            q.next = min.next;
            min.next = r;
            r = min;
            q = q.next;
        }
        return r;
    }
    public void miss(){
        Uzel q = this;
        try{
        while(q.next.next != null){
            q.next = q.next.next;
            q = q.next;
        }
    }catch(Exception e){
        return;
    }
    q.next = null;
    }
    public void insertSort() {
        Uzel q = this;
        Uzel r = null;
        while (q != null) {
            Uzel p = q.next;
            Uzel min = q;
            while (p != null) {
                if (p.info < min.info) {
                    min = p;
                }
                p = p.next;
            }
            q.next = min.next;
            min.next = r;
            r = min;
            q = q.next;
        }
        this.next = r;
    }
    public Uzel skipAll(int x){
        Uzel p = this;
        while(p!=null && p.info==x){
            p = p.next;
        }
        Uzel q = p;
        while(q!=null && q.next!=null){
            if(q.next.info==x){
                q.next = q.next.next;
            }
            q = q.next;
        }
        return p;
    }
}