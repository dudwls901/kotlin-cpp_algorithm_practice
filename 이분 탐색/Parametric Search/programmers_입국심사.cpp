//https://programmers.co.kr/learn/courses/30/lessons/43238
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;
//기다리는 사람 n
//심사관 수 times.size()

unsigned long long answer;

bool check(unsigned long long mid,unsigned long long n, vector<int> &times){
   unsigned long long cnt=0;
    for(int i=0;i < times.size();i++){
        cnt+=mid/times[i];
    }
    return cnt >=n ? true : false;
}

void biSearch(unsigned long long start, unsigned long long end, unsigned long long n, vector<int> &times){
    if(start>=end){
        return;
    }
    unsigned long long mid = (start+end)/2;
    
    if(check(mid,n,times)){
        answer = min(answer,mid);
        biSearch(start,mid,n,times);
    }
    else{
        biSearch(mid+1,end,n,times);
    }
}

long long solution(int n, vector<int> times) {
    
    sort(times.begin(),times.end());
    
    unsigned long long start = 1;
    unsigned long long end = times[times.size()-1]*n+1;
    answer = end;
    biSearch(start,end,n,times);
    return answer;
}
