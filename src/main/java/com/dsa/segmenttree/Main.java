package com.dsa.segmenttree;


public class Main {
    static void main(String[] args) {
        int[] arr = {2, 1, 0, 4, 3, 7};
        SegmentTree segmentTree = new SegmentTree(arr);
        System.out.println(segmentTree.query(0, 3));
        System.out.println(segmentTree.query(3, 5));
    }
}
