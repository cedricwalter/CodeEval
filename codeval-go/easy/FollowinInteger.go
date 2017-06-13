package main
/**
CHALLENGE DESCRIPTION:

Credits: This challenge has appeared in a past google competition

You are writing out a list of numbers.Your list contains all numbers with exactly Di digits in its decimal representation which are equal to i, for each i between 1 and 9, inclusive. You are writing them out in ascending order. For example, you might be writing every number with two '1's and one '5'. Your list would begin 115, 151, 511, 1015, 1051. Given N, the last number you wrote, compute what the next number in the list will be. The number of 1s, 2s, ..., 9s is fixed but the number of 0s is arbitrary.

INPUT SAMPLE:

Your program should accept as its first argument a path to a filename. Each line in this file is one test case. Each test case will contain an integer n < 10^6. E.g.

https://www.codeeval.com/open_challenges/44/

 */
import (
	"bufio"
	"fmt"
	"log"
	"os"
)

func decimalRepresentation(a int) (r int) {
	for a > 0 {
		if a%10 > 0 {
			r += 1 << uint(3*(a%10))
		}
		a /= 10
	}
	return r
}

func nextNumber(d int) int {
	nextNumber := d + 9
	for ds := decimalRepresentation(d); decimalRepresentation(nextNumber) != ds; nextNumber += 9 {
	}
	return nextNumber
}

func main() {
	var d int
	data, err := os.Open(os.Args[1])
	if err != nil {
		log.Fatal(err)
	}
	defer data.Close()

	scanner := bufio.NewScanner(data)
	for scanner.Scan() {
		fmt.Sscan(scanner.Text(), &d)
		fmt.Println(nextNumber(d))
	}
}