//https://programmers.co.kr/learn/courses/30/lessons/86971
#include <string>
#include <vector>
#include <algorithm>
#include <cstring>
#include <iostream>
#include <math.h>
using namespace std;
//두 개의 그룹으로 분리
//간선 하나씩 제외하면서 dfs
//dfs로 두 그룹 추출 -> n개를 방문했다면 result 비교
int answer =987654321;

vector<int> edge[101];
pair<int,int> except[101];
int visitCnt[2];
int groupCnt;
bool visited[101];
bool exceptCheck(int exceptIdx, int cur, int next){
    int from =except[exceptIdx].first;
    int to = except[exceptIdx].second;
    if((from==cur && to ==next) || (to==cur && from==next)){
        return true;
    }
    return false;
}
void dfs(int exceptIdx,int cur){
    visited[cur]=true;
    visitCnt[groupCnt]++;
    for(int i=0; i< edge[cur].size();i++){
        int next =edge[cur][i]; 
        if(exceptCheck(exceptIdx,cur,next)) continue;
        if(visited[next])continue;
        dfs(exceptIdx,next);
    }
}

int solution(int n, vector<vector<int>> wires) {
    for(int i=0; i< wires.size();i++){
        edge[wires[i][0]].push_back(wires[i][1]);
        edge[wires[i][1]].push_back(wires[i][0]);
        except[i]={wires[i][0],wires[i][1]};
    }
    for(int i=0; i< wires.size();i++){//한 개의 간선씩 제외
        
        for(int j=1; j<=n;j++){//두 그룹 추출
            if(visited[j])continue;
            dfs(i,j);
            groupCnt++;
           
        }
        if(groupCnt==2){   
            answer = min(answer,abs(visitCnt[0]-visitCnt[1]));
        }
        groupCnt=0;
        visitCnt[0]=visitCnt[1]=0;
        memset(visited,false,101);
    }
    return answer;
}
