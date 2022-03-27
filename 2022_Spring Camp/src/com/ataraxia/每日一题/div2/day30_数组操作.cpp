#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

/**
 * 可能题目看着有点懵，其实就是每次可以把后面一个区间的数，
 * 赋值给后面相距k个位置的区间，然后我们要把整个数组改成一样的。
 * 首先我们就可以知道了，要想数组一样，只能是改成全部和最后一个数一样，
 * 因为只能通过后面的数来修改前面的数，所以要想数组一样只能是吧整个数组改成最后一个的样子。
 * 我们就从后面开始遍历，记录所有和最后一个数相同的个数，记作ans，
 * 在此过程种，一旦遇到和最后一个不一样的，我们就直接把这个数改成一样的，
 * 修改次数++，但一个个修改太麻烦了，
 * 我们可以直接把后面的ans个相同的数赋给前面的ans个数，
 * 这样整个数组就有ans*2个位置都是相同的数了
 * （也不用管赋值前的数是什么样，如果是和最后一样也没影响，如果不一样那就正好改成一样的）。
 * 最后输出修改次数就行。
 */

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> v(n);
        for (int i = n - 1; i >= 0; i--) {
            cin >> v[i];
        }
        int num = v[0], res = 0, ans = 1;
        while (ans < n) {
            if (v[ans] == num)ans++;
            else {
                res++;
                ans *= 2;
            }
        }
        cout << res << "\n";
    }
    return 0;
}
