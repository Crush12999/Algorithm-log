#include<bits/stdc++.h>

using namespace std;

#define endl '\n';
typedef long long ll;
typedef pair<ll, ll> PII;
const int N = 1e6;

/**
 * 实际上我们还是可以排序的，题目这里只修改了n的数据大小，没有修改ai的，而ai最大才1e5，
 * 这就给了我们机会，我们可以准备一个长度为1e5+1的数组v，每次以元素的值为下标，修改数组v的值，
 * 比如元素是2，那就是下标为2的位置，数值+1。举个例子，长度为5的数组v，初始是0 0 0 0 0（下标1开始） ，
 * 要排序的元素有1 4 5 2 4 3，那么经过我们操作后就变成了：1 1 1 2 1，
 * 即值为1的元素有1个，2的元素有1个……5的元素有1个。这样就排好序了，这样时间复杂度就是On了，
 * 我们只用遍历长度为n的元素，然后O1的复杂度修改数组v的值。排序好了后，我们可以准备两个队列，
 * 一个a存下我们排好序的v数组（小的先进），一个b初始为空，用来后面存下我们合并后的木板。
 * 我们每次从两个队列中总共取两个木板出来，那边的队头最小就取哪边，合并之后放在准备好的队列b里，
 * 这样可以使得两边的队列始终递增有序，一直合并到两个队列总元素为1时结束。
 */

inline int read() {
    int x = 0;
    char ch = getchar();
    while (ch < '0' || ch > '9') ch = getchar();
    while (ch >= '0' && ch <= '9') x = (x << 3) + (x << 1) + ch - '0', ch = getchar();
    return x;
}

inline void write(long long x) {
    if (x > 9) write(x / 10);
    putchar(x % 10 | '0');
}

int main() {
    ll n, x, ans = 0;
    n = read();
    queue<ll> que, mx;
    vector<ll> v(1e5 + 50);
    for (int i = 0; i < n; i++) {
        x = read();
        ans = max(ans, x);
        v[x]++;
    }
    for (int i = 1; i <= ans; i++) {
        for (int j = 0; j < v[i]; j++) {
            que.push(i);
        }
    }
    ll res = 0;
    while (que.size() + mx.size() != 1) {
        ans = 0;
        if (!mx.empty()) {
            if (que.empty()) {
                ans += mx.front();
                mx.pop();
            } else if (mx.front() < que.front()) {
                ans += mx.front();
                mx.pop();
            } else {
                ans += que.front();
                que.pop();
            }
        } else {
            ans += que.front();
            que.pop();
        }
        if (!mx.empty()) {
            if (que.empty()) {
                ans += mx.front();
                mx.pop();
            } else if (mx.front() < que.front()) {
                ans += mx.front();
                mx.pop();
            } else {
                ans += que.front();
                que.pop();
            }
        } else {
            ans += que.front();
            que.pop();
        }
        res += ans;
        mx.push(ans);
    }
    write(res);

    return 0;
}
