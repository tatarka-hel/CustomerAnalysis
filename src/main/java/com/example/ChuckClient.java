package com.example;


import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;


@Client("chuck")
public interface ChuckClient {
    @Get("/jokes/random")
    Joke joke();
}
