#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<ll, ll>PII;
const int N = 200010;
ll f[N], s[N], e[N];


int main()
{
	ll n,k;
	cin >> n;
	map<ll, ll>mymap;
	ll m, res = 0, sum = 0, num;
	int l = 0, r = 0;
	cin >> k;
	vector<int>v(n + 1), s(n + 1);
	for (int i = 1; i <= n; i++)
	{
		cin >> num;
		v[i] = num - 1;
		s[i] = s[i - 1] + v[i];
		s[i] %= k;
		if (s[i] == 0)res++;
		r++;
		if (r - l + 1 > k)
		{
			mymap[s[l]]--;
			l++;
		}
		res += mymap[s[i]];
		mymap[s[i]]++;

	}
	cout << res << endl;


	return 0;
}