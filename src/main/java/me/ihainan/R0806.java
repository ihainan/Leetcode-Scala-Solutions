package me.ihainan;

import java.util.List;

class R0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) C.add(A.remove(A.size() - 1)); // n == 1 doesn't mean A.size() == 1
        else {
            move(n - 1, A, C, B); // Move n - 1 plates from A to B using C
            C.add(A.remove(A.size() - 1));   // Move nth plate to C
            move(n - 1, B, A, C); // Move n - 1 plates from B to C using A
        }
    }
}