#include <bits/stdc++.h>
typedef long long ll;
using namespace std;
#define endl '\n';


/**
 * 求a,b两个数的因子，如果这两个数的因子有相同的（该因子要大于1），
 * 那么就说明他们两个的乘积是某个大于1的整数的平方的倍数。
 * 为什么呢？首先我们应该知道，两个数相乘，那他们的因子也当是相乘起来的，
 * 比如12*8，12的因子有3 4（2 6也可以），8的因子是2 4，8 *12就等于3 *4 *2 *4=96，
 * 然后我们在这里看到了什么，两个4相乘了，两个相同的因子相乘自然得到的就是这个因子的平方数了，
 * 这样其它的因子相乘就相当于我们的乘积（96）到平方数（16）的倍数（3 *2）。
 * 所以我们要知道两个数相乘是不是某个平方数的倍数，
 * 不用真的把他们相乘然后枚举平方数来看这个平方数是不是他们的因子，
 * 而且在这里a和b最多能取到1e12，那他们相乘是1e24，相当于我们要枚举到1e12，
 * 想想就麻烦。所以我们直接分解a，b并看他们的因子是否有相同的即可：
 * 如果有因子相等，那就输出no credit。
 * 如果没有因子相等，就输出partial credit。
 * 如果没有因子说明他俩是质数，我们再判断一下a和b是否相等：
 * 不相等就输出full credit
 * 相等就输出partial credit
 * 但还有种特殊情况，就是a和b可能已经有一方是一个平方数了，
 * 所以我们一开始要先判断一下a和b有没有哪个是平方数，如果有就直接输出no credit即可。
 */

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    ll a, b;
    cin >> a >> b;
    ll num1 = sqrt(a), num2 = sqrt(b);
    if (a == b || a % b == 0 || b % a == 0 || num1 * num1 == a || num2 * num2 == b) {
        cout << "no credit" << endl;
        return 0;
    }
    unordered_map<ll, int> mymap;
    bool flag = true;
    for (ll i = 2; i * i < max(a, b); i++) {
        if (i * i <= a && a % i == 0) {
            if (mymap[i] != 0 || mymap[a / i] != 0) {
                cout << "no credit" << endl;
                return 0;
            }
            flag = false;
            mymap[i] = 1;
            mymap[a / i] = 1;
        }
        if (i * i <= b && b % i == 0) {
            if (mymap[i] != 0 || mymap[b / i] != 0) {
                cout << "no credit" << endl;
                return 0;
            }
            flag = false;
            mymap[i] = 1;
            mymap[b / i] = 1;
        }
    }
    if (flag) {
        cout << "full credit" << endl;
    } else
        cout << "partial credit" << endl;
    return 0;
}
