import Examinations.Examination;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
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
        String PatientExaminationLogString = "";

        String separatorString = ": ";

        ArrayList<String> examinationLogList = new ArrayList<>();
        for (Examination examination:examinationList){
            examinationLogList.add(examination.getLogString());
        }
        String examinationLogString = String.join(separatorString, examinationLogList);

        PatientExaminationLogString = "Patient: " + name + ": " + examinationLogString;
        return PatientExaminationLogString;
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

    public JScrollPane getFullPatientViewable(){
        JPanel patientPanel = new JPanel();
        JScrollPane panelPane = new JScrollPane(patientPanel);


        patientPanel.add(getPatientViewable());
        for (Examination examination:examinationList){
            patientPanel.add(examination.getViewable());
        }

        return panelPane;
    }

    private JPanel getPatientViewable(){
        JPanel patientPanel = new JPanel();

        // Make Profile Picture Label
        JLabel profilePic = new JLabel();
        URL imageURL = null;
        try {
            imageURL = new URL(this.getImageURL());
        } catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
        ImageIcon thisImageIcon = new ImageIcon(imageURL);
        profilePic.setIcon(thisImageIcon);
        patientPanel.add(profilePic);

        // Make Profile Text Label
        JLabel profileText = new JLabel("My Text");
        profileText.setText("<html>Name: " +
                this.getName() +
                "<br>Age: " +
                this.getAge() +
                "</html>"
        );
        patientPanel.add(profileText);

        return patientPanel;
    }

}
