# CSVOL

## About
Character Separated Value Organizer Language, or CSVOL (\kasväl\), is a language that is domain specific to querying and visualizing CSV files. CSVOL is influenced by many technologies that help clients better visualize and query data. Language example include languages domain specific to data processing like Visual Basic, SQL, and Unix utilities such as AWK, SED, and GREP. CSVOL is also influenced by spreadsheet software like Microsoft Excel and Google Sheets. CSVOL is aims to provide a non-proprietary, client-side solution that places all of the great features seen in the previously stated solutions into one umbrella.

![logo](https://raw.githubusercontent.com/AbirHaque/CSVOL/master/Assets/logo.png)

Alongside CSVOL, we are submitting CSVOL SOL, or CSVOL Standard Online Library. SOL was developed concurrently with CSVOL. SOL, rather than a language, is the infrastructure put in place for CSVOL that makes adding new features to the language easier. SOL ensures the continued improvement and longevity of CSVOL.

SOL contains CSVOL commands that are not present in the base interpreter, such as a command that sets custom delimiters. SOL allows any developer to import additional CSVOL commands, modules, and CSV files, all without touching original interpreter files. Currently, two commands are provided in SOL, with plans to continue adding more to SOL after the jam.

## Project links
All development occurred on Repl.it, with occasional testing on desktop environments. Both CSVOL and SOL are synced with GitHub.

### Repl.it:
- Interpreter: https://repl.it/@wichitacpu/CSVOL#main.csvol
-	SOL: https://repl.it/@wichitacpu/csvol-docs
•	Host website: https://csvol-docs.wichitacpu.repl.co/sol.html
-	Examples CSVOL code:
•	Explained in the Tutorial section: https://repl.it/@wichitacpu/CSVOL-Example-2#main.csvol
•	Fibonacci sequence to Nth term with CSVOL: https://repl.it/@wichitacpu/CSVOL-Example#main.csvol

### GitHub:
-	Interpreter: https://github.com/AbirHaque/CSVOL
-	SOL: https://github.com/AbirHaque/csvol-docs
•	Host website: https://abirhaque.github.io/csvol-docs/sol.html

## Developers
The current members of the Wichita Computer Programmers' [@wichitacpu](https://repl.it/@wichitacpu/) are all students of Wichita High School East, and CSVOL is the group's first project, with SOL being its second. Members that worked on CSVOL and SOL's development were:
- Abir Haque [@AbirHaque](https://repl.it/@AbirHaque/)
- William Kieu [@WilliamBruh](https://repl.it/@WilliamBruh/)

## Technical details
- CSVOL is an interpreted language that is object-based and event-driven.
- The interpreter and SOL are in Java.
- The SOL host website was built with HTML.
- Only CSVOL source files and a Java 8+ compiler are needed to run CSVOL on your computer, so CSVOL can run offline on multiple platforms, including Windows, Linux, and MacOS.
- We believe we successfully crafted CSVOL to be Turing complete.

Asides from baseline features like creating/adding/editing/deleting/printing file contents, looping, conditional statements, and math operators, the current features of CSVOL include:

- Importable libraries
• This helps promotes future improvements to CSVOL, while maintaining the same interpreter and syntax structure of CSVOL. These additions can be from SOL or custom made. Instructions to make your own importable command will soon be posted here, hopefully before the end of the jam: https://csvol-docs.wichitacpu.repl.co/sol.html
• If you would like to contribute your own CSVOL command, module, or file to SOL, submit a pull request here: https://github.com/AbirHaque/csvol-docs/pulls
- Optional Repl environment
• Promotes quick, one-time, client-side programming.
- GUI spreadsheet
• With SOL, clients can view/edit spreadsheet versions of their CSV file.
- CSVOL script modularization
• Promotes organized and reusable CSVOL code.

## Roadmap
General meeting notes documenting all of Wichita CPU's operations can be found on our group's public Google Doc: https://docs.google.com/document/d/1penokzeQKJ7PXM5JvUvn8pT_uso4QuSFwjQhdeqkrpU/

We plan to implement the following features:

- More search functions
- Advanced math functions, mainly trigonometric (sine, cosine, tangent, etc)
- Make GUI UX better (scroll bars, drag/drop, keyboard/mouse commands, etc)
- Build up SOL infrastructure by adding commands like the previously stated ones
- Fix looping issues in REPL environment
- Improve documentation page

More additions will be decided upon and listed during general meetings.
## Tutorial
### REPL
To command through the terminal, leave main.csvol blank, or write the following in a .csvol script if you want to call it at a certain time.
```
PULL REPL
```
Output:

```
CSVOL 0.9.4.
CSVOL Copyright (C) 2020 Abir Haque.
Developed by the Wichita Computer Programmers' Union.

REPL enabled.
Type "HELP" for a list of commands and their usage. 
```

#### End REPL/terminal programming and resume script instructions, if any:
```
DROP REPL
```
### REPL and Script commands
The following commands work in both a .csvol script and the REPL environment.
#### Commenting:
```
COMMENT This is a comment
~ This is also a comment
~ A comment must be given the entire line
```
#### Creating an empty file:
```
CREATE FILE file_name
CREATE FILE delete
~ Generates file_name.csv and delete.csv
```
#### Deleting files:
```
DELETE FILE delete
```
#### Instantiating columns, rows, and cell values:
```
~ Can pull pre-existing files too
PULL FILE file_name
  CREATE COLUMNS<~{column_1, column_2, column_i}
  CREATE ROWS<~{4}
  ADD {0, 1}<~{apples}
  ADD {0, 2}<~{bananas}
  ~ Must drop file at the end of instantiation.
  DROP FILE
```
#### Terminal output:
```
PRINT TEXT My first file!
PRINT FILE file_name
```
Output:
```
My first file!
column_1,column_2,column_i
apples,0,0
bananas,0,0
0,0,0
0,0,0
```
#### Editing files:
```
EDIT FILE file_name CELL {0, 3}<~{FILE file_name CELL {0, 2}}
EDIT FILE file_name CELL {0, 2}<~{pear}
EDIT FILE file_name CELL {0, 0}<~{fruits}
EDIT FILE file_name CELL {1, 0}<~{quantity}
~ Add 2 empty rows.
EDIT FILE file_name ROWS ADD<~{2}
~ Below deletes columns from column 2 to column 2 (index starts at 0)
EDIT FILE file_name COLUMNS DELETE<~{2, 2}
~ Below adds columns to the far right of the file.
EDIT FILE file_name COLUMNS ADD<~{column_3, column_4}
~ Below deletes rows from row 1 to row 1 (column name row is row 0)
EDIT FILE file_name ROWS DELETE<~{1, 1}
PRINT FILE file_name
```
Output:
```
fruits,quantity,column_3,column_4
pear,0,0,0
bananas,0,0,0
0,0,0,0
0,0,0,0
0,0,0,0
```
#### Math operators:
+,-,/, and * are supported.
```
EDIT FILE file_name CELL {1, 1}<~{MATH {20 - 10}}
EDIT FILE file_name CELL {1, 2}<~{MATH {{FILE file_name CELL {1, 1}} * 50}}
```
Output:
```
fruits,quantity,column_3,column_4
pear,10,0,0
bananas,500,0,0
0,0,0,0
0,0,0,0
0,0,0,0
```
#### Importing from SOL
It's recommended to put import statements at the top of your CSVOL project.
```
IMPORT COMMAND csvol-sol Display
```
Output:
```
Please wait. Accessing CSVOL's Standard Online Library . . . 
Please wait. Importing library . . . 
Done!
```
#### Running the csvol-sol Display command
```
PRINT TEXT Press the exit button to continue.
IMPORTED Display FILE file_name
~ A new window will pop up with a spreadsheet of the file.
```
Output:
```
Press the exit button to continue.
Please wait. Loading GUI . . . 
Done!
```
### Script-only commands
#### CSVOL modules:
Creating CSVOL modules are create for dividing tasks. Modules are especially useful for implementing recursion.
In your interpreter directory, create a new file ending in .csvol. Here is the contents of the example.csvol module:
```
PRINT TEXT Accessed example module.
~ Put what ever CSVOL code you want above PULL MAIN
~ PULL MAIN resumes spot in main.csvol
PULL MAIN
```
#### Calling modules from main.csvol:
```
PULL MODULE example
```
Output:
```
Accessed example module. 
```
#### Conditionals:
```
IF FILE file_name CELL {0, 3} = TEXT {0}
  PRINT TEXT Empty row.
CONDITIONAL
IF FILE file_name CELL {1, 1} <= FILE file_name CELL {1, 2}
  PRINT TEXT Less/equal pears than bananas.
CONDITIONAL
IF FILE file_name CELL {0, 1} = TEXT {0}
  PRINT TEXT They don't sell pears.
CONDITIONAL
IF FILE file_name CELL {0, 1} != TEXT {0}
  PRINT TEXT Pears are in the store.
CONDITIONAL
```
Output:
```
Empty row.
Less pears than bananas
Pears are in the store. 
```
### Miscellaneous:
The following features were implemented to promote easy, rapid development of CSVOL applications:
- The interpreter ignores tab spaces, brackets, and commas. The interpreter also equates "<~" to white space. However, you can still put such characters in your CSVOL program to aide in code readability. The following lines of code are interpreted exactly the same, whereas the 1st line is much more readable:
```
EDIT FILE file_name CELL {1, 2}<~{MATH {{FILE file_name CELL {1, 1}} * 50}}
EDIT FILE file_name CELL 1 2 MATH FILE file_name CELL 1 1 * 50
```
- The interpreter will report errors in both the file and line number the error is located.
```
33  PULL FILE search
34    CREATE COLUMNS<~{Term_to_search}
35    CREATE ROWS<~{1}
36    ADD {0,1}{8}
37    DROP FILE
```
Reports:
```
CSVOL error ~> File main.csvol ~> Line 36.
```
Needed corrections:
```
33  PULL FILE search
34    CREATE COLUMNS<~{Term_to_search}
35    CREATE ROWS<~{1}
36    ADD {0, 1}<~{8}
37    DROP FILE
```
## Examples
To try out the REPL, write your own CSVOL program, or fork a plain project with just the interpreter, head to this repl: https://repl.it/@wichitacpu/CSVOL#main.csvol. The previous two links are merely forks of this project.

All of the Tutorial section code works in this repl: https://repl.it/@wichitacpu/CSVOL-Example-2#main.csvol.

This repl has example CSVOL code that uses GUIs, calculates a user inputted Nth Fibonacci term, and implements recursive searching: https://repl.it/@wichitacpu/CSVOL-Example#main.csvol. In my opinion, this would be the best example of CSVOL to look at. Below are snippets CSVOL's ability to implement simple linear and recursive algorithms:

Searching:
```
~ This search module returns a fibonacci list term given n
~ Block 1 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
EDIT FILE indices CELL {0, 1}<~{MATH {FILE indices CELL {0, 1}} + 1}
IF FILE indices CELL {0, 1} >= FILE indices CELL {1, 1}
  EDIT FILE search COLUMNS ADD<~{Term}
  EDIT FILE search CELL {1, 1}<~{Not found!}
  PULL MAIN
CONDITIONAL
~ Block 2 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
IF FILE search CELL {0, 1} = FILE fibonacci_output CELL {0, FILE#indices#CELL#0#1}
  EDIT FILE search COLUMNS ADD<~{Term}
  EDIT FILE search CELL {1, 1}<~{FILE fibonacci_output CELL {1, FILE#indices#CELL#0#1}}
  PULL MAIN
CONDITIONAL
PULL MODULE search

COMMENT
~ Module broken down, line by line
~ Block 1 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
~ Plus 1 to current index
~ If the end of the list is reached
  ~ Creates a new column in the search file that outputs the term corresponding to n
  ~ Adds "Not found!" next to n in search file
  ~ Ends module and returns to the main file
~ Conditional
~ Block 2 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
~ If the n equals cell value
  ~ Creates a new column in the search file that outputs the term corresponding to n
  ~ Adds term next to n in search file
  ~ Ends module and returns to the main file
~ Conditional
~ Recursive call
```
Fibonacci Sequence:
```
~ Fibonacci sequence module
~ Block 1 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
EDIT FILE fibonacci_output CELL {0, FILE#indices#CELL#1#1}<~{FILE indices CELL {1, 1}}
EDIT FILE indices CELL {4, 1}<~{MATH {FILE indices CELL {2, 1}} + {FILE indices CELL {3, 1}}}
EDIT FILE indices CELL {2, 1}<~{FILE indices CELL {3, 1}}
EDIT FILE indices CELL {3, 1}<~{FILE indices CELL {4, 1}}
EDIT FILE fibonacci_output CELL {1, FILE#indices#CELL#1#1}<~{FILE indices CELL {4, 1}}
~ Block 2 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
EDIT FILE indices CELL {0, 1}<~{MATH {FILE indices CELL {0, 1}} - 1}
EDIT FILE indices CELL {1, 1}<~{MATH {FILE indices CELL {1, 1}} + 1}
~ Block 3 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
IF FILE indices CELL 0 1 > TEXT 0
  PULL MODULE fibonacci
CONDITIONAL
~ Block 4 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
PRINT FILE fibonacci_output
PULL MAIN

COMMENT
~ Fibonacci sequence module broken down, line by line
~ Block 1 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
~ Writes term index
~ Term = 1st term + 2nd term
~ 1st term = 2nd term
~ 2nd term = current term
~ Writes term
~ Block 2 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
~ Minus 1 from iterations
~ Plus 1 to current index
~ Block 3 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
~ If the iteration number is greater than 0
  ~ Recursive call
~ Conditional
~ Block 4 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
~ Print file contents
~ Ends module and returns to the main file
```

On behalf of the Wichita Computer Programmers' Union, I would like to thank Repl.it and the jam judges for presenting us with such a fun challenge!
