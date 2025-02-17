package com.example;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Command(name = "CustomerAnalysis", description = "...",
        mixinStandardHelpOptions = true)
public class CustomerAnalysisCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(CustomerAnalysisCommand.class, args);

        List<Customer> customers = null;

        //process input
        Path file = Path.of("input.csv");
        try (Stream<String> lines = Files.lines(file)) {
            customers = lines.map(line -> {
                Customer c = new Customer(line);
                c.process();
                return c;
            }).toList();
        } catch (IOException e) {
            System.out.println("Failed to load the input");
        }


        System.out.println(customers);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
