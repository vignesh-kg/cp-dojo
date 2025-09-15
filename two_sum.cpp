#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> diff_map;
        for(int i = 0; i < nums.size(); ++i){
          int cur_num = nums[i];
          int diff = target - cur_num;
          if(diff_map.find(diff) != diff_map.end()){
            return {diff_map[diff], i};
          }
          diff_map[cur_num] = i;
        }

        return {-1, -1};
    }
};

int main(){
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    vector<int> nums;
    for(int i = 0; i < 5; ++i){
      int in;
      cin >> in;
      nums.push_back(in);
    }

    Solution s;
    vector<int> indices = s.twoSum(nums, 9);
    for(int i = 0; i < indices.size(); ++i){
      cout << indices[i] << " ";
    }
    cout << "\n";
}