
package com.example.Microservices.constants;

public final class CustomerConstants {

  private CustomerConstants() {
    // prevent instantiation
  }

  public static final String SUCCESS = "200";
  public static final String CREATED = "201";
  public static final String BAD_REQUEST = "400";
  public static final String NOT_FOUND = "404";
  public static final String CONFLICT = "409";
  public static final String INTERNAL_SERVER_ERROR = "500";

  public static final String CUSTOMER_CREATED = "Customer created successfully";

  public static final String CUSTOMER_FETCHED = "Customer details retrieved successfully";

  public static final String CUSTOMER_UPDATED = "Customer updated successfully";

  public static final String CUSTOMER_DELETED = "Customer deleted successfully";

  public static final String CUSTOMER_NOT_FOUND = "Customer not found";

  public static final String CUSTOMER_ALREADY_EXISTS = "Customer already exists";

  public static final String CUSTOMER_VALIDATION_FAILED = "Customer validation failed";
}
