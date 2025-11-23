package use_case.play_card_game.utilities;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

import entity.Card;
import use_case.validate_card_answer.utilities.Expression24Verifier;

public class SolutionGenerator {
    private static final List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");

    public static List<String> find24Solutions(List<Card> cards) {
        List<Integer> numbers = new ArrayList<>();
        for (Card card : cards) {
            numbers.add(card.getValue());
        }

        System.out.println("Generating solutions for: " + numbers);

        Set<String> solutions = new HashSet<>();

        List<List<Integer>> perms = generatePermutations(numbers);

        System.out.println("Number of permutations: " + perms.size());

        for (List<Integer> perm : perms) {
            int a = perm.get(0);
            int b = perm.get(1);
            int c = perm.get(2);
            int d = perm.get(3);

            System.out.println("Testing: " + perm);

            for (String op1 : OPERATORS) {
                for (String op2 : OPERATORS) {
                    for (String op3 : OPERATORS) {
                        System.out.println("Ops: " + op1 + op2 + op3);

                        // Test the 5 most common expression patterns for 24 game
                        if (Expression24Verifier.isValidSolution("((" + a + op1 + b + ")" + op2 + c + ")" + op3 + d, cards)) {
                            solutions.add("((" + a + op1 + b + ")" + op2 + c + ")" + op3 + d);
                        }

                        if (Expression24Verifier.isValidSolution("(" + a + op1 + "(" + b + op2 + c + "))" + op3 + d, cards)) {
                            solutions.add("(" + a + op1 + "(" + b + op2 + c + "))" + op3 + d);
                        }

                        if (Expression24Verifier.isValidSolution("(" + a + op1 + b + ")" + op2 + "(" + c + op3 + d + ")", cards)) {
                            solutions.add("(" + a + op1 + b + ")" + op2 + "(" + c + op3 + d + ")");
                        }

                        if (Expression24Verifier.isValidSolution(a + op1 + "((" + b + op2 + c + ")" + op3 + d + ")", cards)) {
                            solutions.add(a + op1 + "((" + b + op2 + c + ")" + op3 + d + ")");
                        }

                        if (Expression24Verifier.isValidSolution(a + op1 + "(" + b + op2 + "(" + c + op3 + d + "))", cards)) {
                            solutions.add(a + op1 + "(" + b + op2 + "(" + c + op3 + d + "))");
                        }
                    }
                }
            }
        }

        return new ArrayList<>(solutions);
    }

    public static String getFirstSolution(List<Card> cards) {
        List<Integer> numbers = new ArrayList<>();
        for (Card card : cards) {
            numbers.add(card.getValue());
        }

        List<List<Integer>> perms = generatePermutations(numbers);

        for (List<Integer> perm : perms) {
            int a = perm.get(0);
            int b = perm.get(1);
            int c = perm.get(2);
            int d = perm.get(3);

            System.out.println("Testing: " + perm);

            for (String op1 : OPERATORS) {
                for (String op2 : OPERATORS) {
                    for (String op3 : OPERATORS) {
                        // Test the 5 most common expression patterns for 24 game
                        if (Expression24Verifier.isValidSolution("((" + a + op1 + b + ")" + op2 + c + ")" + op3 + d, cards)) {
                            return "((" + a + op1 + b + ")" + op2 + c + ")" + op3 + d;
                        }

                        if (Expression24Verifier.isValidSolution("(" + a + op1 + "(" + b + op2 + c + "))" + op3 + d, cards)) {
                            return "(" + a + op1 + "(" + b + op2 + c + "))" + op3 + d;
                        }

                        if (Expression24Verifier.isValidSolution("(" + a + op1 + b + ")" + op2 + "(" + c + op3 + d + ")", cards)) {
                            return "(" + a + op1 + b + ")" + op2 + "(" + c + op3 + d + ")";
                        }

                        if (Expression24Verifier.isValidSolution(a + op1 + "((" + b + op2 + c + ")" + op3 + d + ")", cards)) {
                            return a + op1 + "((" + b + op2 + c + ")" + op3 + d + ")";
                        }

                        if (Expression24Verifier.isValidSolution(a + op1 + "(" + b + op2 + "(" + c + op3 + d + "))", cards)) {
                            return a + op1 + "(" + b + op2 + "(" + c + op3 + d + "))";
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