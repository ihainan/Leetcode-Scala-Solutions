package me.ihainan;

class P1634 {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode(0, 0);
        PolyNode p = dummy;
        PolyNode l1 = poly1;
        PolyNode l2 = poly2;
        while (l1 != null && l2 != null) {
            if (l1.power == l2.power) {
                int coefficient = l1.coefficient + l2.coefficient;
                if (coefficient != 0) {
                    p.next = new PolyNode(coefficient, l1.power);
                    p = p.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.power > l2.power) {
                int coefficient = l1.coefficient;
                if (coefficient != 0) {
                    p.next = new PolyNode(coefficient, l1.power);
                    p = p.next;
                }
                l1 = l1.next;
            } else {
                int coefficient = l2.coefficient;
                if (coefficient != 0) {
                    p.next = new PolyNode(coefficient, l2.power);
                    p = p.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null)
            p.next = l1;
        else
            p.next = l2;
        return dummy.next;
    }
}