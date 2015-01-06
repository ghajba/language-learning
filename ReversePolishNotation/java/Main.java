public class Main {
    public static void main(String... args) {
        if(args.length == 0) {
            System.out.println("At least one formula has to be provided.");
            System.exit(-1);
        }
        for(String arg : args) {
            double result = ReversePolishCalculator.calculatePolishNotation(arg);
            System.out.printf("The result of the formula \"%s\" is: %.2f\n", arg, result);
        }
    }
}
