#include <iostream>
#include <algorithm>
#include <vector>
#define ll long long 

using namespace std;

ll MOD = 1234567891;
ll fac[1000001] = { 1, 1, };

ll fermat(int N, long long mod);

int main(void)
{
    int T;
    cin >> T;

    for (int i = 2; i <= 1000000; i++)
        fac[i] = (fac[i - 1] * i) % MOD;

    for (int tc = 1; tc <= T; tc++)   {
        int N, R;
        long long ans, a;

        cin >> N >> R;

        a = fermat((fac[R] * fac[N - R]) % MOD, MOD - 2);
        ans = (fac[N] * a) % MOD;

        cout << "#" << tc << " " << ans << endl;
    }

    return 0;
}

ll fermat(int N, long long mod) {
    if (mod == 0) {
        return 1;
    }

    ll tmp = fermat(N, mod / 2);
    ll ans = (tmp * tmp) % MOD;

    if (mod % 2 == 0) {
        return ans;
    }
    else {
        return (N * ans) % MOD;
    }
}