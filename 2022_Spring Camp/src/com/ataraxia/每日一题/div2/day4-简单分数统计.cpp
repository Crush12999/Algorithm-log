#include <iostream>
#include <cstdio>
#include <map>
#include <vector>
using namespace std;

typedef long long ll;
int n, m, k;
// 简单分数统计，模拟
int main() {
	
	map<string, map<string, int> > stu;
	map<string, int> score;
	cin >> n >> m >> k;
	
	vector<string> names(n);
	
	for (int i = 0; i < n; i++) {
		cin >> names[i];
	}
	for (int i = 0; i < m; i++) {
		int num;
		string str;
		cin >> str >> num;
		score[str] = num;
	}
	for (int i = 0; i < k; i++) {
		string name, subject, flag;
		cin >> name >> subject >> flag;
		if (flag == "AC") {
			stu[name][subject] = score[subject];
		}
	}
	for (int i = 0; i < n; i++) {
		ll ans = 0;
		for (auto it : stu[names[i]]) {
			ans += it.second;
		}
		cout << names[i] << " " << ans << endl;
	}
	
	return 0;
}

