#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

struct Student {
    int age, height, no;
};

unordered_map<string, Student> c;
int n, m;
string name;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        cin >> name;
        cin >> c[name].age >> c[name].height >> c[name].no;
    }
    for (int i = 1; i <= m; i++) {
        cin >> name;
        if (c.find(name) != c.end()) {
            cout << c[name].age << " " << c[name].height << " " << c[name].no << "\n";
        } else {
            cout << "-1 -1 -1\n";
        }
    }
    return 0;
}
