#include<iostream>
using namespace std;
int n;
char g[20][20];
int col[12] = {0};
bool check(int c, int r) {
    for (int i = 0; i < r; i++)
        if (col[i] == c || (abs(col[i] - c) == abs(i - r)))
            return false;
    return true;
}

void dfs(int r) {
    if (r == n) {
        for (int i = 0; i < n; i++) puts(g[i]);
        puts("");
        return;
    }
    for (int c = 0; c < n; c++) {
        if(check(c, r)) {
            col[r] = c;
            g[r][c] = 'Q';
            dfs(r + 1);
            g[r][c] = '.';
        }
    }
}
int main(){
    cin >> n;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            g[i][j] = '.';
    dfs(0);
    return 0;
}