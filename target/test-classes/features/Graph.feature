@Graph
Feature: Graph

  @GraphFlow1
  Scenario: Graph Flow - Graph
    Given The user is in the Home page after logged in
    When The user clicks on Graph Get Started button
    Then The user should be directed to "Graph" Page
    When The user clicks "Graph" link
    Then The user should be directed to "GraphIntro" Page
    When The user clicks "Try Here" button
    Then The user should be redirected to a page having an tryEditor with a Run button to test
    When The user enters Wrong Python code in the tryEditor and clicks on Run button
    Then It throws an Alert
    When The user enters Valid Python code in the tryEditor and clicks on Run button
    Then The Output displays in Console
    When The user clicks on the "Sign out"

  @GraphFlow2
  Scenario: Graph Flow - Graph Representations
    Given The user is in the Home page after logged in
    When The user clicks on Graph Get Started button
    Then The user should be directed to "Graph" Page
    When The user clicks "Graph Representations" link
    Then The user should be directed to "Graph Representations" Page
    When The user clicks "Try Here" button
    Then The user should be redirected to a page having an tryEditor with a Run button to test
    When The user enters Wrong Python code in the tryEditor and clicks on Run button
    Then It throws an Alert
    When The user enters Valid Python code in the tryEditor and clicks on Run button
    Then The Output displays in Console
    When The user clicks on the "Sign out"

  @GraphFlow3
  Scenario: Graph Flow - Graph Practice
    Given The user is in the Home page after logged in
    When The user clicks on Graph Get Started button
    Then The user should be directed to "Graph" Page
    When The user clicks "Graph Representations" link
    Then The user should be directed to "Graph Representations" Page
    When The user clicks Graph Practice Questions link
    Then The user should be redirected to "Practice" page
    When The user clicks on the "Sign out"
