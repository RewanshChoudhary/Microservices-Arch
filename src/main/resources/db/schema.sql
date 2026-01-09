CREATE TABLE customers (
    customer_id     BIGSERIAL PRIMARY KEY,
    customer_name   VARCHAR(255) NOT NULL,
    customer_email  VARCHAR(255) NOT NULL UNIQUE,
    mobile_number   VARCHAR(20)  NOT NULL,

    created_at      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by      VARCHAR(100),
    updated_at      TIMESTAMP,
    updated_by      VARCHAR(100)
);
CREATE TABLE accounts (
    account_number  BIGINT PRIMARY KEY,
    customer_id     BIGINT NOT NULL,
    account_type    VARCHAR(50) NOT NULL,
    branch_address  VARCHAR(255),

    created_at      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by      VARCHAR(100),
    updated_at      TIMESTAMP,
    updated_by      VARCHAR(100),

    CONSTRAINT fk_accounts_customer
        FOREIGN KEY (customer_id)
        REFERENCES customers (customer_id)
        ON DELETE CASCADE
);
CREATE INDEX idx_accounts_customer_id
    ON accounts(customer_id);

CREATE INDEX idx_customers_email
    ON customers(customer_email);

