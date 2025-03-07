package com.example;

import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.List;

@Command(name = "CustomerAnalysis", description = "...",
        mixinStandardHelpOptions = true)
public class CustomerAnalysisCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    @Inject
    ChuckClient chuck;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(CustomerAnalysisCommand.class, args);


    }

    public void run() {
        // business logic here

        List<Customer> customers = Customer.loadCustomers("input.csv");
        for (Customer customer : customers) {
            customer.addJoke(chuck);
        }
        customers.stream().forEach(System.out::println);

        Customer.saveCustomers(customers,"output.csv");
    }
}
