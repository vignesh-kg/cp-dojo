#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        for(int i = 0; i < nums.size(); ++i){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j = i+1; j < nums.size(); ++j){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int k = j +1, l = nums.size()-1;
                while(k < l){
                    long long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum == target){
                        vector<int> quadruplet = {nums[i], nums[j], nums[k], nums[l]};
                        res.push_back(quadruplet);

                        ++k;
                        --l;

                        while(k < l && nums[k] == nums[k-1]) ++k;
                        while(k < l && nums[l] == nums[l+1]) --l;
                    } else if(sum < target) ++k;
                    else --l;
                }
            }
        }
        return res;
    }
};

int main(){
    Solution s;
    vector<int> nums = {1,0,-1,0,-2,2};
    for(vector<int> quadruplet : s.fourSum(nums, 0)){
        for(int index : quadruplet){
            cout << index << ", ";
        }
        cout << endl;
    }

    nums = {1000000000,1000000000,1000000000,1000000000};
    for(vector<int> quadruplet : s.fourSum(nums, 0)){
        for(int index : quadruplet){
            cout << index << ", ";
        }
        cout << endl;
    }
}