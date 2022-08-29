#include <bits/stdc++.h>

using namespace std;
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, -1, 0, 1};

int bfs(string start) {
    string end = "12345678x";
    queue<string> q;
    unordered_map<string, int> mp;

    q.push(start);
    mp[start] = 0;

    while (q.size()) {
        auto head = q.front();
        q.pop();
        int dist = mp[head];
        if (head == end) return dist;
        int k = head.find('x');
        int x = k / 3, y = k % 3;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx >= 0 && tx < 3 && ty >= 0 && ty < 3) {
                swap(head[k], head[tx * 3 + ty]);
                if (!mp.count(head)) {
                    mp[head] = dist + 1;
                    q.push(head);
                }
                swap(head[k], head[tx * 3 + ty]);
            }
        }
    }
    return -1;
}

int main() {
    string c, start;
    for (int i = 0; i < 9; i++) {
        cin >> c;
        start += c;
    }
    cout << bfs(start) << "\n";
}