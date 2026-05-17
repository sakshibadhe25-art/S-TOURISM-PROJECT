-- 1. Create a new container (Database) for your project
CREATE DATABASE tourism_db;

-- 2. Select this database so all future commands apply to it
USE tourism_db;

-- 3. Create the 'Users' table to store login info
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- Unique ID for every user (1, 2, 3...)
    name VARCHAR(100) NOT NULL,         -- User's full name
    email VARCHAR(100) UNIQUE NOT NULL, -- Email must be unique (no duplicates)
    password VARCHAR(255) NOT NULL      -- User's password
);

-- 4. Create the 'Bookings' table to store ticket info
CREATE TABLE bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_email VARCHAR(100),            -- Links booking to a specific user
    package_name VARCHAR(100),          -- e.g., "Pune Tour"
    travel_date DATE,
    people INT,
    price_per_person DOUBLE,
    total_amount DOUBLE,
    FOREIGN KEY (user_email) REFERENCES users(email) -- Ensures booking belongs to a real user
);