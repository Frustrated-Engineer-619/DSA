package com.dsa.tree;

public class SegmentTree {
    private final int[] segment;
    private final int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        segment = new int[4 * n + 1];
        build(arr, 0, 0, n - 1);
    }

    public void build(int[] arr, int ind, int low, int high) {
        if (low == high) {
            segment[ind] = arr[low];
            return;
        }
        int mid = low + (high - low) / 2;
        build(arr, 2 * ind + 1, low, mid);
        build(arr, 2 * ind + 2, mid + 1, high);
        segment[ind] = Math.min(segment[2 * ind + 1], segment[2 * ind + 2]);
    }

    public int query(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    public void update(int ind, int val) {
        update(0, 0, n - 1, ind, val);
    }

    public void update(int ind, int low, int high, int index, int val) {
        if (low == high) {
            segment[ind] = val;
            return;
        }
        int mid = (low + high) / 2;
        if (index <= mid) {
            update(2 * ind + 1, low, mid, index, val);
        } else {
            update(2 * ind + 2, mid + 1, high, index, val);
        }
        segment[ind] = Math.min(segment[2 * ind + 1], segment[2 * ind + 2]);
    }

    public int query(int ind, int low, int high, int l, int r) {
        //No Overlap  [lr][low,high][lr]
        if (r < low || high < l) {
            return Integer.MAX_VALUE;
        }
        //Complete Overlap [l low high r]
        if (l <= low && r >= high) {
            return segment[ind];
        }
        //Partial Overlap
        int mid = low + (high - low) / 2;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);
        return Math.min(left, right);
    }

    public int[] getSegment() {
        return segment;
    }
}
