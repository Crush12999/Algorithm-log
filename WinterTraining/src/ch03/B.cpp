#include <iostream>
using namespace std;

// 二维数组转置 51Nod - 1504
const int N = 105;
int a[N][N];

int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
    	for (int j = 0; j < m; j++) {
    		cin >> a[i][j];
    	}
    }
    cout << m << " " << n << endl;
    for (int j = 0; j < m; j++) {
    	for (int i = 0; i < n; i++) {
    		cout << a[i][j] << " ";
    	}
    	cout << endl;
    }
    return 0;
}