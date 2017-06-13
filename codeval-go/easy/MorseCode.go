package main

import "fmt"
import "log"
import "bufio"
import "os"
import "strings"

func main() {

	converter := map[string]string{
		".-": "A",
		"-...": "B",
		"-.-.": "C",
		"-..": "D",
		".": "E",
		"..-.": "F",
		"--.": "G",
		"....": "H",
		"..": "I",
		".---": "J",
		"-.-": "K",
		".-..": "L",
		"--": "M",
		"-.": "N",
		"---": "O",
		".--.": "P",
		"--.-": "Q",
		".-.": "R",
		"...": "S",
		"-": "T",
		"..-": "U",
		"...-": "V",
		".--": "W",
		"-..-": "X",
		"-.--": "Y",
		"--..": "Z",
		".----": "1",
		"..---": "2",
		"...--": "3",
		"....-": "4",
		".....": "5",
		"-....": "6",
		"--...": "7",
		"---..": "8",
		"----.": "9",
		"-----": "0",
	}

	file, err := os.Open(os.Args[1])
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()
	scanner := bufio.NewScanner(file)

	for scanner.Scan() {
		line := scanner.Text() //' represents the test case, do something with it
		result := strings.Split(line, " ")

		for i := range result {
			if result[i] == "" {
				fmt.Print(" ")
			} else {
				fmt.Print(converter[result[i]])
			}
		}
		fmt.Println("")
	}
}