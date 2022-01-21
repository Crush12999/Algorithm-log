#include <iostream>
using namespace std;

// 或减与 51Nod - 2102

int main() {
    int a, b;
    cin >> a >> b;
    cout << ((a|b) - (a&b)) << endl;
    return 0;
}