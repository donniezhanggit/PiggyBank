Feature: BankApp - Deposit amounts into the bank

  Scenario Outline:
    Given an empty bank account
    When I deposit <deposit>
    Then my balance is now <balance>
    Examples:
      | deposit | balance |
      | 10      | 10      |
      | 50      | 50      |