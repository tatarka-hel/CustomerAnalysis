package com.example;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.List;

@Command(name = "CustomerAnalysis", description = "...",
        mixinStandardHelpOptions = true)
public class CustomerAnalysisCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(CustomerAnalysisCommand.class, args);

        List<Customer> customers = Customer.loadCustomers("input.csv");
        System.out.println(customers);

        Customer.saveCustomers(customers,"output.csv");
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
