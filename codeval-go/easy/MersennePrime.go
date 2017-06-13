package main

import "fmt"
import "log"
import (
	"bufio"
	"os"
	"strconv"
	"strings"
)

func main() {

	mersennes := []int{ 3, 7, 31, 127, 2047}

	file, err := os.Open(os.Args[1])
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()
	scanner := bufio.NewScanner(file)

	for scanner.Scan() {
		line := scanner.Text() //' represents the test case, do something with it
		i, err := strconv.Atoi(line)
		if err != nil {
			log.Fatal(err)
		}
		reg := []string {}
		for _,mersenne := range mersennes {
			if i > mersenne {
				reg = append(reg,  strconv.Itoa(mersenne))
			}
		}
		fmt.Println(strings.Join(reg[:],", "))
	}
}