#include <bits/stdc++.h>

#define endl '\n';
typedef long long ll;
using namespace std;

/**
 * 但意思就是说，字符串s的所有子串翻过来之后（abc变cba）能在s里找到一样的字符串，
 * 这个s可以是向右移动k次之后的样子
 * （向右移动k次相当于把前面k个字符移动到末尾，比如abcde移动2次，那就变成cdeab）。
 * 那么我们只要枚举所有可能的子串，然后在旋转后的字符串s里找看是不是都能找到即可，
 * 如果都能找到那就输出yes，一个找不到都要输出no。
 * 可是每次都要移动字符串s太麻烦了，所以我们要对字符串做点改变。
 * 就像我们前面说的，移动k次是把前k个字符删除移动到末尾，
 * 那么最多移动len（字符串长度）次，字符串就会变回原样，
 * 那我们直接把一个相同的字符串s接到s后面即可，
 * 这样就可以在这个字符串里找到所有可能移动过后的字符串s，我们就在这里面找子串。
 */
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        int n;
        string s;
        cin >> n >> s;
        bool flag = true;
        string str = s + s;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                string res = s.substr(i, len);
                reverse(res.begin(), res.end());
                if (str.find(res) == str.npos) {
                    cout << "NO" << endl;
                    flag = false;
                    break;
                }
            }
            if (!flag)break;
        }
        if (flag)cout << "YES" << endl;
    }
    return 0;
}
