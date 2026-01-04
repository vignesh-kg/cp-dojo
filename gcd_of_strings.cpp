#include <iostream>

using namespace std;

int gcd(int a, int b){
    return b == 0 ? a : gcd(b, a%b);
}

string gcdOfStrings(string str1, string str2)
{
    return (str1 + str2) != (str2 + str1) ? "" :  str1.substr(0, gcd(str1.size(), str2.size()));
}

int main()
{
    cout << gcdOfStrings("ABCABC", "ABC") << "\n";
}