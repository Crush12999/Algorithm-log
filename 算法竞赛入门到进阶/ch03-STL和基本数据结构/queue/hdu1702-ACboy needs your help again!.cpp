//
// hdu1702 ACboy needs your help again!
//

#include <bits/stdc++.h>
using namespace std;

int n, m, k;
queue<int> q;
stack<int> s;
char str1[10], str2[10];

int main() {
    scanf("%d", &n);
    while (n--) {
        while (!s.empty()) {
            s.pop();
        }
        while (!q.empty()) {
            q.pop();
        }
        scanf("%d %s", &m, str1);
        if (strcmp(str1, "FIFO") == 0) {
            for (int i = 0; i < m; i++) {
                scanf("%s", str2);
                if (strcmp(str2, "IN") == 0) {
                    scanf("%d", &k);
                    q.push(k);
                } else {
                    if (!q.empty()) {
                        printf("%d\n", q.front());
                        q.pop();
                    } else {
                        printf("None\n");
                    }
                }
            }
        } else {
            for (int i = 0; i < m; i++) {
                scanf("%s", str2);
                if (strcmp(str2, "IN") == 0) {
                    scanf("%d", &k);
                    s.push(k);
                } else {
                    if (!s.empty()) {
                        printf("%d\n", s.top());
                        s.pop();
                    } else {
                        printf("None\n");
                    }
                }
            }
        }
    }
    return 0;
}