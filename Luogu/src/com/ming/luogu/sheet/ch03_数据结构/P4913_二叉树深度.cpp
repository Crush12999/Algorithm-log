#include <iostream>
using namespace std;


int n, t[201010][2];

int dfs(int x) {
    if (x == 0) {
        return 0;
    }
    return max(dfs(t[x][0]), dfs(t[x][1])) + 1;
}

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> t[i][0] >> t[i][1];
    }

    cout << dfs(1) << endl;

    return 0;
}
