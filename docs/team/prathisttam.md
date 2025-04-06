# Manikanda Durairaj Prathistta - Project Portfolio Page

By: Manikanda Durairaj Prathistta (@prathisttam)

## Project: InternSprint

InternSprint is your Ultimate Internship Application Assistant.

Navigating internship applications can be overwhelming - multiple platforms, countless CV versions, and keeping track of
application stages can quickly become chaotic. InternSprint is here to streamline the entire process, acting as your personal
assistant for managing and organizing internship applications efficiently. InternSprint is a CLI application used internship management.

### Summary of Contributions

## Code Contributed:

Check out my contributions to InternSprint at the [TP Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/?search=prathisttam&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2025-02-21&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

## Enhancements implemented 

1. **New feature:** Added the ability to list all internships added.
   [()]()

    * **What it does**: Allows the users to list all internships they have added.
    * **Highlights**: The internships are segregated and displayed according to the three categries of software, hardware and general. The company, role and department of each internship is shown.
    * **Contributions**: Created the `listCommand` class.


2. **New feature:** Added the ability to view the description of any particular internship from the list.
   [()]()

    * **What it does**: Allows users to view the description of any internship based on its index in the list
    * **Highlights**: 
    * **Contributions**: 

3. **New feature:** Added an Interview class that models the concept of an interview.
   [()]()

    * **What it does**: 
    * **Highlights**:
      * Handles both required parameters(date, start time, end time, type) and optional parameters(interviewer email, notes)
      * Supports the creation of multiple interview rounds for a particular internship
    * **Contributions**:
      * Designed the core attributes needed for the interview class 
      * Created constructors to accommodate compulsory and mandatory parameters and handled all possible exceptions across the class.


4. **New feature:** Added the function to sort interviews.
   [()]()

    * **What it does**: It sorts interviews based on the dates and start-timings 
    * **Highlights**: 
      * 
    * **Contributions**:


5. **Additional Enhancement:** Created a centralised logger for the application

   * **What it does**: The centralised logger serves as a single configuration point for all logging throughout the application. As creating multiple logger instances across each classes might lead to unnecessary resource usage, this centralized logger ensures that logging is efficiently managed, reducing overhead.
   * **Highlights**: 
     * Logger uses a singleton approach to configure the logger only once, maintaining consistency throughout application. 
     * Allows user to set the logging threshold and format for console and file handler across the whole application.
   * **Contributions**:
     * I set up dual logging outputs by creating separate consoleHandler and FileHandler. ConsoleHandler is ideal for debugging when log output needs to be seen immediately while fileHandler is essential for persistent storage of logs to later review.
     * I developed proactive file management to ensure the log file and its directories are created automatically if not already preset to prevent runtime errors.

**Contributions to UG:**



**Contributions to DG:**


**Contributions to team-based tasks:**


**Contributions beyond the project team:
**

