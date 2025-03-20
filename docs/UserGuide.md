# InternSprint User Guide
## Introduction

***InternSprint is your Ultimate Internship Application Assistant!***

Navigating internship applications can be overwhelming - multiple platforms, countless CV versions, and keeping track 
of application stages can quickly become chaotic. InternSprint is here to streamline the entire process, acting as your
personal assistant for managing and organizing internship applications efficiently.

Designed for **Command Line Interface (CLI)** users, InternSprint is optimized for speed, flexibility, and simplicity. 
Whether you're applying through countless online jop application portals, or personal connections, our tool ensures 
you stay on top of your applications.

Key features include, logging, monitoring and updating your applications across multiple platforms in one place 
and easily tracking status of your applications. 

*With InternSprint, you’ll never lose track of an application again!*


## Table of Contents

<!-- TOC -->
  * [Quick Start](#quick-start)
  * [Features](#features-)
    * [Help: `help`](#help-help)
    * [Listing all internships: `list`](#listing-all-internships-list)
    * [Adding a general category of internship: `add general`](#adding-a-general-category-of-internship-add-general)
    * [Adding a software category of internship: `add software`](#adding-a-software-category-of-internship-add-software)
    * [Adding a hardware category of internship: `add harware`](#adding-a-hardware-category-of-internship-add-harware)
    * [Editing an internship: `edit`](#editing-an-internship-edit)
    * [Deleting an internship: `delete`](#deleting-an-internship-delete)
    * [Viewing extended description of a specific internship: `desc`](#viewing-extended-description-of-a-specific-internship-desc)
    * [Exit `bye`](#exit-bye)
  * [Saving the data](#saving-the-data)
  * [Editing the data file](#editing-the-data-file)
  * [FAQ](#faq)
  * [Command Summary](#command-summary)
<!-- TOC -->

## Quick Start

1. Ensure you have **Java 17** or above installed in your Computer and it is compatible with your device operating
   system (Mac or Windows).

2. Download the latest `.jar` file from https://github.com/AY2425S2-CS2113-T11a-3/tp/releases under latest release.

3. Copy the file to the folder you want to use as the home folder for InternSprint.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the  `java -jar InternSprint.jar` command to
   run the application.
   InternSprint should appear in your terminal window as shown below.

   >If you are a Mac user, do note that due to Mac Gatekeeper, this .jar file and its home folder cannot be in the
   `Downloads` directory, and will have to be relocated to another
   directory such as `Desktop` to bypass Mac's additional security check,
   hence if you see `Error: unable to access jarfile InternSprint.jar` simply relocate the directory. (You may bypass this
   quarantine on your Mac
   but this will require admin privileges and could be potentially be a security risk since anyone can now access this
   file, thus
   the relocation method is best).

    - Note the app will generate a data.txt file in this home folder which
      will be empty when the app is first launched.
   
      
5. Type the command in the terminal window and press Enter to execute it. e.g. typing list and pressing Enter will list
   all stored tasks.
   Some example commands you can try:

   `list` : Lists all internships.

   `add general /c Google /r Human Resource /dept HR`  : Adds a general type of internship at Google, of Human 
    resources role, under HR department.

   `edit /index 1 /eli Year 2 students` : Adds description of eligibility to internship indexed at 1 in your list.

   `bye` : Exits the app.

## Features 

### Help: `help`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.

Example of usage:

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

### Listing all internships: `list`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.

Example of usage:

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`
### Adding a general category of internship: `add general`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

### Adding a software category of internship: `add software`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.

Example of usage:

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

### Adding a hardware category of internship: `add harware`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.

Example of usage:

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

### Editing an internship: `edit`
Allows users to add (job description, eligibility, and expectations) or modify (company name, role,tech and status) 
details for a specific internship application.

Basic Format: `edit /index INDEX_NUMBER /c COMPANY_NAME /r ROLE`

Extended Format (with optional parameters): `edit /index INDEX_NUMBER /c COMPANY_NAME /r ROLE /ex EXPECTATIONS /eli ELIGIBILITY /dept DEPARTMENT 
        /hardtech HARDWARE_TECHNOLOGIES /desc DESCRIPTION /tech TECHNOLOGIES`

> This format shows you all the possible flags or parameters you can set for an internship, however they are optional 
> (as-needed basis) -
> i.e. you do not need to utilize all flags when using this command, only those relevant to you.

* The `INDEX` must be valid within the internship list else this will return an error out of range message.
* The parameters cannot effectively be edited to duplicate another internship in the list.
* To edit the tech of a software internship use the `/tech` flag and to edit the tech of a hardware internship use the
`/hardtech` flag else if you try and set a software tech flag to a hardware role an error message will be displayed.

Example of usage:

`edit /index 1 /c Google /tech C, C++ /eli Y3 student /ex Fast Learner`

`edit /index 1 /desc Some extended description for our users`

### Deleting an internship: `delete`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.

Example of usage:

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`


### Viewing extended description of a specific internship: `desc`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.

Example of usage:

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

### Exit `bye`

Exits the program.

## Saving the data

InternSprint  data is saved in the hard disk automatically after any command that changes the data. 
There is no need to save manually.


## Editing the data file

InternSprint  data is saved automatically in `.json` format [JAR file location]/data/internships.txt. 
Advanced users are welcome to update data directly by editing that data file.

> CAUTION!:
> The data file has particular .jsonformatting, any change to this file that violates this formatting could **corrupt the
data** and would require the data file to be deleted
> and started again. Therefore, edit the data file only if you are confident that you can update it correctly.

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Simply copy the file [JAR file location]/data/internships.txt and transfer it to the secondary device in 
the same subdirectory of [JAR file location]/data. This will ensure your data is transferred, but keep in mind there
should be only one internships.txt in the location.

## Command Summary

{Give a 'cheat sheet' of commands here once v2.0 goes out}

