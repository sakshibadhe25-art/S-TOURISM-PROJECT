-- Step 1: Delete all bookings for the specific user first
-- DELETE FROM bookings WHERE user_email = 'abc@gmail.com';

-- DELETE FROM bookings WHERE user_email = 'ad@gmail.com' and booking_date IS NULL;

-- Step 2: Delete the user account
-- DELETE FROM users WHERE email = 'abc@gmail.com';