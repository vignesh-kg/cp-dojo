#include <iostream>
#include <string>

using namespace std;

string mergeAlternately(string word1, string word2) {
    string new_string = "";
    int i = 0, j = 0;
    while(i < word1.length() || j < word2.length()){
        if(i < word1.length()){
            new_string += word1[i++];
        }
        if(j < word2.length()){
            new_string += word2[j++];
        }
    }
    return new_string;
}

int main(){
    cout << mergeAlternately("abc", "pqrs") << "\n";
}