#include<iostream>
#include<string>
#include<stack>

using namespace std;

int main() {
	//后向栈
    stack<string> backward;
    //前向栈
    stack<string> forward;
    string c;
    string cur = "http://www.acm.org/";
    while (cin >> c && c != "QUIT") {
        if (c == "VISIT") {
            backward.push(cur);
			cin >> cur;
			cout << cur << endl;
			//前向栈不为空则清空
            while (!forward.empty()) forward.pop(); 
        } else if(c == "BACK") { 
			if(backward.empty()) cout << "Ignored" << endl;	
            else {
                forward.push(cur);
                cur = backward.top();
                backward.pop();
				cout << cur << endl;
            }
        } else {
            if (forward.empty())
				cout << "Ignored" << endl;	
            else {
                backward.push(cur);
                cur = forward.top();
                forward.pop();
				cout << cur << endl;
            }
        }
    }
    return 0 ;
}
