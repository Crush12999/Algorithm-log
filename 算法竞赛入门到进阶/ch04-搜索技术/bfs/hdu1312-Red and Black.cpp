// hdu1312-Red and Black
#include <bits/stdc++.h>
using namespace std;
char mp[23][23];
// 左上右下
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
// wx行，hy列，用 num 统计可走的位置有多少
int wx, hy, num;
// 是否在 room 中
#define check(x, y) (x >= 0 && x < wx && y >= 0 && y < hy)
struct node {
    int x, y;
};

void bfs(int x, int y) {
    num = 1;			// 起点也包含在砖块内
    queue<node> q;		// 队列中放坐标点
    node start, next;
    start.x = x;
    start.y = y;
    q.push(start);
    while (!q.empty()) {
        start = q.front();
        q.pop();
        // cout << "out" << start.x << start.y << endl; 打印出队情况
    	for (int i = 0; i < 4; i++) {
            next.x = start.x + dx[i];
            next.y = start.y + dy[i];
            if (check(next.x, next.y) && mp[next.x][next.y] == '.') {
                mp[next.x][next.y] = '#';	// 进队之后标记为已处理
                num++;
                q.push(next);
            }
        }
    }
}

int main() {
    int x, y, tx, ty;
    while (cin >> wx >> hy) {	// wx行，hy列
        if (wx == 0 && hy == 0) {	// 结束
            break;
        }
        for (y = 0; y < hy; y++) {	// 有hy列
            for (x = 0; x < wx; x++) {	// 一次读入一行
                cin >> mp[x][y];
                if (mp[x][y] == '@') {	// 读入起点
                    tx = x;
                    ty = y;
                }
            }
        }
        num = 0;
        bfs(tx, ty);
        cout << num << "\n";
    }
    return 0;
}