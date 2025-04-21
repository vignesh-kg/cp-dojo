/*
 * Codeforces problem 231A. Team
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
	problemSolved := 0
	for i := 0; i < n; i++ {
		line, _ := br.ReadString('\n')
		line = strings.TrimSpace(line)
		confidence := strings.Split(line, " ")
		totalConfidence := 0
		for _, c := range confidence {
			con, _ := strconv.Atoi(c)
			totalConfidence += con
		}
		if totalConfidence >= 2 {
			problemSolved++
		}
	}
	fmt.Fprint(bw, problemSolved)
	bw.Flush()
}
