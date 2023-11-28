package Examinations;

import java.time.LocalDate;

public class Examination {

    public enum ExaminationType {
        MRI,
        BP,
    }



    private ExaminationType examinationType;
    private LocalDate date;
    private String configuration;
    private String result;

    public Examination(ExaminationType examinationType,
                       LocalDate date,
                       String configuration,
                       String result
    ){

        this.examinationType = examinationType;
        this.date = date;
        this.result = result;
        this.configuration = configuration;
    }

    public String getLogOutput() {
        return this.examinationType.toString() + ": " +
                this.configuration + ", " +
                this.date.toString();
    }
}
