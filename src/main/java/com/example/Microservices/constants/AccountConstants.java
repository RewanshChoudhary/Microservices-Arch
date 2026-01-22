package com.example.Microservices.constants;

public class AccountConstants{
    private AccountConstants() {

    }

    public static final String SUCCESS = "200";
    public static final String CREATED = "201";
    public static final String BAD_REQUEST = "400";
    public static final String NOT_FOUND = "404";
    public static final String CONFLICT = "409";
    public static final String INTERNAL_SERVER_ERROR = "500";
    public static final String ACCOUNT_CREATED =
            "Account created successfully";

    public static final String ACCOUNT_FETCHED =
            "Account details retrieved successfully";

    public static final String ACCOUNT_UPDATED =
            "Account updated successfully";

    public static final String ACCOUNT_DELETED =
            "Account deleted successfully";

    public static final String ACCOUNT_NOT_FOUND =
            "Account not found";

    public static final String ACCOUNT_ALREADY_EXISTS =
            "Account already exists for the customer";
}
