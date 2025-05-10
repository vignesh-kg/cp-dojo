/*
 * Leetcode Problem 1768
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

	fmt.Fprintf(bw, mergeAlternately(word1, word2))
	bw.Flush()
}

func mergeAlternately(word1 string, word2 string) string {
	iter := max(len(word1), len(word2))
	var merged_word string

	for i := range iter {
		if i < len(word1) {
			merged_word += string(word1[i])
		}
		if i < len(word2) {
			merged_word += string(word2[i])
		}
	}
	return merged_word
}
