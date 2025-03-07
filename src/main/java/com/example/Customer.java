package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Customer {
    private final String UUID;
    private Joke joke;

    public Customer(String UUID){
        this.UUID=UUID;
    }

    @Override
    public String toString() {
        return "%s,%s".formatted(UUID,joke.value());
    }

    public void addJoke(ChuckClient chuck){
        joke=chuck.joke();
    }

    public static List<Customer> loadCustomers(String path){

        List<Customer> customers=null;
        Path file = Path.of(path);
        try (Stream<String> lines = Files.lines(file)) {
            customers = lines.map(line -> {
                Customer c = new Customer(line);
                return c;
            }).toList();
        } catch (IOException e) {
            System.out.println("Failed to load the file");
        }
        return customers;
    }

    public static void saveCustomers(List<Customer> customers, String path){

        String header = "UUID,Joke";
        try (PrintWriter writer = new PrintWriter(path)) {
            writer.println(header);
            for(Customer c : customers){
                writer.println(c);
            }
        } catch (IOException e) {
            System.out.println("Failed to save the file");
        }
    }
}
