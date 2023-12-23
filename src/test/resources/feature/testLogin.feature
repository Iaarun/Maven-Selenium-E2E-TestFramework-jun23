Feature: Test Ecommerce login feature

Scenario Outline: validate the error message for invalid credential
Given user is at the login page
When user provide invalid <username> and <password>
And user click on login button
Then verify the <errormessage> is displayed


Examples:

| username               |  password    | errormessage                 |
| "abc@test.com"         | "cba@test"   | "Invalid login or password." |
| "cbatest7@gmail.com"   | "cba12@test" | "Invalid login or password1." |