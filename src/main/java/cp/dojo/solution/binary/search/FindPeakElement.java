package cp.dojo.solution.binary.search;

public class FindPeakElement {
  public static void main(String[] args) {
    FindPeakElement s = new FindPeakElement();
    System.out.println(s.findPeakElement(new int[]{1, 2, 3, 1}));
    System.out.println(s.findPeakElement(new int[]{2, 1}));
    System.out.println(s.findPeakElement(new int[]{6,5,4,3,2,3,2}));
  }

  public int findPeakElement(int[] nums) {
    if (nums.length <= 1) {
      return 0;
    }
    if (nums.length == 2) {
      return nums[0] > nums[1] ? 0 : 1;
    }
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
        return mid;
      } else if (mid != 0 && nums[mid - 1] > nums[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }
}
