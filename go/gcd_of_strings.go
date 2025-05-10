/*
 * Leetcode Problem 1071
 */

package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	br := bufio.NewReader(os.Stdin)
	bw := bufio.NewWriter(os.Stdout)
	word1, _ := br.ReadString('\n')
	word1 = strings.TrimSpace(word1)
	word2, _ := br.ReadString('\n')
	word2 = strings.TrimSpace(word2)

	fmt.Fprintf(bw, gcdOfStrings(word1, word2))
	bw.Flush()
}

func gcdOfStrings(str1 string, str2 string) string {
	if str1+str2 != str2+str1 {
		return ""
	}
	var gcd func(int, int) int
	gcd = func(i1 int, i2 int) int {
		if i2 == 0 {
			return i1
		}
		return gcd(i2, i1%i2)
	}

	return str1[:gcd(len(str1), len(str2))]
}
