package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static String getEpoch(){
        long epochInMillisecond = Instant.now().toEpochMilli();
        return String.valueOf(epochInMillisecond);
    }
    public static String getPastDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date todate1 = cal.getTime();    
        String fromdate = dateFormat.format(todate1);
        System.out.println(fromdate);
        return fromdate;
    }


}
