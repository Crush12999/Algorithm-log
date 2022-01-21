#include <iostream>
using namespace std;

// Boy or Girl CodeForces - 236A
// 做个字符哈希，小写字母的ASCII从97开始，总共就26个小写字母。
// 统计不同字符的个数，奇数为男，否则是女性，输出结果
int a[150];

int main() {
	char ch;
	int ans = 0;
	while ((ch = getchar()) != EOF) {
		a[(int)ch]++;
	}
	for (int i = 97; i < 150; i++) {
		if (a[i] != 0) {
			ans++;
		}
	}
	if (ans & 1) {
		cout << "IGNORE HIM!" << endl;
	} else {
		cout << "CHAT WITH HER!" << endl;
	}
    return 0;
}