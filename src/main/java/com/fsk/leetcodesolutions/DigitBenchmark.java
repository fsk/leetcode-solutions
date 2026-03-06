package com.fsk.leetcodesolutions;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Fork(1)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class DigitBenchmark {

    private int number;

    @Setup(Level.Invocation)
    public void setup() {
        number = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
    }

    @Benchmark
    public int whileDivision() {
        return digitCount1(number);
    }

    @Benchmark
    public int log10Method() {
        return digitCount2(number);
    }

    public static int digitCount1(int number) {
        int count = 0;
        while (number > 0) {
            number = number / 10;
            count++;
        }
        return count;
    }

    public static int digitCount2(int number) {
        return (int) Math.log10(number) + 1;
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(DigitBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}