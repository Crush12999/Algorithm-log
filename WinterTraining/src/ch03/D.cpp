#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// Helpful Maths CodeForces - 339A
// 可以统计1、2、3的数量，从小到大输出它们的序列就可以
// 也可以取出数字存到数组里，排序后再输出。

int main() {
	vector<int> v;
	string s;
	cin >> s;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] != '+') {
			v.push_back(s[i] - '0');
		}
	}
	sort(v.begin(), v.end());
	for (auto it = v.begin(); it != v.end() - 1; it++) {
		cout << *it << "+";
	}
	cout << *(v.end()-1) << endl;
    return 0;
}