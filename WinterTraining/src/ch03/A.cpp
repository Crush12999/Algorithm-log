#include <iostream>
using namespace std;

// ζεδΈ 51Nod - 2102

int main() {
    int a, b;
    cin >> a >> b;
    cout << ((a|b) - (a&b)) << endl;
    return 0;
}