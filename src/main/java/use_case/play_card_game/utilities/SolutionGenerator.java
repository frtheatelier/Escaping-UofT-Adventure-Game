package use_case.play_card_game.utilities;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

import entity.Card;
import use_case.validate_card_answer.utilities.Expression24Verifier;

public class SolutionGenerator {
    private static final List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");

    private static final List<ExpressionPattern> PATTERNS = List.of(
            (a, b, c, d, op1, op2, op3) -> "((" + a + op1 + b + ")" + op2 + c + ")" + op3 + d,
            (a, b, c, d, op1, op2, op3) -> "(" + a + op1 + "(" + b + op2 + c + "))" + op3 + d,
            (a, b, c, d, op1, op2, op3) -> "(" + a + op1 + b + ")" + op2 + "(" + c + op3 + d + ")",
            (a, b, c, d, op1, op2, op3) -> a + op1 + "((" + b + op2 + c + ")" + op3 + d + ")",
            (a, b, c, d, op1, op2, op3) -> a + op1 + "(" + b + op2 + "(" + c + op3 + d + "))"
    );

    @FunctionalInterface
    private interface ExpressionPattern {
        String apply(int a, int b, int c, int d, String op1, String op2, String op3);
    }

    public static String getFirstSolution(List<Card> cards) {
        List<Integer> numbers = new ArrayList<>();
        for (Card card : cards) {
            numbers.add(card.getValue());
        }

        for (List<Integer> perm : generatePermutations(numbers)) {
            int a = perm.get(0);
            int b = perm.get(1);
            int c = perm.get(2);
            int d = perm.get(3);

            for (String op1 : OPERATORS) {
                for (String op2 : OPERATORS) {
                    for (String op3 : OPERATORS) {

                        for (ExpressionPattern pattern : PATTERNS) {
                            String expr = pattern.apply(a, b, c, d, op1, op2, op3);

                            if (Expression24Verifier.isValidSolution(expr, cards)) {
                                return expr;
                            }
                        }

                    }
                }
            }
        }

        return "";
    }


    private static List<List<Integer>> generatePermutations(List<Integer> numbers) {
        List<List<Integer>> perms = new ArrayList<>();
        int n = numbers.size();
        if (n == 0) {
            perms.add(new ArrayList<>());
            return perms;
        }
        if (n == 1) {
            perms.add(numbers);
            return perms;
        } else {
            for (int j = 0; j < n; j++) {
                int pivot = numbers.get(j);
                List<Integer> numberSubset = new ArrayList<>();
                numberSubset.addAll(numbers.subList(0, j));
                numberSubset.addAll(numbers.subList(j+1, n));

                List<List<Integer>> permSubset = generatePermutations(numberSubset);
                for (List<Integer> numList : permSubset) {
                    numList.add(pivot);
                    perms.add(numList);
                }
            }

            return perms;
        }
    }
}