// 四舍六入五留双 51Nod - 2103
#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    double f;
    int b;
    cin >> f >> b;
    cout << fixed << setprecision(b) << f;
    return 0;
}