public class Main {
    public static void main(String[] args) {
        String[] input = "The lambda has too many string arguments.".split(" ");
        System.out.println(Seven.fun.apply(
                input[0],
                input[1],
                input[2],
                input[3],
                input[4],
                input[5],
                input[6]
        ));
    }
}

class Seven {
    public static SeptenaryStringFunction fun =
            (s1, s2, s3, s4, s5, s6, s7) -> (s1 + s2 + s3 + s4 + s5 + s6 + s7).toUpperCase();
}

@FunctionalInterface
interface SeptenaryStringFunction {
    String apply(String s1, String s2, String s3, String s4, String s5, String s6, String s7);
}