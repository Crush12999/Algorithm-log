// 回文数 51Nod - 2419
#include <iostream>
using namespace std;

int main() {
    string x;
    cin >> x;
    int len = x.length();
    bool flag = true;
    int l = 0, r = len - 1;
	while (l < r) {
		if (x[l++] != x[r--]) {
			cout << "no" << endl;
			flag = false;
			break;
		}
	}
	if (flag) {
		cout << "yes" << endl;
	}
    return 0;
}