#include <bits/stdc++.h>

#define endl '\n';
using namespace std;


/**
 * next_permutation() 会生成一个序列的重排列，它
 * 是所有可能的字典序中的下一个排列，默认使用 < 运算符来做这些事情。
 * 它的参数为定义序列的迭代器和一个返回布尔值的函数，
 * 这个函数在下一个排列大于上一个排列时返回 true，
 * 如果上一个排列是序列中最大的，它返回 false，所以会生成字典序最小的排列。
 */

const int N = 1e6 + 50;

int f[10];


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, x = 1;
    cin >> n;
    vector<int> ans;
    for (int i = 1; i <= n; i++) {
        cin >> f[i];
        for (int j = 0; j < f[i]; j++) {
            ans.push_back(x);
        }
        x++;
    }
    do {
        copy(begin(ans), end(ans), ostream_iterator<int>{cout, " "});
        cout << endl;
    } while (next_permutation(begin(ans), end(ans)));
    return 0;
}
