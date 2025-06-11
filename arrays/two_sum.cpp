#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> twoSum(vector<int> &nums, int target);

int main()
{
  vector<int> nums = {2, 7, 11, 19};
  for (int index : twoSum(nums, 9))
  {
    cout << index << " ";
  }
  cout << endl;
}

vector<int> twoSum(vector<int> &nums, int target)
{
  unordered_map<int, int> diff_map;
  for (int i = 0; i < nums.size(); ++i)
  {
    int cur_num = nums[i];
    int diff = target - cur_num;
    if (diff_map.find(diff) != diff_map.end())
    {
      return {diff_map[diff], i};
    }
    diff_map[cur_num] = i;
  }
  return {-1, -1};
}