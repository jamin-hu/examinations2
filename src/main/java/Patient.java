import Examinations.Examination;

import java.sql.Array;
import java.util.ArrayList;

public class Patient {
    private String name;
    private String imageURL;
    private int age;

    private ArrayList<Examination> examinationList= new ArrayList<>();

    public Patient(String name,
                   String imageURL,
                   int age){
        this.name = name;
        this.imageURL = imageURL;
        this.age = age;
    }

    public String getLogOutput(){
        String OutputString = "Patient: " + name + ": ";
        for (Examination examination:examinationList){
            OutputString = OutputString + examination.getLogOutput();
            OutputString = OutputString + ", ";
        }
        return OutputString;
    }

    public void addExamination(Examination examination){
        examinationList.add(examination);
    }

    public String getImageURL(){
        return this.imageURL;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public ArrayList<Examination> getExaminationList(){
        return this.examinationList;
    }

}
