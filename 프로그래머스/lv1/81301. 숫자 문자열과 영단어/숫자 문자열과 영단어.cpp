#include <string>
#include <iostream>
#include <vector>
#include <map>

using namespace std;

int solution(string s) {
    int answer = 0;
    string num = "";
    string tmp = "";
    map<string, char> cmap;
    
    cmap["zero"] = '0';
    cmap["one"] = '1';
    cmap["two"] = '2';
    cmap["three"] = '3';
    cmap["four"] = '4';
    cmap["five"] = '5';
    cmap["six"] = '6';
    cmap["seven"] = '7';
    cmap["eight"] = '8';
    cmap["nine"] = '9';
    
    for(int i = 0; i < s.size(); i++) {
        if (isdigit(s[i]) != 0)
            num += s[i];
        else {
            tmp += s[i];
        }
        
        if(cmap.find(tmp) != cmap.end()) {
            num += cmap[tmp];
            tmp = "";
        }
    }
    
    answer = stoi(num);
    
    cout << answer << '\n';
    
    return answer;
}