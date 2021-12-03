#include <iostream>
using namespace std;

string getAns() {
    string s = "", x;
    char c;
    int d;
    while (cin >> c) {
        if (c == '[') {
            cin >> d;
            x = getAns();
            while (d--) {
                s += x;
            }
        } else if (c == ']') {
            return s;
        } else {
            s += c;
        }
    }

    return s;
}

int main() {
    cout << getAns();
    return 0;
}