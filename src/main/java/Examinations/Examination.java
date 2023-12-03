package Examinations;

import java.time.LocalDate;

public abstract class Examination implements Printable, Viewable{

    protected LocalDate timeOfExamination;
    public Examination(LocalDate timeOfExamination
    ){

        this.timeOfExamination = timeOfExamination;

    }
}
