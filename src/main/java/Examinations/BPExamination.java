package Examinations;

import Examinations.Examination;

import javax.swing.*;
import java.time.LocalDate;

public class BPExamination extends Examination {

    private float systolic;
    private float diastolic;

    public enum BPCategory{
        ST,
        VST
    }

    private BPCategory category;

    public BPExamination(
            float systolic,
            float diastolic,
            LocalDate timeOfMeasurement,
            BPCategory category
    ) {
        super(timeOfMeasurement);

        this.systolic = systolic;
        this.diastolic = diastolic;
        this.category = category;
    }

    @Override
    public String getLogString() {
        String logString = "";

        String categoryString;
        if (this.category == BPCategory.ST){
            categoryString = "ST";
        } else {
            categoryString = "VST";
        }

        String dateString = this.timeOfExamination.toString();

        logString = "BP: " + categoryString + ", " + dateString;

        return logString;
    }

    @Override
    public JLabel getViewable() {
        JLabel bpText = new JLabel("My Text");
        String highNumber = String.valueOf(this.systolic);
        String lowNumber = String.valueOf(this.diastolic);
        bpText.setText("<html>Blood Pressure " +
                "<br>" +
                highNumber + " over " + lowNumber +
                "</html>"
        );
        return bpText;
    }

}
