#include <cstring>
#include <bitset>
#include <iostream>
#include <algorithm>
using namespace std;

bitset<1000000> q, t;
int n, m;

int main() {
	
	cin >> n >> m;
	
	t[0] = q[0] = 1;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		t <<= a;
		q <<= b;
		q |= t;
		t = q;
	}
	for (int i = 0; i <= m; i++) {
		cout << q[i];
	}
	
	
	return 0;
}