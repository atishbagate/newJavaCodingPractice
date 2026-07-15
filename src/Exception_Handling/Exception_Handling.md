1. What is an Exception?
An Exception is an unwanted or unexpected event that occurs during the execution of a program
(at runtime) which disrupts the normal flow of the program's instructions.

Exception Handling is the mechanism to handle these runtime errors so that
the application doesn't crash and can terminate gracefully.

In Java, the ultimate parent class for all errors and exceptions is java.lang.Throwable.

               Throwable (Parent Class)
                 /          \
                /            \
          Exception           Error
           /     \              |
    Checked       Unchecked     (StackOverflowError,
  Exceptions     Exceptions      OutOfMemoryError, etc.)
  (IOException,  (RuntimeException,
   SQLException)  NullPointerException)

 Exception :
        . Conditions that a reasonable application might want to catch and recover from.
        . Caused by the program itself (e.g., bad user input, missing file).
        . Recoverable using try-catch blocks.
        . IOException, NullPointerException

 Error :
       . Serious problems that a reasonable application should not try to catch.
       . Caused by the environment or system resources (e.g., running out of memory).
       . Irrecoverable. The program will almost always terminate.
       . OutOfMemoryError, StackOverflowError

4. Types of Exceptions :

 A. Checked Exceptions (Compile-time Exceptions)
    . These are exceptions that are checked by the Java compiler at compile-time.

    . A more accurate name for these is compile-time enforced exceptions.
        The exception itself only happens at runtime, but the compiler checks your code ahead of time
        to make sure you have a plan to handle it if it does happen. If you haven't written a handler
        (try-catch or throws), you get a compilation error, not an exception.

    . Characteristics: They represent predictable scenarios outside the program's direct control
        (like a missing file or a dropped network connection). The Java compiler forces you to acknowledge
         this risk before it lets you compile the code.

    . The compiler forces you to handle them; if you don't, the code will not compile.
    .Common Examples:
     IOException: Failed or interrupted I/O operations.
     FileNotFoundException: Trying to open a file that doesn’t exist.
     SQLException: Database access errors.

 B. Unchecked Exceptions (Runtime  Exceptions)
     These are exceptions that occur at runtime
     and are not checked by the compiler. They all inherit from the RuntimeException class.

    .They usually happen due to programming flaws or bad logic. The compiler won't force you to handle them,
     but they will still crash your app if they occur.

    Common Examples:
        NullPointerException (NPE): Trying to call a method on a null object reference.
        ArithmeticException: An exceptional arithmetic condition (like dividing by zero).
        ArrayIndexOutOfBoundsException: Trying to access an array index that doesn't exist.

 exception has 3 parts :
   1. exception class name.
   2. description.
   3. stack trace.

  methods to print exception information : 3 types.
    1. e.printStackTrace(); ->  print exception class and desc and stack trace.
    2. e.toString(); ->  print only exception class name and description
    3. e.getMessage(); -> print only  description

  Finally block :

  It always run/ execute section.
  we can use finally without catch also.
  uses - finally block is used to close the connections or resource close.


 Throw keyward :


