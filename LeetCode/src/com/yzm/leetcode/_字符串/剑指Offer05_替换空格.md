```c++
class Solution {
public:
    string replaceSpace(string s) {
        // 统计空格的个数
        int count = 0;
        int oldStrLen = s.size();
        for (int i = 0; i < oldStrLen; i++) {
            if (s[i] == ' ') {
                count++;
            }
        }
        // 扩充字符串s的大小，也就是每个空格替换成"%20"之后的大小
        s.resize(oldStrLen + count * 2);
        int newStrLen = s.size();
        // 从后先前将空格替换为"%20"
        for (int i = newStrLen - 1, j = oldStrLen - 1; j < i; i--, j--) {
            if (s[j] != ' ') {
                s[i] = s[j];
            } else {
                s[i] = '0';
                s[i - 1] = '2';
                s[i - 2] = '%';
                i -= 2;
            }
        }
        return s;
    }
};
```