/*
 * Leetcode Problem 1431
 */

package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	br := bufio.NewReader(os.Stdin)
	bw := bufio.NewWriter(os.Stdout)
	candy_string, _ := br.ReadString('\n')
	candy_string = strings.TrimSpace(candy_string)
	candy_string_arr := strings.Split(candy_string, " ")
	candy := make([]int, len(candy_string_arr))

	for i, val := range candy_string_arr {
		c, _ := strconv.Atoi(val)
		candy[i] = c
	}

	extracandy_string, _ := br.ReadString('\n')
	extracandy_string = strings.TrimSpace(extracandy_string)
	extracandy, _ := strconv.Atoi(extracandy_string)

	fmt.Fprintln(bw, kidsWithCandies(candy, extracandy))
	bw.Flush()
}

func kidsWithCandies(candies []int, extraCandies int) []bool {

	maximumCandy := 0
	for _, candy := range candies {
		maximumCandy = max(maximumCandy, candy)
	}
	res := make([]bool, len(candies))
	for i, candy := range candies {
		if candy+extraCandies >= maximumCandy {
			res[i] = true
		}
	}
	return res
}
