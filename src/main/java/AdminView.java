import Examinations.Examination;
import Examinations.MRI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.net.URL;

public class AdminView {

    static ArrayList<Patient> PatientList = new ArrayList<>();
    public static void main(String[] args){

        // Making Daphne
        Patient Daphne = new Patient(
                "Daphne Von Oram",
                "https://martinh.netfirms.com/BIOE60010/DaphneVonOram.jpg",
                62
        );
        Examination DaphneMRIExamination1 = new Examination(
                Examination.ExaminationType.MRI,
                LocalDate.of(2023,9,14),
                "Field Strength: 2 Tesla",
                "https://martinh.netfirms.com/BIOE60010/mri1.jpg");
        Examination DaphneBPExamination1 = new Examination(
                Examination.ExaminationType.BP,
                LocalDate.of(2023,9,15),
                "Duration: ST",
                "Systolic: 130mmHg, Diastolic: 70mmHg");
        Daphne.addExamination(DaphneMRIExamination1);
        Daphne.addExamination(DaphneBPExamination1);

        PatientList.add(Daphne);

        // Making Sebastian

        Patient Sebastian = new Patient(
                "Sebastian Compton",
                "https://martinh.netfirms.com/BIOE60010/SebastianCompton.jpg",
                31
        );
        Examination SebastianMRIExamination1 = new Examination(
                Examination.ExaminationType.MRI,
                LocalDate.of(2023,11,19),
                "Field Strength: 4 Tesla",
                "https://martinh.netfirms.com/BIOE60010/mri2.jpg");
        Examination SebastianBPExamination1 = new Examination(
                Examination.ExaminationType.BP,
                LocalDate.of(2023,11,20),
                "Duration: VST",
                "Systolic: 150mmHg, Diastolic: 80mmHg");
        Sebastian.addExamination(SebastianMRIExamination1);
        Sebastian.addExamination(SebastianBPExamination1);

        PatientList.add(Sebastian);

        OutputAdminView();
        OutputDoctorView();

    }

    private static void OutputAdminView(){
        for (Patient patient:PatientList){
            System.out.println(patient.getLogOutput());
        }
    }

    private static void OutputDoctorView(){
        JFrame f=new JFrame();
        f.setLayout(null);
        f.setSize(800, 400);
        f.setLayout(new GridLayout(
                getNumberOfPatients(),
                4));

        for (Patient patient:PatientList){
            // Show profile

            JLabel profilePic = new JLabel();
            URL imageURL = null;
            try {
                imageURL = new URL(patient.getImageURL());
            } catch (MalformedURLException e){
                System.out.println(e.getMessage());
            }
            ImageIcon thisImageIcon = new ImageIcon(imageURL);
            profilePic.setIcon(thisImageIcon);

            f.add(profilePic);


            //
        }



        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {// Ends program if close window is clicked
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

    }

    private static int getNumberOfPatients(){
        return PatientList.size();
    }
}
