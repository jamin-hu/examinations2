# examinations2

## Context
An administrator and a doctor would like to see a list of patients
and the medical examinations performed on them.

They would like to be able to have a list of numerous patients,
and a set of different types of examinations that any patient
can have performed on them any number of times.

## They Key Concept
Each patient should be able to hold a list of examinations 
performed on themselves. Usually, this is done using the syntax:
```
ArrayList<Examination> examinations = new ArrayList<Examination>();
```
The usual assumption here is that the "Examination" here refers to
a single type of examination with all the same attributes and functions,
but with polymorphism, each Examination object here can have wildly
different attributes and functions as long as they share certain similarities
defined with the help of inheritance and interfaces.

This however means that when calling certain functions on the Arraylist
"examinations", there may be a scenario where the function is not defined
in one specific Examination object of the list, but is defined in
another.

## Running the program
The main programme "AdminView" will construct example patients
and their examinations, then output a summary of the patients
and their examinations to the console (for the administrator) 
as well as to a graphical user interface (for the doctor).
