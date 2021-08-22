//https://programmers.co.kr/learn/courses/30/lessons/43162
#include <string>
#include <vector>
#include <iostream>
using namespace std;
bool visited[200];

void dfs(int start, int n, vector<vector<int>> &computers){
visited[start]=true;
    for(int i=0; i<computers[start].size();i++){
        if(i!=start&&!visited[i]&&computers[start][i]){

            dfs(i,n,computers);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer=0;
    for(int i=0; i<computers.size();i++){
        for(int j=0; j<computers[i].size();j++){
           // cout << computers[i][j]<<' ';
            if(computers[i][j]){
                cout <<i <<' '<<j<<'\n';
            }
        }
        cout <<'\n';
    }
 
    for(int i=0; i<computers.size();i++){
        if(!visited[i]){
      //      cout <<i<<'\n';
           
        dfs(i,n,computers);
            answer++;
        }
    }
    dfs(0,n,computers);
    return answer;
}
