# StockMarketSimulator
A stock market simulator application (and much more) designed and built for my Web Services course at SUNY Oswego in collaboration with fellow student Stephen DiCerce.

To run the application, you must have MySQL running on port 3306 of the same machine, the calls use localhost. Once MySQL is installed, and in your path, enter into the command prompt:
```
    mysql -u root -p
    CREATE DATABASE stocksim;
    USE stocksim;
    CREATE TABLE Users (
        name VARCHAR(40),
        password VARCHAR(40),
        money DOUBLE PRECISION,
        PRIMARY KEY (name)
    );
    CREATE TABLE Companies (
        name VARCHAR(40),
        symbol VARCHAR(10),
        stockValue DOUBLE PRECISION,
        availableStocks INT,
        PRIMARY KEY (symbol)
    );
    CREATE TABLE Stocks (
        user VARCHAR(40),
        company VARCHAR(40),
        number INT,
        averagePrice DOUBLE PRECISION,
        PRIMARY KEY (user, company)
    );
    GRANT ALL ON stocksim.* TO 'stocksimuser' IDENTIFIED BY 'stocksimpassword';
    INSERT INTO Companies VALUES('Advanced Micro Devices', 'AMD', 50, 100);
    INSERT INTO Companies VALUES('Allstate', 'ALL', 50, 100);
    INSERT INTO Companies VALUES('American Express', 'AXP', 50, 100);
    INSERT INTO Companies VALUES('Apple Inc.', 'AAPL', 50, 100);
    INSERT INTO Companies VALUES('Bitcoin', 'NYXBT', 50, 100);
    INSERT INTO Companies VALUES('Google', 'GOOG', 50, 100);
    INSERT INTO Companies VALUES('Intel Corporation', 'INTC', 50, 100);
    INSERT INTO Companies VALUES('McDonalds', 'MCD', 50, 100);
    INSERT INTO Companies VALUES('Microsoft', 'MSFT', 50, 100);
    INSERT INTO Companies VALUES('Ninetndo Co.', 'NTDOY', 50, 100);
    INSERT INTO Companies VALUES('Snapchat', 'SNAP', 50, 100);
    INSERT INTO Companies VALUES('Yahoo', 'YHOO', 50, 100);
    
```

Once the SQL database has been set up, run the application.

Stock prices are pulled from the google finance api.

To recompile the code, be sure to include each jar in the class path, and compile all the java files at the same time, so that each package can be seen by the others.
