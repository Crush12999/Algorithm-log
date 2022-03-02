#include <bits/stdc++.h>

using namespace std;

int color, name, flag = 1;


int main() {

	std::ios::sync_with_stdio(false);
	cin.tie(nullptr);

	vector<int> a(6, 0), b(6, 0);

	for (int i = 1; i < 6; i++) {
		cin >> a[i];
	}

	sort(a.begin(), a.end());

	for (int i = 1; i < 6; i++) {
		cin >> b[i];
	}

	for (int i = 2; i < 6; i++) {
		if (b[i-1] == b[i]) {
			color++;
		}
	}

	int s = a[1];

	for (int i = 1; i < 6; i++) {
		if (a[i] != s++) {
			flag = 0;
			break;
		}
	}

	for (int i = 2; i < 6; i++) {
		if (a[i-1] == a[i]) {
			name++;
		}
	}

	if (color == 4) {
		if (a[5] == 14) {
			cout << "ROYAL FLUSH";
		} else if (flag) {
			cout << "STRAIGHT FLUSH";
		} else {
			cout << "FLUSH";
		}
	} else {
		if (name == 3) {
			if (a[2] == a[4]) {
				cout << "FOUR OF A KIND";
			} else {
				cout << "FULL HOUSE";
			}
		} else if (flag) {
			cout << "STRAIGHT";
		} else {
			cout << "FOLD";
		}
	}

	return 0;
	
}