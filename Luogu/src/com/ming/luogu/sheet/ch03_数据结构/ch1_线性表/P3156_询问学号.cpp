#include <iostream>
#include <vector>
using namespace std;

int n, m, t;
vector<int> stuList;

int main() {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> t;
        stuList.push_back(t);
    }
    for (int i = 0; i < m; i++) {
        cin >> t;
        cout << stuList[t - 1] << endl;
    }
    return 0;
}