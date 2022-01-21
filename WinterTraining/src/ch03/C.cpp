#include <iostream>
#include <cmath>
using namespace std;

// Beautiful Matrix CodeForces - 263A
// 如果1的坐标是(row行, col列)，那么答案显然是|3-row|+|3-col|
const int N = 6;
int a[N][N];

int main() {
	int row, col;
    for (int i = 1; i <= 5; i++) {
    	for (int j = 1; j <= 5; j++) {
    		cin >> a[i][j];
    		if (a[i][j] == 1) {
    			row = i;
    			col = j;
    		}
    	}
    }
    cout << abs(3-row) + abs(3-col) << endl;
    return 0;
}