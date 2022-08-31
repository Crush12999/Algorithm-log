//
// http://oj.daimayuan.top/course/7/problem/494
//

#include <bits/stdc++.h>

using namespace std;

// 小根堆
struct Info {
    int v, pos;
} heap1[100001], heap2[100001];

// s1[i]表示第i个人对应了小根堆里下标为s1[i]的点，
// 也就是说小根堆里下标为s1[i]的点记录了第i个人的信息
int len1, s1[100001], s2[100001], len2;

int n, m;

inline void up1(int k) {
    while (k > 1 && heap1[k].v < heap1[k / 2].v) {
        swap(heap1[k], heap1[k / 2]);
        s1[heap1[k].pos] = k;
        s1[heap1[k / 2].pos] = k / 2;
        k /= 2;
    }
}

inline void down1(int k) {
    while (k + k <= len1) {
        int j = k + k;
        if (j + 1 <= len1 && heap1[j + 1].v < heap1[j].v) j++;
        if (heap1[k].v <= heap1[j].v) break;
        swap(heap1[k], heap1[j]);
        s1[heap1[k].pos] = k;
        s1[heap1[j].pos] = j;
        k = j;
    }
}

inline void up2(int k) {
    while (k > 1 && heap2[k].v > heap2[k / 2].v) {
        swap(heap2[k], heap2[k / 2]);
        s2[heap2[k].pos] = k;
        s2[heap2[k / 2].pos] = k / 2;
        k /= 2;
    }
}

inline void down2(int k) {
    while (k + k <= len2) {
        int j = k + k;
        if (j + 1 <= len2 && heap2[j + 1].v > heap2[j].v) j++;
        if (heap2[k].v >= heap2[j].v) break;
        swap(heap2[k], heap2[j]);
        s2[heap2[k].pos] = k;
        s2[heap2[j].pos] = j;
        k = j;
    }
}

int main() {
    scanf("%d", &n);
    len1 = len2 = 0;
    for (int i = 1; i <= n; i++) {
        heap1[++len1].v = 100;
        heap1[len1].pos = i;
        s1[i] = len1;
        up1(len1);
        heap2[++len2].v = 100;
        heap2[len2].pos = i;
        s2[i] = len2;
        up2(len2);
    }
    scanf("%d", &m);
    for (int i = 1; i <= m; i++) {
        int x;
        scanf("%d", &x);
        if (x == 1) {
            int y, z;
            scanf("%d%d", &y, &z);
            heap1[s1[y]].v += z;
            up1(s1[y]);
            down1(s1[y]);
            heap2[s2[y]].v += z;
            up2(s2[y]);
            down2(s2[y]);
        } else {
            printf("%d %d\n", heap2[1].v, heap1[1].v);
        }
    }
}