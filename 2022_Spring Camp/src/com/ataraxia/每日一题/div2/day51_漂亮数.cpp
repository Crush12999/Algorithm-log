#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
using namespace std;

/**
 * 这题的意思就是说，用一个长度为k的数来组成一个数y，使得y大于等于x。
 * 为什么是长度为k的数？因为你第i个数和第k+i个数相同，我们就可以把它看作是一个长度为k的轮回，
 * 即用一个长度为k的数组成y。
 * 首先先从x处获取前k个数组成y。然后拿y来和x比较（k个数k个数的比），
 * 当有个位置上x[i]大于y[i]时，我们给y的最小位+1。因为我们要保证y组成的n个数大于等于x，
 * 如果在相同位时x有一个数大于y，那显然是不成立的，所以我们要修改y的值，
 * 那么为什么我们要修改的是最低位的值？这里要举个例子说明：
 * 比如x是354365，k是3，那么我们得到的y是354，和x开始k个数k个数的比较，
 * 因为我们是从x获取的前k个数，所以下标0k-1这一段是完全相同的。然后我们看后面的365和y比，
 * 第二位上6比y的5大，如果我们修改第二位，把它变成6，这样y就变成了364，
 * 最后组成的数是364364，而如果我们修改的是最小位的，4变成5，则最后会是355355。
 * 显然要比前面那个小。就像我们说的，下标0k-1这一段是完全相同的，
 * 第一次比较的最低位对于后面比较的任何一位都是高位数，所以修改了这一位后，
 * 后面我们就可以不用管了，毕竟高位上已经比x大了，后面数为何种情况都不会使得x大于y。
 * 说人话就是，我们在比较的过程中，只要有一位是x比y大，那我们直接给y最低位+1就可以了，
 * 而且经过这一步操作后就直接结束比较。
 * 那么有没有可能最后组成的数会比x还多一位呢？
 * 当然是不可能的，比较x可以等于y，不管怎么样，我们最多把每一位都变成9，
 * 那么无论如何都能满足y大于等于x的，没必要多一位。
 */

int main() {
    int n, k;
    cin >> n >> k;
    vector<int> x(n), y(k);
    string s;
    cin >> s;
    bool flag = true;
    for (int i = 0; i < n; i++) {
        x[i] = s[i] - '0';
        if (i < k)y[i] = x[i];
    }
    flag = false;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < k; j++) {
            if (y[j] < x[i + j]) {
                int ans = k - 1;
                while (y[ans] == 9)ans--;
                y[ans]++;
                for (int l = ans + 1; l < k; l++)y[l] = 0;
                flag = true;
                break;
            } else if (y[j] > x[i + j]) {
                flag = true;
                break;
            }
        }
        i += k - 1;
        if (flag)break;
    }
    cout << n << endl;
    for (int i = 0; i < n; i++) {
        cout << y[i % k];
    }
    return 0;
}
