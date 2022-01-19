// 转二进制 51Nod - 2112
#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    while (n != 0) {
		cout << n % 2;
        n /= 2;
    }
    return 0;
}