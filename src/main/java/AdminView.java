import Examinations.BPExamination;
import Examinations.Examination;
import Examinations.MRIExamination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdminView {

    static ArrayList<Patient> PatientList = new ArrayList<>();
    public static void main(String[] args){

        PatientList = ConstructPatients();

        OutputAdminView();
        OutputDoctorView();

    }

    private static ArrayList<Patient> ConstructPatients(){

        ArrayList<Patient> PatientList = new ArrayList<>();

        // Making Daphne
        Patient Daphne = new Patient(
                "Daphne Von Oram",
                "https://martinh.netfirms.com/BIOE60010/DaphneVonOram.jpg",
                62
        );
        Examination DaphneMRIExamination1 = new MRIExamination(
                2,
                "https://martinh.netfirms.com/BIOE60010/mri1.jpg",
                LocalDate.of(2023,9,14)
        );
        Daphne.addExamination(DaphneMRIExamination1);

        Examination DaphneBPExamination1 = new BPExamination(
                130,
                70,
                LocalDate.of(2023,9,15),
                BPExamination.BPCategory.ST
        );
        Daphne.addExamination(DaphneBPExamination1);

        PatientList.add(Daphne);

        // Making Sebastian
        Patient Sebastian = new Patient(
                "Sebastian Compton",
                "https://martinh.netfirms.com/BIOE60010/SebastianCompton.jpg",
                31
        );
        Examination SebastianMRIExamination1 = new MRIExamination(
                4,
                "https://martinh.netfirms.com/BIOE60010/mri2.jpg",
                LocalDate.of(2023,11,19)
        );
        Sebastian.addExamination(SebastianMRIExamination1);

        Examination SebastianBPExamination1 = new BPExamination(
                150,
                80,
                LocalDate.of(2023,11,20),
                BPExamination.BPCategory.VST);
        Sebastian.addExamination(SebastianBPExamination1);

        PatientList.add(Sebastian);

        return PatientList;
    }

    private static void OutputAdminView(){
        for (Patient patient:PatientList){
            System.out.println(patient.getLogOutput());
        }
    }

    private static void OutputDoctorView(){
        JFrame frame=new JFrame();
        frame.setSize(800, 400);

        JPanel patientListPanel = new JPanel(new GridLayout(0, 1));
        JScrollPane patientListScrollPane = new JScrollPane(patientListPanel);
        for (Patient patient:PatientList){
            // Show profile
            JScrollPane patientScrollPane = patient.getFullPatientViewable();
            patientListPanel.add(patientScrollPane);
        }

        frame.getContentPane().add(patientListScrollPane);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {// Ends program if close window is clicked
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
