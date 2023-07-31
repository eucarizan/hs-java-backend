import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfCompany = scanner.nextInt();
            int[] companyIncome = IntStream
                    .range(0, numberOfCompany)
                    .map(i -> scanner.nextInt())
                    .toArray();
            int[] companyTax = IntStream
                    .range(0, numberOfCompany)
                    .map(i -> scanner.nextInt())
                    .toArray();
            double mostTaxPayed = 0;
            int index = 0;
            final double oneHundred = 100.0;
            final int addOne = 1;
    
            for (int i = 0; i < numberOfCompany; i++) {
                double payment = companyIncome[i] * (companyTax[i] / oneHundred);
                if (payment > mostTaxPayed) {
                    mostTaxPayed = payment;
                    index = i;
                }
            }
    
            System.out.println(index + addOne);
        }
    }
}
/*
2
50 100
10 10
output: 2

1
1
1
output: 1

3
50 100 300
100 20 0
output: 1
 */