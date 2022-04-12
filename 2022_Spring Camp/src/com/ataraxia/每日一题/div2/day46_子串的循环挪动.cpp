#include <bits/stdc++.h>
using namespace std;
/**
 * 每次进行移动，字符串会被分成三部分：s的头部，需要挪动的子串s2，s的尾部。
 * 然后我们知道，挪动k次，就相当于把长度为k的字符串从尾部挪去头部，
 * 所以我们也可以把需要挪动的子串分成两部分，长度为k的s2尾部子串（将要挪去前面的那部分），
 * 和将要从前面移动到后面的s2的头部子串，所以我们整体可以把字符串分成三部分：
 * s的头部s1，需要挪动的子串的头部s2，需要挪动的子串的尾部s3，s的尾部s4
 * 此时s还是s1+s2+s3+s4。经过挪动后就变成了s1+s3+s2+s4（因为s3要挪到s2的前面）。
 * 那我们就分别获取这四段字符串，再拼接起来即可。
 */

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    string str;
    cin >> str;
    int m, n = str.size();
    cin >> m;
    while (m--) {
        int l, r, k;
        cin >> l >> r >> k;
        int mod = (r - l + 1);
        string s1 = str.substr(0, l-1);
        string s2 = str.substr(l - 1, r - l - (k % mod) + 1);
        string s3 = str.substr(r-k%mod, k%mod);
        string s4 = str.substr(r, n - r + 1);
        if(l!=r) str = s1 + s3 + s2 + s4;
    }
    cout << str << endl;
    return 0;
}
