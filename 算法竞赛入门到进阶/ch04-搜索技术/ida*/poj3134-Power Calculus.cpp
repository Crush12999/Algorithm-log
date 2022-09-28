// poj3134-Power Calculus
#include <bits/stdc++.h>
using namespace std;
int val[1010];	// 保存一个搜索路径上每一步的计算结果
int pos, n;

bool ida(int now, int depth) {
    if (now > depth) {	// 大于当前设定的DFS深度，退出
        return false;
    }
    if (val[pos] << (depth - now) < n) {
        return false;	// 估价函数：用最快的倍增都不能到达n，退出
    }
    if (val[pos] == n) {
        return true;	// 当前结果等于 n，搜索结束
    }
    pos++;
    for (int i = 0; i < pos; i++) {
        val[pos] = val[pos - 1] + val[i];	// 上一个数与前面所有的数相加
        if (ida(now + 1, depth)) {
            return true;
        }
        val[pos] = abs(val[pos - 1] - val[i]);	// 上一个数与前面所有的数相减
        if (ida(now + 1, depth)) {
            return true;
        }
    }
    pos--;
    return false;
}

int main() {
    int t;
    while (cin >> n && n) {
        int depth;
        for (depth = 0; ; depth++) {	// 每次只 DFS 到深度 depth
            val[pos = 0] = 1;	// 初始值是1
            if (ida(0, depth)) {	// 每次都从0层开始dfs到第depth层
                break;
            }
        }
        cout << depth << endl;
    }
    return 0;
}