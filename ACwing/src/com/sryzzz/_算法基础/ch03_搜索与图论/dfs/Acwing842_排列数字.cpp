#include <iostream>

using namespace std;

int ans[10];
bool b[10];
int n;

void dfs(int u) {
    if (u == n) {
        for (int i = 0; i < n; i++)cout << ans[i] << " ";
        cout << "\n";
        return;
    }

    for (int i = 1; i <= n; i++) {
        if (!b[i]) {
            ans[u] = i;
            b[i] = true;
            dfs(u + 1);
            b[i] = false;
        }
    }
}

int main() {
    cin >> n;
    dfs(0);
    return 0;
}