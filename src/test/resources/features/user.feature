Feature: User
  Scenario Outline: fetch all
    Given find all list
    And find user by id
    Then finally



    Examples:
      |id|address|email|user_name|password|
      |6|ktm|abd761066@gmail.com|aadarsha|abc1234|
