#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

/**
 * 一个数可以向下衍生出4个不同的样子，它的四个分支又可以各自伸出4个分支。
 * 当在这个树上找到我们要转化的目标值时，第一次出现的层数就是它经过操作的次数。
 * 然后只要找完这n个点所在层数最后一起输出就行。
 * 但是，如果我们直接这么写，是会超时的！
 * 我们每过一层，下一层要遍历节点数就是当前层的4倍，这是相当吓人的。所以我们要进行剪枝操作。
 * 首先我们可以知道，子节点出现的值可能是会重复的，
 * 比如当前节点的值是2，当它减一后*2，又会变成2，
 * 即在下面二层的位置上会出现一个一样的数，而通过2得到的情况我们已经知道了，
 * 没有必要在这里继续延伸，继续衍生会导致很多重复的计算，
 * 这是很不划算的，所以我们要把这个子节点给剪掉。我们预先准备一个数组，
 * 记录没出现过的数，如果当前节点的数没有在数组里出现过，
 * 那我们就把这个节点存入下一层里，同时把状态修改为出现过。如果这个数之前已经出现过了，那我们就跳过他即可。
 * 还有第二个剪枝操作，注意题目给的数据范围是1到1e5，
 * 但是我们的操作是会使得当前节点的值超过这个范围(小于1或者大于1e5)，
 * 首先我们知道，既然题目给的数据没有小于1的，那我们延伸小于1的节点的四种情况就很没必要了，
 * 所以当节点小于1时，我们也直接跳过。但对于大于1e5的情况有点特殊，
 * 我们不能直接把大于1e5的情况跳过，这会使得我们的结果有错误，比如目标值是1e5，
 * 我们当前节点是50001，只要翻倍后减2就可以得到目标值了，
 * 但如果我们翻倍好的结果(1e5+2)删掉，想通过50001得到1e5的方法就只有重复+1操作49999次了。
 * 所以我们应该要适当调整我们的范围。
 * 一般来说只要是题目数据区间的稍大点即可，大过这个范围的节点我们也跳过。
 */

const int N = 300050;
int a[N], f[N];

inline int read() {
    int x = 0;
    char ch = getchar();
    while (ch < '0' || ch > '9') ch = getchar();
    while (ch >= '0' && ch <= '9') x = (x << 3) + (x << 1) + ch - '0', ch = getchar();
    return x;
}

void write(int x) {
    if (x > 9) write(x / 10);
    putchar(x % 10 | '0');
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, num;
    num = read(), n = read();
    vector<int> v(n);
    for (int i = 0; i < n; i++) {
        v[i] = read();
        a[v[i]] = -1;
    }
    queue<int> que;
    que.push(num);
    int res = 0;
    while (!que.empty() && n) {
        int len = que.size();
        for (int i = 0; i < len; i++) {
            int ans = que.front();
            que.pop();
            if (a[ans] == -1) {
                a[ans] = res;
                n--;
            }
            if (ans * 3 < 100050 && f[ans * 3] == 0) {
                que.push(ans * 3);
                f[ans * 3] = 1;
            }
            if (ans * 2 < 100050 && f[ans * 2] == 0) {
                que.push(ans * 2);
                f[ans * 2] = 1;
            }
            if (ans - 1 > 0 && f[ans - 1] == 0) {
                que.push(ans - 1);
                f[ans - 1] = 1;
            }
            if (ans + 1 < 100050 && f[ans + 1] == 0) {
                que.push(ans + 1);
                f[ans + 1] = 1;
            }
        }
        res++;
    }
    for (auto i: v) {
        write(a[i]);
        putchar(' ');
    }
    return 0;
}
