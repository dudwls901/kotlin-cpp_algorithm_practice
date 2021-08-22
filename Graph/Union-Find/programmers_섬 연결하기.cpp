//https://programmers.co.kr/learn/courses/30/lessons/42861
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int getParent(vector<int> &parent, int x){
    if(parent[x]==x) return x;
    return parent[x] = getParent(parent, parent[x]);
}

void unionParent(vector<int> &parent, int a, int b){
    a = getParent(parent, a);
    b = getParent(parent, b);
    if( a<b) parent[b] = a;
    else parent[a] = b;
}

bool findParent(vector<int> &parent, int a, int b){
    a = getParent(parent, a);
    b = getParent(parent, b);
    if(a==b) return 1;
    else return 0;
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
vector<pair<int,pair<int,int>>> vt;
    vector<int> parent;
    for(int i=0; i<n;i++){
        parent.push_back(i);
    }
    for(int i=0; i<costs.size();i++){
        vt.push_back({costs[i][2],{costs[i][0],costs[i][1]}});
    }
    sort(vt.begin(),vt.end());
    for(int i=0; i< vt.size();i++){

      if(!findParent(parent, vt[i].second.first, vt[i].second.second)){
          answer+= vt[i].first;
          unionParent(parent, vt[i].second.first, vt[i].second.second);
      }
    }

    return answer;
}
