package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dice {

    private static class Combinations {
        private boolean allowRepetitions;
        private int[] repetitions;
        private List<Integer> numbers;
        private Integer target;
        private Integer sum;
        private boolean hasNext;
        private Set<String> combinations;

        /**
         * Constructor.
         *
         * @param numbers Numbers that can be used to calculate the sum.
         * @param target  Target value for sum.
         */
        public Combinations(List<Integer> numbers, Integer target) {
            this(numbers, target, true);
        }

        /**
         * Constructor.
         *
         * @param numbers Numbers that can be used to calculate the sum.
         * @param target  Target value for sum.
         */
        public Combinations(List<Integer> numbers, Integer target, boolean allowRepetitions) {
            this.allowRepetitions = allowRepetitions;
            if (this.allowRepetitions) {
                Set<Integer> numbersSet = new HashSet<>(numbers);
                this.numbers = new ArrayList<>(numbersSet);
            } else {
                this.numbers = numbers;
            }
            this.numbers.removeAll(Arrays.asList(0));
            Collections.sort(this.numbers);

            this.target = target;
            this.repetitions = new int[this.numbers.size()];
            this.combinations = new LinkedHashSet<>();

            this.sum = 0;
            if (this.repetitions.length > 0)
                this.hasNext = true;
            else
                this.hasNext = false;
        }

        /**
         * Calculate and return the sum of the current combination.
         *
         * @return The sum.
         */
        private Integer calculateSum() {
            this.sum = 0;
            for (int i = 0; i < repetitions.length; ++i) {
                this.sum += repetitions[i] * numbers.get(i);
            }
            return this.sum;
        }

        /**
         * Redistribute picks when only one of each number is allowed in the sum.
         */
        private void redistribute() {
            for (int i = 1; i < this.repetitions.length; ++i) {
                if (this.repetitions[i - 1] > 1) {
                    this.repetitions[i - 1] = 0;
                    this.repetitions[i] += 1;
                }
            }
            if (this.repetitions[this.repetitions.length - 1] > 1)
                this.repetitions[this.repetitions.length - 1] = 0;
        }

        /**
         * Get the sum of the next combination. When 0 is returned, there's no other
         * combinations to check.
         *
         * @return The sum.
         */
        private Integer next() {
            if (this.hasNext && this.repetitions.length > 0) {
                this.repetitions[0] += 1;
                if (!this.allowRepetitions)
                    this.redistribute();
                this.calculateSum();

                for (int i = 0; i < this.repetitions.length && this.sum != 0; ++i) {
                    if (this.sum > this.target) {
                        this.repetitions[i] = 0;
                        if (i + 1 < this.repetitions.length) {
                            this.repetitions[i + 1] += 1;
                            if (!this.allowRepetitions)
                                this.redistribute();
                        }
                        this.calculateSum();
                    }
                }

                if (this.sum.compareTo(0) == 0)
                    this.hasNext = false;
            }
            return this.sum;
        }

        /**
         * Calculate all combinations whose sum equals target.
         */
        public void calculateCombinations() {
            while (this.hasNext) {
                if (this.next().compareTo(target) == 0)
                    this.combinations.add(this.toString());
            }
        }

        /**
         * Return all combinations whose sum equals target.
         *
         * @return Combinations as a set of strings.
         */
        public Set<String> getCombinations() {
            return this.combinations;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("" + sum + ": ");
            for (int i = 0; i < repetitions.length; ++i) {
                for (int j = 0; j < repetitions[i]; ++j) {
                    stringBuilder.append(numbers.get(i) + " ");
                }
            }
            return stringBuilder.toString();
        }

    }

    public int[] solution(int[] A, int F, int M) {
        // write your code in Java SE 8
        int result = M * (A.length + F);
        int subtotal = Arrays.stream(A).reduce(0, (acc, n) -> acc += n);
        int sum = result - subtotal;

       List<Integer> numbers = IntStream.range(0, result).boxed().collect(Collectors.toList());

        Combinations c = new Combinations(numbers, sum);
        c.calculateCombinations();
        java.util.Set<String> combinations = c.getCombinations();

        System.out.println(combinations);

        // the sum of F times = product
        // list of mdc ?

        return A;

    }

    public static void main(String[] args) {
        System.out.println(new Dice().solution(new int[] { 1, 5, 6 }, 4, 3));

    }
}