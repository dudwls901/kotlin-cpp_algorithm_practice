//https://programmers.co.kr/learn/courses/30/lessons/17684
import java.util.*;
class Solution {

    HashMap<String,Integer> map = new HashMap();

    public int[] solution(String msg) {
        //preset
        int idx = 1;
        for(; idx<= 26; idx++){
            map.put(String.valueOf((char)('A'+idx-1)),idx);
        }
        //solve
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i< msg.length(); i++){
            Integer output = map.get(msg.substring(i,i+1));
            boolean isAdded = false;
            int j=i+1;
            for(; j<=msg.length(); j++){
                String word = msg.substring(i,j);
                Integer num = map.get(word);
                //단어 추가
                if(num==null){
                    isAdded = true;
                    i += j-i-2; //현재 검사한 단어 길이만큼 스킵
                    map.put(word,idx++);
                    break;
                }
                output = num;
            }
            if(!isAdded){
                i += j-i-2;//현재 검사한 단어 길이만큼 스킵
            }
            if(output!=null) {
                arr.add(output);
            }
        }
        //output
        int[] answer = new int[arr.size()];
        for(int i=0; i< answer.length; i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
