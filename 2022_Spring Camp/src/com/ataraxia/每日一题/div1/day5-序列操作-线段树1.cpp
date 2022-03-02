#include <iostream>
using namespace std;

const int N = 1e6 + 7;

struct node {
	int l, r, val, lazy;
} tree[N<<2];

void push_up (int rt ) {
	// 记录左右孩子的最小值
	tree[rt].val = min(tree[rt<<1].val, tree[rt<<1|1].val);
}
// https://blog.csdn.net/weixin_43054397/article/details/101345726?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EOPENSEARCH%7ERate-1.pc_relevant_antiscan&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EOPENSEARCH%7ERate-1.pc_relevant_antiscan&utm_relevant_index=2
void push_down ( int rt ) {
	if (tree[rt].lazy) { 
		// 如果当前节点要更改的值比当前区间的最小值还小，就不需要覆盖，否则覆盖
		int lazy = tree[rt].lazy;
		tree[rt<<1].lazy = max(tree[rt<<1].lazy, lazy); // 标记最大值
		tree[rt<<1|1].lazy = max(tree[rt<<1|1].lazy, lazy);
		tree[rt<<1].val = max(tree[rt<<1].val, lazy);
		tree[rt<<1|1].val = max(tree[rt<<1|1].val, lazy);
		tree[rt].lazy = 0;
	}
}

void build (int l, int r, int rt) {
	tree[rt].l = l;
	tree[rt].r = r;
	tree[rt].lazy = 0;
	if (l == r) {
		cin >> tree[rt].val;
		return ;
	}
	int m = (l + r) >> 1;
	build(l, m, rt<<1);
	build(m + 1, r, rt<<1|1);
	push_up(rt);
}

void update1 (int l, int r, int val, int rt) { // 单点修改
	if (tree[rt].l == tree[rt].r) {
		tree[rt].val = val;
		return ;
	}
	push_down(rt);
	int m = (tree[rt].l + tree[rt].r) >> 1;
	if (l <= m) update1(l, r, val, rt<<1);
	if (m < r) update1(l, r, val, rt<<1|1);
	push_up(rt);
}

void update2 (int val, int rt) { // 区间修改
	tree[rt].val = max(tree[rt].val, val);
	tree[rt].lazy = max(tree[rt].lazy, val);
	return ;
}

int query (int l, int r, int rt) { // 查询
	if (tree[rt].l == tree[rt].r) {
		return tree[rt].val;
	}
	push_down(rt);
	int m = (tree[rt].l + tree[rt].r) >> 1;
	if (l <= m) return query(l, r, rt<<1);
	if (m < r) return query(l, r, rt<<1|1);
}

int main() {
	ios::sync_with_stdio(false);
	int n, q;
	cin >> n >> q;
	build(1, n, 1);
	
	while (q--) {
        int op, x, y;
        cin >> op;
		if (op == 1) {
			cin >> x >> y;
			update1(x, x, y, 1);
		} else {
			cin >> y;
			update2(y, 1);
		}
	}
	for (int i = 1; i <= n; i++) {
		cout << query(i, i, 1) << " ";
	}
	return 0;
}

