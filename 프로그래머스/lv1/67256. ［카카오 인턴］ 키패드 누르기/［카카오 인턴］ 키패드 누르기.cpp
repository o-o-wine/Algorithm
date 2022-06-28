#include <string>
#include <vector>

using namespace std;

int arr[4][3] = { 
    1, 2, 3,
    4, 5, 6,
    7, 8, 9,
    -1, 0, -1
};

string solution(vector<int> numbers, string hand) {
    string answer = "";
    pair<int, int> lh, rh;
    lh = {3, 0}, rh = {3, 2};
    
    for(int i = 0; i < numbers.size(); i++) {
        // 찾기
        for(int r = 0; r < 4; r++) {
            for (int c = 0; c < 3; c++) {
                if (numbers[i] == arr[r][c]) {
                    // 1 4 7 일 때
                    if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                        lh = {r, c};
                        answer += 'L';
                    }
                    // 3 6 9 일 때
                    else if(numbers[i] ==  3 || numbers[i] == 6 || numbers[i] == 9) {
                        rh = {r, c};
                        answer += 'R';
                    }
                    // 2 5 8 0 일때
                    else {
                        int ld = abs(lh.first - r) + abs(lh.second - c);
                        int rd = abs(rh.first - r) + abs(rh.second - c);
                        
                        // 왼손이 가까움
                        if(ld < rd) {
                            lh = {r, c};
                            answer += 'L';
                        }
                        // 오른손이 가까움
                        else if (ld > rd) {
                            rh = {r, c};
                            answer += 'R';
                        }
                        // 거리 같음
                        else if(ld == rd) {
                            // 오른손잡이
                            if(hand == "right") {
                                rh = {r, c};
                                answer += 'R';
                            }
                            // 왼손잡이
                            else if(hand == "left") {
                                lh = {r, c};
                                answer += 'L';
                            }
                        }
                    }                    
                }
            }
        }        
        
    }
    
    return answer;
}