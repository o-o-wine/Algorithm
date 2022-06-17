#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int rankcheck(int a) {
    switch (a) {
        case 6:
            return 1;
        case 5:
            return 2;
        case 4:
            return 3;
        case 3:
            return 4;
        case 2:
            return 5;
        case 1:
            return 6;
        case 0:
            return 6;
    }
}

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    
    int win_check = 0;
    int lose_check = 0;
    int zero_check = 0;
    
    for(int i = 0; i < lottos.size(); i++) {
        if(lottos[i] == 0)
            zero_check++;
        if(find(win_nums.begin(), win_nums.end(), lottos[i]) == win_nums.end())
            continue;
        else
            win_check++;
    }
    lose_check = win_check;
    win_check += zero_check;
        
    //cout << rankcheck(win_check) << '\n' << rankcheck(lose_check) << '\n';
    
    answer.push_back(rankcheck(win_check));
    answer.push_back(rankcheck(lose_check));
    
    return answer;
}