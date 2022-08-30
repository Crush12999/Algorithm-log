//
// http://oj.daimayuan.top/course/7/problem/493
//
#include <bits/stdc++.h>
using namespace std;

struct Info {
    int v, delta;
} heap[20010];
int n, m, len;

inline void up(int k) {
    while (k > 1 && heap[k].v < heap[k / 2].v) {
        swap(heap[k], heap[k / 2]);
        k /= 2;
    }
}

inline void down(int k) {
    while (k + k <= len) {
        int j = k + k;
        if (j + 1 <= len && heap[j + 1].v < heap[j].v) j++;
        if (heap[k].v <= heap[j].v) break;
        swap(heap[k], heap[j]);
        k = j;
    }
}

int main() {
    scanf("%d", &n);
    len = 0;
    for (int i = 1; i <= n; i++) {
        int k, b;
        scanf("%d%d", &k, &b);
        heap[++len].v = b;
        heap[len].delta = k;
        up(len);
    }
    scanf("%d", &m);
    for (int i = 1; i <= m; i++) {
        printf("%d ", heap[1].v);
        heap[1].v += heap[1].delta;
        down(1);
    }
}