#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> seen;
        int diff;
        for(int i = 0; i < size(nums); ++i){
          int val = nums[i];
          diff = target - val;
          if(seen.find(diff) != seen.end()){
            return {seen[diff], i};
          }
          seen[val] = i;
        }
        return {-1, -1};
    }
};

int main(){
  vector<int> nums = {2,7,11,15};
  Solution s;
  vector<int> result = s.twoSum(nums, 22);
  for(int i = 0; i < size(result); ++i){
    cout << result[i] << " ";
  }
  cout << "\n";
}