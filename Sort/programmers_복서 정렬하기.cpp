//https://programmers.co.kr/learn/courses/30/lessons/85002
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
//정렬 문제
//승률 높은 순 /경기 횟수0인 사람은 승률0
//승률 같으면 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서 순
//위에도 같다면 몸무게 무거운 순
//몸무게까지 같다면 번호 오름차순
//2<=weights <=1000
//45<=weights[i]<=150
//head2head 길이 weights 동일
//head2head[i]길이도 weights길이와 동일 N W L
//승률,자기보다 무거운 복서 이긴 횟수, 몸무게, 번호
vector<double> totalGame;
bool cmp(const pair<pair<double,int>,pair<int,int>> &a, const pair<pair<double,int>,pair<int,int>> &b){
    if(a.first.first==b.first.first){
        if(a.first.second==b.first.second){
            if(a.second.first==b.second.first){
                return a.second.second < b.second.second;
            }
            return a.second.first>b.second.first;
        }
        return a.first.second>b.first.second;
    }
    return a.first.first>b.first.first;
}

bool visited[1000][1000];
vector<int> solution(vector<int> weights, vector<string> head2head) {
    vector<int> answer(weights.size());
    vector<pair<pair<double,int>,pair<int,int>>> result(weights.size());    
    totalGame.resize(weights.size(),weights.size());
    for(int i=0; i<weights.size();i++){
        result[i].second = {weights[i],i+1};
        for(int j=0; j<head2head[i].size();j++){
            if(i==j || head2head[i][j]=='N'){
                totalGame[i]--;
                continue;
            }
            if(visited[i][j] || visited[j][i]) continue;
            visited[i][j]=true;
            //i가 이긴 경우
            if(head2head[i][j]=='W'){
                result[i].first.first++;
                if(weights[i]<weights[j]){
                result[i].first.second++;
                
                }
            }
            //j가 이긴 경우
            else{
                result[j].first.first++;
                if(weights[i]>weights[j]){
                result[j].first.second++;
                }
            }  
        }
    }
    //승률을 나눌 전체 게임은 N은 제외 해야 함
    for(int i=0; i<weights.size();i++){
        if(totalGame[i]!=0)
        result[i].first.first /= totalGame[i];
    }
    
    sort(result.begin(),result.end(),cmp);
    for(int i=0; i<weights.size();i++){    
        answer[i] = result[i].second.second;
    }
    return answer;
}
