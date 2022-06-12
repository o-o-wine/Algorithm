#include <string>
#include <iostream>
#include <vector>

using namespace std;

string solution(string new_id) {
    string answer = new_id;
    int cnt = 0;
    int flag = 0;
    
    // 1단계
    for(int i = 0; i < answer.size(); i++) {
        if(answer[i] >= 65 && answer[i] <= 90)
            answer[i] += 32;
    }
    cout << "1단계 : " << answer << '\n';
    
    // 2단계
    for(int i = 0; i < answer.size(); i++) {
        if(isdigit(answer[i]) || islower(answer[i]) || answer[i] == '-' || answer[i] == '_' || answer[i] == '.')
            continue;
        else {
            answer.erase(i, 1);
            i--;
        }
    }
    cout << "2단계 : " << answer << '\n';
    
    // 3단계
    for(int i = 0; i < answer.size(); i++) {
        if(answer[i] == '.') {
            for(int j = i+1; j < answer.size(); j++) {
                if(answer[j] == '.')
                    cnt++;
                else
                    break;
            }
            answer.erase(i, cnt);
            cnt = 0;
        }
    }
    cout << "3단계 : " << answer << '\n';
    
    // 4단계
    if (answer[0] == '.')
        answer.erase(answer.begin() + 0);
    if (answer[answer.size()-1] == '.')
        answer.erase(answer.end() - 1);
     cout << "4단계 : " << answer << '\n';
    
    // 5단계
    if(answer.size() == 0) {
        answer += 'a';
    }
    cout << "5단계 : " << answer << '\n';
    
    // 6단계
    if(answer.size() >= 16) {
        answer.erase(answer.begin() + 15, answer.end());
    }
     if (answer[answer.size()-1] == '.')
        answer.erase(answer.end() - 1);
    cout << "6단계 : " << answer << '\n';
    
    // 7단계
    if(answer.size() <= 2) {
        char temp = answer[answer.size() - 1];
        while(answer.size() != 3) {
            answer += temp;
        }
    }
    cout << "7단계 : " << answer << '\n';
    
    return answer;
}