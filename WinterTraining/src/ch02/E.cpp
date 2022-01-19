#include <iostream>
using namespace std;

// Bit++ CodeForces - 282A

int main() {
    int n, x = 0;
    cin >> n;
    while (n--) {
    	string s;
    	cin >> s;
    	int flag = s.find("+");
    	if (flag >= 0) {
    		x++;
    	} else {
    		x--;
    	}
    }
    cout << x << endl;
    return 0;
}