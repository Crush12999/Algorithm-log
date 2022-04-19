#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

/**
 * 我采用的是dp做法，当然bfs也是可以的，但是要注意给每个位置打上标记防止走重复了。
 * dp数组dp[i] [j]的意思是：当走到i行j列的位置上是，走过的最长路径长度。
 * 因为我们每次只能往左走或者往下走，这说明了我们想走到 [i] [j]只能从[i-1] [j]往下走一步
 * 得到或者从[i] [j-1]往右走一步得到，
 * 所以状态转移方程为：dp[i] [j]=max(dp[i-1] [j],dp[i] [j-1])+1。
 * 但是直接这样写是会有问题的，我们要注意判断一下两个特殊性，
 * 一是当前位置是“#”，此时这位置是无法走到的，所以dp[i] [j]就是0
 * 二是虽然当前是“.”，但却无法走到当前位置的情况，比如这么一个样例：
 * 3 10
 * ..#.......
 * ##........
 * ..........
 * 答案应当是2，但要是我们不判断情况2，答案是会错误的，
 * 我们实际能走的地方只有左上角的地方，但是我们之前的计算方法会去计算后面的那些点，
 * 但实际上那些点是走不到的。所以我们应该判断一下，
 * 如果上方和前方是0（即这两处位置也走不到）那你本身也该是0。
 */

typedef pair<int, int> PII;
char c[110][110];
PII que[10000];
int moves[110][110];
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, m, res = 1;
    string s;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> s;
        for (int j = 0; j < m; j++)
            c[i][j] = s[j];
    }

    moves[0][0] = 1;
    for (int i = 1; i < n; i++)
        if (c[i][0] == '.') {
            moves[i][0] = moves[i - 1][0] + 1;
            res = max(moves[i][0], res);
        } else break;

    for (int i = 1; i < m; i++)
        if (c[0][i] == '.') {
            moves[0][i] = moves[0][i - 1] + 1;
            res = max(res, moves[0][i]);
        } else break;
    for (int i = 1; i < n; i++)
        for (int j = 1; j < m; j++)
            if (c[i][j] == '.') {
                if (moves[i - 1][j] == 0 && moves[i][j - 1] == 0)continue;
                moves[i][j] = max(moves[i - 1][j], moves[i][j - 1]) + 1;
                res = max(res, moves[i][j]);
            }
    cout << res;
    return 0;
}
