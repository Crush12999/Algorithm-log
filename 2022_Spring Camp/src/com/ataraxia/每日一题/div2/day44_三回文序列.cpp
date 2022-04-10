#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

/**
 * 先遍历一遍数组，记录每个元素的出现次数，然后枚举所有的数作为a（三回文是一种aba形式的字符串），
 * 每次枚举把两边的a的个数都算出来，再枚举中间的b的个数，取总和最大值。
 */


int n;

int change(vector<int> v, int ans, vector<int> nums) {
    int l = 0, r = n - 1, cnt = 0, res = nums[ans];
    while (l < r) {
        while (l < r && v[l] != ans) {
            nums[v[l]]--;
            l++;
        }
        while (l < r && v[r] != ans) {
            nums[v[r]]--;
            r--;
        }
        cnt += min(nums[ans], 2);
        nums[ans] -= 2;
        l++, r--;
        for (int i = 1; i <= 26; i++)res = max(res, cnt + nums[i]);
    }
    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        cin >> n;
        vector<int> v(n), nums(27);
        for (int i = 0; i < n; i++) {
            cin >> v[i];
            nums[v[i]]++;
        }
        int res = 0;
        for (int i = 1; i < 27; i++) {
            if (nums[i] != 0)
                res = max(res, change(v, i, nums));
        }
        cout << res << endl;
    }
    return 0;
}