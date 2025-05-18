package cp.dojo.solution.prefixsum;

public class HighestAltitude {
  public static void main(String[] args){
    HighestAltitude s = new HighestAltitude();
    System.out.println(s.largestAltitude(new int[]{-5,1,5,0,-7}));
  }

  public int largestAltitude(int[] gains) {
    int highestAltitude = 0, curAltitude = 0;
    for(int gain : gains){
      curAltitude += gain;
      if(highestAltitude < curAltitude){
        highestAltitude = curAltitude;
      }
    }
    return highestAltitude;
  }
}
