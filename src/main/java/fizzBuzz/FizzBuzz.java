package fizzBuzz;

public class FizzBuzz {

    public static String answer(int number) {
        if (number % 3 ==0 && number % 5 ==0){
            return "FizzBuzz";
        }else if (number % 3 ==0){
            return "Fizz";
        }else if (number % 5 ==0){
            return "Buzz";
        }
        return Integer.toString(number);
    }

    public static String showOutput(int start, int end) {
        StringBuilder output = new StringBuilder();
        for (;start<=end;start++){
            output.append(answer(start));
            output.append("\n");
        }
        return output.toString();
    }

}