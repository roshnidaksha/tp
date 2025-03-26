# InternSprint Developer Guide

## Table of Contents

<!-- TOC -->
* [Acknowledgements](#acknowledgements)

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Architecture

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### CommandParser

_Input Parsing:_ The `CommandParser` class takes a single line of user input and splits it into a command word and 
key value pairs. 
  * The command word is used to determine the type of command that needs be executed, and creates the corresponding
`Command` object (e.g., `AddCommand`, `DeleteCommand`, `ListCommand`).
  * The key value pairs are stored in a `HashMap<String, String>` of the `Command` object. The key value pairs are 
validated only during command execution in `isValidParameters()` method.

Here is the partial class diagram of the `CommandParser` class. The multiplicities of `*command` classes are 0 or 1, 
because the dependency is formed only when the command is executed.

Insert command class diagram here

## Implementation

### Commands

The `Command` class is an abstract class that represents a command that the user can execute.
It provides an additional layer of abstraction between the user input and the actual execution of the command,
achieving the **SoC (Separation of Concerns)** design principle.

The partial class structure of the `Command` class is shown below:

Insert command class diagram here

The abstract `Command` class has the following abstract methods:
* `isValidParameters()`: Validates the parameters of the command.
* `execute(InternshipList internships, UserProfile user)`: Executes the command.

### 1. Add new Internship

**Overview**:

This command allows the user to add a new internship to the list of internships. The new internship is immediately added
to the `internships.txt` file at `../data/internships.txt`.

**How the feature is implemented:**

* The `AddCommand` class is an abstract class extends from the abstract class `Command`.
* The user can specify the type of internship as `general`, `software` or `hardware` as input.
Each type of internship has a separate class that extends the `AddCommand` class, 
`AddGeneralCommand`, `AddSoftwareCommand`, and `AddHardwareCommand`.
* These subclasses override the `isValidParameters()` and `execute()` methods to validate the parameters of the command,
depending on the type of internship.
* The `execute()` method of adds the internship to the list of internships stored in `InternshipList` which it obtains
as a parameter.
  * `InternshipList` class stores the list of internships as a HashMap. Each type of `*AddCommand` will insert the
  internship into the correct list.

**Why is it implemented this way:**

* By abstracting each type of internship into a separate class, the code achieves **SoC (Separation of Concerns)** 
design principle.
* Each subclass is now responsible for validating and executing the command for a specific type of internship, enabling
testing and debugging to be more focused and efficient.

**Alternatives Considered:**
* One way to store internships is to use a single list and store the type of internship as a field in the `Internship`.
But this approach would require additional validation to ensure that the type of internship is consistent with the
parameters provided by the user.
* Another alternative is to use a single `AddCommand` class and use a switch statement to determine the type of internship.
Then the `execute()` would need to have additional checks, making it too long and violating the 
**SRP (Single Responsibility Principle)**.

**Sequence Diagram:**

Below is the sequence diagram for adding a new software internship. A similar sequence is followed for adding a general
or hardware internship.

Add sequence diagram for adding a software internship here

## Product scope
### Target user profile

This product is designed for NUS Computer Engineering undergraduates, especially students applying for internships 
or jobs for the first time. It caters to those who prefer a unified CLI-based platform over a GUI, streamlining 
job application processes for tech-savvy users who value automation and command-line control.

### Value proposition

The product helps CEG students effortlessly track and maintain job applications at different stages using short 
commands, all within a unified CLI. Stay organized, save time, and streamline the application process with automation, 
ensuring a seamless and efficient job hunt.

## User Stories

| Version | As a ...    | I want to ...                                                      | So that I can ...                                                                                     |
|---------|-------------|--------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|
| v1.0    | New user    | View the user command guide easily                                 | learn more about the product as and when needed, and know how to work with the software               |
| v1.0    | Normal user | Add the job role, company and status of the job I have applied for | easily identify where I have applied                                                                  |
| v1.0    | Normal user | List all the jobs I have applied for                               | track my progress and have a masterlist reference of my applications                                  |
| v1.0    | Normal user | Delete certain job applications                                    | only see relevant data in the list                                                                    |
| v1.0    | Normal user | View the detailed job description                                  | have a better understanding of the role I am applying for                                             |
| v1.0    | Normal user | Save the previously stored data about the jobs I have applied to   | reopen the application and have my old data restored so I don't have to reenter everything repeatedly |
| v2.0    | New user    |                                                                    |                                                                                                       |

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
