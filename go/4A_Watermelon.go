/*
 * Codeforces problem 4A. Watermelon
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

func main(){
	input, _ := br.ReadString('\n')
	num,_ := strconv.Atoi(strings.TrimSpace(input))
	if num > 2 && num % 2 == 0{
		fmt.Fprintln(bw, "YES")
	} else {
		fmt.Fprintln(bw, "NO")
	}
	bw.Flush()
}