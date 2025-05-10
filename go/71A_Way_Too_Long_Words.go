/*
 * Codeforces problem 71A. Way Too Long Words
 */

package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var br *bufio.Reader
var bw *bufio.Writer

func init() {
	br = bufio.NewReader(os.Stdin)
	bw = bufio.NewWriter(os.Stdout)
	defer bw.Flush()
}

func main() {
	in, _ := br.ReadString('\n')
	n, _ := strconv.Atoi(strings.TrimSpace(in))
	for i := 0; i < n; i++ {
		line, _ := br.ReadString('\n')
		word := strings.TrimSpace(line)
		word_len := len(word)
		if word_len > 10 {
			fmt.Fprintf(bw, "%c%d%c\n", word[0], word_len-2, word[word_len-1])
		} else {
			fmt.Fprintln(bw, word)
		}
	}
	bw.Flush()
}
