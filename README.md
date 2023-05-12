# ResourceCalculator

The Problem:
-------------
Consider a fictional company that manufactures many different final products. We will label these final products f1, f2, f3, and so on. The company also creates a number of intermediate materials, labeled m1, m2, m3, and so on. These intermediate products are required to produce the final products (in various combinations, depending on the product). The company requires the use of a variety of basic materials to produce these intermediate materials. The basic materials will be labeled b1, b2, b3, and so on. The company would like to produce a certain number of each final product, and needs to know how many of each basic resource to purchase to manage this.
The Details:
To make these calculations, we will assume that there are a total of M different basic resources, N different intermediate materials, and P different final products. Thus, the basic resources are b1, b2, ..., bM; the intermediate materials are m1, m2, ..., mN; and the final products are f1, f2, ..., fP. The costs for intermediate materials and final products are defined in two matrices.
The A matrix defines the number of basic resources to produce intermediate materials. In the A matrix, the aij element indicates the number of basic resource bi it requires to produce one copy of intermediate material mj. There are M rows in matrix A, one for each basic resource. There are N columns in matrix A, one for each intermediate material.
Similarly, the B matrix defines the number of intermediate materials to produce final products. In the B matrix, the bij element indicates the number of intermediate material mi it requires to produce one copy of final product fj. There are N rows in matrix B, one for each intermediate material. There are P columns in matrix B, one for each final product.
To determine how many of each basic resource we need to produce each final product, we need to calculate how many basic resources each intermediate material that the final product requires. This can be done using matrix multiplication. A quick reference for matrix multiplication is here (from Wikipedia):
Multiplying A by B will result in an M x P matrix C, which defines how many of each basic resource is required to produce a given final product. If we then multiply the matrix C by a vector V containing the amount of each of the P final products we want to produce (thus, V is a P x 1 vector), we will end up with an M x 1 vector telling us how much of each basic resource we will need.

All the data for a problem will be found in a text file. The text file will be configured in the following way:
- The first line will contain the value of M.
- The second line will contain the value of N.
- The third line will contain the value of P.
- The next M lines will contain N values each, representing the rows of the A matrix.
- The next N lines will contain P values each, representing the rows of the B matrix.
- The next P lines will contain one value each, representing the number of the final product fi the
company wishes to produce.

The Program:
-------------
For this program, you may use any programming language that you wish (if it is something other than Java, C++, or Python, please let me know in advance). Submit your code file(s) via Moodle.
Your program must make some use of concurrency. I am not defining how that is to be implemented, but the matrix multiplication seems to be the obvious choice.
Your program should behave in the following manner:
- Welcome the user to the program.
- Prompt the user to enter a file name containing the data for the problem.
- Open that file (if it does not exists, print an error and exit) and read in the data.
- Print out, one number per line, the number of each basic resource that is required to produce the
number of final products given in the data file.
- Exit the program.
