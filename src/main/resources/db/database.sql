TRUNCATE Customer;
TRUNCATE Wallet;

INSERT INTO wallet(id, account_number, balance)
VALUES (100, '1234567890', 1000);

INSERT INTO customer (id, email, full_name, password, phone_number)
VALUES (1, 'john.doe@example.com', 'John Doe', 'password123', '123-456-7890');