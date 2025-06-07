#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> twoSum(vector<int>& nums, int target);

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int size;
    cin >> size;

    vector<int> nums(size);
    for(int i = 0; i < size; ++i){
        cin >> nums[i];
    }
    int target;
    cin >> target;
    vector<int> res = twoSum(nums, target);
    for(int i =0; i < res.size(); ++i){
        cout << res[i] << " ";
    }
    cout << endl;
}

vector<int> twoSum(vector<int>& nums, int target) {
    /*
     * we use a hash map to store already seen 
     * target - nums[i] and it's Index.
     * 
     * If hashmap has the difference that we are looking for
     * return {diff_map[diff], i}
    */
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