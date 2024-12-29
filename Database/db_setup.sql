-- Database creation
CREATE DATABASE ATM_DB;

-- Table for user credentials
USE ATM_DB;
CREATE TABLE Users (
    username VARCHAR(50) PRIMARY KEY,
    password_hash VARCHAR(128) NOT NULL
);

-- Table for account details
CREATE TABLE Accounts (
    username VARCHAR(50),
    balance BIGINT DEFAULT 0,
    FOREIGN KEY (username) REFERENCES Users(username)
);

-- Table for transaction history
CREATE TABLE Transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    timestamp DATETIME,
    description VARCHAR(255),
    FOREIGN KEY (username) REFERENCES Users(username)
);
