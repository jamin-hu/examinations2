package Examinations;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

public class MRIExamination extends Examination {

    private float fieldStrengthInTesla;
    private String outcomeImage;

    public MRIExamination(
            float fieldStrengthInTesla,
            String outcomeImage,
            LocalDate timeOfMeasurement
    ){
        super(timeOfMeasurement);
        this.fieldStrengthInTesla = fieldStrengthInTesla;
        this.outcomeImage = outcomeImage;

    }

    @Override
    public String getLogString() {
        String logString = "";

        String fieldStrengthString = String.valueOf(this.fieldStrengthInTesla);

        logString = "MRI: " + fieldStrengthString + ", " + this.timeOfExamination.toString();

        return logString;
    }

    @Override
    public JLabel getViewable(){
        // Not sure how comfortable I man with doing a http request here, seems blocking.
        JLabel MRIViewable = new JLabel();
        URL mriURL = null;
        try {
            mriURL = new URL(this.outcomeImage);
        } catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
        MRIViewable.setIcon(new ImageIcon(mriURL));

        return MRIViewable;
    }
}
