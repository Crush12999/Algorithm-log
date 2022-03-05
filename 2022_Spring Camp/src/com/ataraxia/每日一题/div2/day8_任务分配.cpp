#include <bits/stdc++.h>

using namespace std;

struct Activity {
    // weight、start、finish
    int w, s, f;
    bool operator < (const Activity &a) const {
        return f < a.f;
    }
};

int binary(Activity* a, int l, int r, int s) {
    int mid = 0;
    while (l <= r) {
        mid = (l + r) >> 1;
        if (a[mid].f > s) {
            r = mid - 1;
        } else if (a[mid].f < s) {
            l = mid + 1;
        } else {
            while (mid < r && a[mid+1].f == s) {
                mid++;
            }
            return mid;
        }
    }
    return r;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    Activity* as = new Activity[n + 1];
    Activity a;
    a.s = a.f = a.w = 0;
    as[0] = a;
    for (int i = 1; i < n + 1; i++) {
        cin >> a.s >> a.f >> a.w;
        as[i] = a;
    }
    sort(as, as + n + 1);

    // dp[i] 代表了到活动i为止最大的权值组合，设置一个0的边界
    int* dp = new int[n + 1];
    dp[0] = 0;
    for (int i = 1; i < n + 1; i++) {
        // 如果当前活动与上一个活动兼容，则可以选择当前活动
        if (as[i].s >= as[i-1].f) {
            dp[i] = dp[i-1] + as[i].w;
        } else {
            // 如果不兼容，则比较
            // 1、当前活动的权值与到上一个与当前活动兼容的活动为止的最大权值的和
            // 2、到上一个活动为止的最大权值
            // 这么做是为了决定是否选择当前活动
            dp[i] = max(as[i].w + dp[binary(as, 0, i, as[i].s)], dp[i - 1]);
        }
    }

    cout << dp[n] << endl;
    delete []as;

    return 0;
}
