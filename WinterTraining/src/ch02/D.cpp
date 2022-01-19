#include <iostream>
using namespace std;

// Help Far Away Kingdom CodeForces - 99A

int main() {
    string s;
    cin >> s;
    int point = s.find(".");
	if (s[point - 1] != '9' && s[point + 1] < '5') {
		cout << s.substr(0, point) << endl;
    } else if (s[point - 1] != '9' && s[point + 1] >= '5') {
    	string str = s.substr(0, point-1);
    	str += (char)(s[point-1]+1);
    	cout << str << endl;
    } else {
    	cout << "GOTO Vasilisa." << endl;
    }
    return 0;
}