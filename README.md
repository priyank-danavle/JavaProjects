# VaultEase

VaultEase is a secure, efficient, and user-friendly ATM application developed in Java. It provides essential ATM functionalities such as login authentication, transaction history, money withdrawal, deposit, and transfers. The application uses MySQL for database operations to ensure robustness and scalability.

## Features
- **Login Authentication**: Secure login using SHA-512 hashed passwords.
- **Transaction History**: View all previous account transactions.
- **Withdrawal**: Withdraw money from your account.
- **Deposit**: Deposit money into your account.
- **Money Transfer**: Transfer funds to another user seamlessly.

## File Structure
```
VaultEase/
├── database/
│   └── atm_db_setup.sql
├── src/
│       ├── Authentication.java
│       ├── DatabaseConnection.java
│       ├── TransactionHistory.java
│       ├── Withdraw.java
│       ├── Deposit.java
│       ├── Transfer.java
│       └── Main.java
└── README.md
```

## Prerequisites
1. **Java Development Kit (JDK)**: Ensure JDK 8 or above is installed.
2. **MySQL Server**: Install MySQL and ensure the server is running.
3. **MySQL Connector/J**: Download the MySQL JDBC driver (`mysql-connector-java-<version>.jar`).

## Setup Instructions

### 1. Database Setup
1. Create the database and tables using the provided SQL script:
   ```bash
   mysql -u <username> -p < database < database/atm_db_setup.sql
   ```
2. Populate dummy values into the database as needed (see the SQL script for details).

### 2. Environment Configuration
1. Place the MySQL Connector/J JAR file in a known directory.
2. Add the JAR file to your system's CLASSPATH:
   - **Windows**:
     1. Open System Properties > Advanced > Environment Variables.
     2. In the "System Variables" section, find or create a variable named `CLASSPATH`.
     3. Add the full path to the `mysql-connector-java-<version>.jar`, followed by `.;` for including the current directory.
   - **Linux/Mac**:
     1. Open a terminal and edit the shell configuration file (e.g., `.bashrc`, `.zshrc`).
     2. Add the line:
        ```bash
        export CLASSPATH=/path/to/mysql-connector-java-<version>.jar:.
        ```
     3. Save and reload the configuration using `source .bashrc` or equivalent.

### 3. Running the Application
1. Navigate to the `src/` directory:
   ```bash
   cd VaultEase/src
   ```
2. Compile all Java files:
   ```bash
   javac *.java
   ```
3. Run the application:
   ```bash
   java Main
   ```

## Usage
1. **Login**: Enter your username and password to authenticate.
2. **Operations**:
   - View transaction history.
   - Withdraw money.
   - Deposit money.
   - Transfer money to another account.
3. **Exit**: Quit the application at any time by selecting the exit option.

## Troubleshooting
- **`No suitable driver found` Error**:
  Ensure the MySQL JDBC driver is correctly added to the CLASSPATH.
- **Database Connection Issues**:
  Verify MySQL server credentials and ensure the database is set up correctly.
- **Compilation Errors**:
  Check if all required Java files are in the `src/` directory and properly imported.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

## License
This project is licensed under the MIT License.
