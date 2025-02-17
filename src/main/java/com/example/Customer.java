package com.example;

public class Customer {
    private final String UUID;
    private String data;
    private boolean isProcessed;

    public Customer(String UUID){
        this.UUID=UUID;
        this.isProcessed=false;
    }

    @Override
    public String toString() {
        return "%s,%s".formatted(UUID,data);
    }

    public void process(){
        data = "Analysis output";
        isProcessed=true;
    }
}
