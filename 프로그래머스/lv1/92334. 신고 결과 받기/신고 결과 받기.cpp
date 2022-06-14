#include <string>
#include <vector>
#include <map>
#include <set>
#include <sstream>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    map<string, int> cnt;
    map<string, set<string>> log;
    
    for(string s : report) {
        string from, to;
        stringstream str(s);
        str >> from >> to;
        
        if (log[from].find(to) == log[from].end()) {
            log[from].insert(to);
            cnt[to]++;
        }
    }
    
    for(string id : id_list) {
        int r_cnt = 0;
        
        for (string check : log[id])
            if(cnt[check] >= k)
                r_cnt++;
        
        answer.push_back(r_cnt);                
    }
    
    return answer;
}