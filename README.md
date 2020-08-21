# CSVOL
Comma Separated Value Organization Language, or CSVOL (\kasväl\\), is an interpreted language that specializes in reporting and manipulating CSV files.

You can write CSVOL code in the main.csvol file. Alternatively, you may instruct through the command-line by writing PULL REPL to a blank main.csvol file.

#### Why CSVOL?

While the intended application of CSVOL is very similar to those of Unix utilities, such as AWK, SED, and GREP [(1)](https://davidlyness.com/the-functional-and-performance-differences-of-sed-awk-and-other-unix-parsing-utilities), they come with a few issues.

AWK does not support modularization [(2)](https://www.cs.rit.edu/~afb/20013/plc/slides/perlintro-03.html). In addition, math operations are difficult to express in SED [(3)](http://sed.sourceforge.net/sedfaq6.html)[(4)](https://unix.stackexchange.com/questions/36949/addition-with-sed). Finally, GREP lacks replacing capabilities [(1)](https://davidlyness.com/the-functional-and-performance-differences-of-sed-awk-and-other-unix-parsing-utilities). CSVOL attempts to solve a few of their limitations by placing the positive aspects of said Unix utilities under one umbrella.

While Perl, Python, Java, and other general-purpose languages provide CSV file parsing capabilities, they too come with their own setbacks for developers. Perl does not offer an interactive shell [(5)](http://web.eecs.utk.edu/~bvanderz/cs460/notes/perl/perl1.html#title3). In addition, Perl does not provide strong portability [(5)](http://web.eecs.utk.edu/~bvanderz/cs460/notes/perl/perl1.html#title3). A minor setback seen in Python, Java, and other languages is that indentation and braces are mandatory to define blocks of code [(6)](https://data-flair.training/blogs/advantages-and-disadvantages-of-python/). CSVOL attempts to address these setbacks.

#### Built with
The interpreter is written in entirely Java. All development occurred on Repl.it.

#### Roadmap
We plan on moving meeting notes to a group website in the future. General meeting notes for all of Wichita CPU's operations can be found on [our group's public Google Doc](https://docs.google.com/document/d/1penokzeQKJ7PXM5JvUvn8pT_uso4QuSFwjQhdeqkrpU/edit).

Will implement the following functions:
- Maybe Turing completeness?

Current functionality:
- Enable REPL environment
- Create new file
- Pull existing file to read
- Drop existing file
- Print contents of file
- Edit contents of file
- Delete contents of file

More additions will be decided upon and listed during general meetings.

#### Developers
The current members of the [Wichita Computer Programmers' Union](https://repl.it/@wichitacpu) are all students of [Wichita High School East](https://www.usd259.org/east), and CSVOL is the group's first project. Members that actively worked on CSVOL's development were:
- [Abir Haque](https://abirhaque.github.io/)
- William Kieu

#### Contact
Feel free to get in touch by sending an email to abir.haque.usa@gmail.com.

#### Project Links
Main - https://repl.it/@wichitacpu/CSVOL
Backup - https://github.com/AbirHaque/CSVOL

#### Sources
(1) - https://davidlyness.com/the-functional-and-performance-differences-of-sed-awk-and-other-unix-parsing-utilities
(2) - https://www.cs.rit.edu/~afb/20013/plc/slides/perlintro-03.html
(3) - http://sed.sourceforge.net/sedfaq6.html
(4) - https://unix.stackexchange.com/questions/36949/addition-with-sed
(5) - http://web.eecs.utk.edu/~bvanderz/cs460/notes/perl/perl1.html#title3
(6) - https://data-flair.training/blogs/advantages-and-disadvantages-of-python/
