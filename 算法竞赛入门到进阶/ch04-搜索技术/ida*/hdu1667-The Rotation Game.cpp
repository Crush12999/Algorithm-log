#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int maxn = 100;
const int inf = 0x3f3f3f3f;
int center[8] = { 6,7,8,11,12,15,16,17 };
int reveropt[8] = { 5,4,7,6,1,0,3,2 };
int change[8][7] = {
    {0,2,6,11,15,20,22},
    {1,3,8,12,17,21,23},
    {10,9,8,7,6,5,4},
    {19,18,17,16,15,14,13},
    {23,21,17,12,8,3,1},
    {22,20,15,11,6,2,0},
    {13,14,15,16,17,18,19},
    {4,5,6,7,8,9,10}
};
int tmp[24];
int cnt[5];
int get() {//找出8-出现次数最多的数的出现次数,即至少需要移动的次数
    int maxcnt = 0;
    memset(cnt, 0, sizeof(cnt));
    for (int i = 0; i < 8; i++) {
        cnt[tmp[center[i]]]++;
        maxcnt = max(maxcnt, cnt[tmp[center[i]]]);
    }
    return 8 - maxcnt;
}
void option(int opt) {//移动
    int t = tmp[change[opt][0]];
    for (int j = 0; j < 6; j++) {
        tmp[change[opt][j]] = tmp[change[opt][j + 1]];
    }
    tmp[change[opt][6]] = t;
}
string res;
int depth;
bool dfs(int step, int lastopt) {
    int last = get();
    if (step + last >= depth) return false;//已经移动+至少需要移动>预设深度
    if (!last) {//中心点全都相同了
        printf("%s\n", res.c_str());
        printf("%d\n", tmp[center[0]]);
        return true;
    }
    for (int i = 0; i < 8; i++) {
        if (lastopt != -1 && i == reveropt[lastopt])continue;//如果与上次操作刚好相反的就不要
        res.push_back('A' + i);
        option(i);//移动
        if (dfs(step + 1, i))return true;
        option(reveropt[i]);//回溯
        res.pop_back();
    }
    return false;
}
int main() {
    //freopen("test.txt", "r", stdin);
    while (~scanf("%d", &tmp[0])) {
        if (tmp[0] == 0)break;
        for (int i = 1; i < 24; i++) {
            scanf("%d", &tmp[i]);
        }
        res.clear();
        if (!get()) {
            printf("No moves needed\n%d\n",tmp[center[0]]); continue;
        }
        depth = 1;
        while (1) {
            if (dfs(0, -1))break;
            depth++;
        }
    }
    return 0;
}