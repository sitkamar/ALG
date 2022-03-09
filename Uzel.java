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
        q.addLast(6);
        q.split()[1].printList();
        q.selectSort().printList();
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
}