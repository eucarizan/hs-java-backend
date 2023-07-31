# Size of parts

## Description
A detector compares the size of parts produced by a machine with the reference standard.

If the size is **larger**, it can be sent to be fixed, and the detector prints the number 1.
If the size of the part is **smaller**, it is removed as a reject, and the detector prints the number -1.
If the part is **perfect**, it is sent to the box with products, that are ready to ship, and the detector prints 0.

## Tasks
Write a program, which takes the number of parts _**n**_ as input, and then the sequence _**n**_ detector prints.
The program should count the total number of parts ready to be shipped, the number of parts to be fixed, and the number of rejects.
After that, the program should output these numbers in that order in a single line, separated by blank space (see the example, where _**n=11**_).