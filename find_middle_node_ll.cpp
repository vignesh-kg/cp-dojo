#include<iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* middleNode(ListNode* head) {
    ListNode* slow = head;
    ListNode* fast = head;
    while(fast != nullptr && fast->next != nullptr){
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
}

int main(){
    ListNode* ll = new ListNode(1, new ListNode(2, new ListNode(3, nullptr)));
    ListNode* mid = middleNode(ll);
    while(mid != nullptr){
        cout << mid->val << "->";
        mid = mid->next;
    }
    cout << "\n";
}