package main

import "fmt"

func main(){
	fmt.Println(gcdOfStrings("ABCABC", "ABC"))
}

func gcdOfStrings(str1 string, str2 string) string {
  
	if str1 + str2 != str2+str1{
		return ""
	}

	var gcd func(a int, b int) int  
	gcd = func(a int, b int) int{
			if(b != 0){
				return gcd(b, a%b)
			}
			return a
		}

	return str1[:gcd(len(str1), len(str2))]
}