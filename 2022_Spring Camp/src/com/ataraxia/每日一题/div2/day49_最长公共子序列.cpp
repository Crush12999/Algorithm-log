#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

/**
 * 大火可能都写过二维dp求最长公共子序列，它的时间复杂度是n^2。但在这里数据被提到了1e5，
 * 先不说超不超时，我们也开不了1e5*1e5的二维数组。那么这题该怎么做？
 * 有没有什么方法可以不用二维数组，还能把复杂度降到nlogn（或者更低？）。
 * 首先，有两点，一是这里给的两个数组，都是自然数1、2、3……n的排列，只是两个数组中的位置不一样罢了。
 * 二是我们要考虑一下公共子序列的意思，公共序列换个说法就是，
 * 一个序列在两个数组中的相对位置都是一样的。比如样例这里，2都是在1后面，4在2后面，5在2后面。
 * 所以它们的最长公共序列就是2145，长度为4。然后更直观点来说，
 * 如果我们把一个数组的元素的按照另一个数组的出现位置做一个数组，
 * 那么最长公共子序列就是这个数组的最长上升子序列。
 * 样例举例来说，第二个数组b:21345，元素2在第一个数组a里的下标为1，1的下标是2，……5的下标是4，
 * 这样我们就可以得到一个数组：1 2 0 3 4，
 * 然后第一个数组下标为1 2 3 4的元素就是第二个数组的最长公共子序列，
 * 因为它们的出现顺序是一样的（在a中是上升序列，b中也是）
 * 那么现在问题就从求最长公共子序列变成了就最长上升子序列了。
 * 很幸运的是我们恰好知道最长上升子序列的nlogn的写法。
 */

const int N = 100010;
int a[N], b[N], dp[N];
unordered_map<int, int> mp;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        mp[a[i]] = i;
    }
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        b[i] = mp[x];
    }
    int len = 1;
    dp[0] = 0xc0c0c0c0;
    for (int i = 0; i < n; i++) {
        int l = 0, r = len;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (dp[mid] < b[i]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        len = max(len, r + 1);
        dp[r + 1] = b[i];
    }
    cout << len - 1 << "\n";
    return 0;
}
