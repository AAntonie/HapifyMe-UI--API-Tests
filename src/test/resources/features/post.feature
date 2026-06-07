Feature: Create post on feed

  Scenario: User creates a new post successfully
    Given user is logged in
    And user is on feed page
    When user creates a post with text "Hello automation world"
    Then post "Hello automation world" should appear on the feed

