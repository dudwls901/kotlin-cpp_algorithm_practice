//https://programmers.co.kr/learn/courses/30/lessons/86048
#include <string>
#include <vector>
#include <unordered_set>
using namespace std;

vector<int> solution(vector<int> enter, vector<int> leave) {
    vector<int> answer(enter.size());
    unordered_set<int> se;
    int leaveIdx=0;
    int enterIdx=0;
    for(int i=0; i<enter.size();i++){
        //입장할 사람이 남아 있다면
        //cnt 증가
        answer[enter[i]-1]+=se.size();
        for(auto o : se){
            answer[o-1]++;
        }
        //입장
        se.insert(enter[i]);
        
        //퇴장할 사람이 방에 없을 때까지
        while(leaveIdx<leave.size() && se.find(leave[leaveIdx])!=se.end()){
            se.erase(leave[leaveIdx++]);
        }
    }
    return answer;
}
