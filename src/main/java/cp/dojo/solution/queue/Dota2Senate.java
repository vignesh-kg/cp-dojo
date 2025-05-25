package cp.dojo.solution.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dota2Senate {
  public String predictPartyVictory(String senate) {
    Deque<Integer> radiant = new ArrayDeque<>();
    Deque<Integer> dire = new ArrayDeque<>();
    char[] senateArr = senate.toCharArray();
    for(int i = 0; i < senateArr.length; i += 1){
      if(senateArr[i] == 'R'){
        radiant.offer(i);
      } else {
        dire.offer(i);
      }
    }
    int nextIndex = senateArr.length;
    while(!radiant.isEmpty() && !dire.isEmpty()){
      /*
       * Ex: In Round 1, Radient participates first and bans dire
       * Radient moves to next round
       * else Dire moves to next round
       */
      if(radiant.peek() < dire.peek()){
        radiant.offer(++nextIndex);
      } else {
        dire.offer(++nextIndex);
      }
      radiant.poll();
      dire.poll();
    }
    return radiant.isEmpty() ? "Dire" : "Radiant";
  }

  public static void main(String[] args){
    Dota2Senate s = new Dota2Senate();
    System.out.println(s.predictPartyVictory("RDD"));
  }
}
