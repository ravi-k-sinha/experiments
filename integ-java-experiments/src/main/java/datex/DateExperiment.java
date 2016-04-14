package datex;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateExperiment {


    public static void main(String[] args) throws Exception {
        Date currentDate = new Date();

        TimeZone currentTimezone = TimeZone.getDefault();
        System.out.println("Current time-zone is " + currentTimezone);

        DateFormat formatter = DateFormat.getDateTimeInstance();

        System.out.println("Local:" + formatter.format(currentDate));

        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        System.out.println("UTC:" + formatter.format(currentDate));

        Date reconvertedDate = formatter.parse(formatter.format(currentDate));
        System.out.println(reconvertedDate);

        anotherMethod();
    }

    private static Date anotherMethod() {
        Date date = new Date();
        System.out.println("Local2 : " + date);
        System.out.println("Local : " + date.getTime());
        DateFormat format = new SimpleDateFormat();
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formatted = format.format(date);
        System.out.println("Formatted in UTC : " + formatted);
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            Date converted = simpleDateFormat.parse(formatted);
            System.out.println("UTC : " + converted.getTime());
            System.out.println("Converted Date : " + converted);
            return converted;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
