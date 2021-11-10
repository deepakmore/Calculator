package com.tech.app.validations.exceptions;

public class AlphabetOrSpecialSymbolsNotSupportedException extends RuntimeException {
    public AlphabetOrSpecialSymbolsNotSupportedException() {
        super("Invalid Expression - Found Alphabet or Special Symbol");
    }
}
