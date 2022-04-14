#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

/**
 * 第一个操作：向集合中插入值。这个操作并不难，有非常多的方法都能做到。
 * 第三个操作：输出最小值并删除。我们利用优先队列或mulset等容器都可以很方便的做到。
 * 问题就是第二个操作，怎么能在短时间内把所有的值都加上1？
 * 说到区间修改有的人可能会想到线段树，确实，线段树是个可行的方法，
 * 加上lz标记后，我们可以在logn的时间内做到区间修改，并且只要每个点存储的都是区间内的最小值，
 * 我们就可以在logn的时间内完成区间修改，logn的时间内找到最小值并将其删除，logn的时间内插入一个元素。
 * 但是lz标记这种东西写起来我觉得太麻烦了！我们有没有办法能做到更简便的完成操作二？
 * 当然是有的，我才不想跑去写lz标记。我们可以假装把所有的元素都加上x，
 * 我们用一个变量add存下所有加在全体的x，只要第三次操作输出值的时候把add加上那个值即可。
 * 那么有个问题，比如我前面先插入几个元素后全体加10，然后插入了一个很小的元素，
 * 这样操作三会输出这个很小的元素，输出的时候会加上add，
 * 但是这个元素在逻辑上并没有加上10，怎么办？
 * 我们只要插入的时候，把元素预先减去add再插入即可，比如我这里插入的11，但实际插入的是1。
 * 这样在再输出的也是11。至于操作一和三，我们只要找一个能很快找到最小值的容器就行。
 */

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    ll t, add = 0;
    priority_queue<ll, vector<ll>, greater<ll>> que;
    cin >> t;
    while (t--) {
        int st;
        cin >> st;
        if (st == 1) {
            ll x;
            cin >> x;
            que.push(x - add);
        } else if (st == 2) {
            ll x;
            cin >> x;
            add += x;
        } else {
            cout << que.top() + add << "\n";
            que.pop();
        }
    }
    return 0;
}
