package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Joke(String value) {
}
