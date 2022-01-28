//最暴力的方式就是列举所有子串然后再判断复杂度为n^3，中心扩展为n^2，注意中心的分类
class Solution {//中心扩展
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<2*n-1;i++){
            int l=i/2;
            int r=i/2+i%2;
            while(0<=l && r<n&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }
}

class Solution {//马拉车算法
    public int countSubstrings(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }
}

