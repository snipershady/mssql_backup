package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Stefano Perrini <perrini.stefano@gmail.com>
 */
public final class DateHelper {

    private final static String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * This constructor is usable only inside of this class
     */
    private DateHelper() {
    }

    /**
     *
     * @param d
     * @return
     */
    public static String dataPickerToString(LocalDateTime d) {
        return d.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     *
     * @param d
     * @return
     */
    public static String dataPickerToString(LocalDate d) {
        return d.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     *
     * @param d
     * @return
     */
    public static String dateToString(Date d) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String res = null;
        try {
            res = formatter.parse(d.toString()).toString();
        } catch (ParseException ex) {
            System.err.println("Date Helper dateToString : " + ex.getMessage());
        }
        return res;
    }

    /**
     * This method retrive date and time from system
     *
     * @return mysql SYSDATE format
     */
    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * This method retrive date and time from system
     *
     * @return mysql SYSDATE format
     */
    public static String getDateTimeForFileName() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * This method retrive date from system
     *
     * @return mysql CURDATE format
     */
    public static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * This method convert a date in String type to Date Type
     *
     * @param dateFromDb String Date format from db e.g. (1979-11-26)
     * @return date Date converted in DateType or null if param dateFromDb is
     * null
     */
    public static Date stringToDate(String dateFromDb) {

        DateFormat formatter;
        Date date = null;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (dateFromDb != null) {
                date = formatter.parse(dateFromDb);
            }
            //System.out.println("formatter "+date);
        } catch (ParseException parseException) {
            System.err.println("parseException" + parseException);
        }
        return date;

    }

    /**
     *
     * @param date
     * @return
     */
    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * This method convert a dateTime in a String type to Datetime Type
     *
     * @param dateFromDb String DateTime format from db e.g. (1979-11-26
     * 00:00:00)
     * @return DateTime converted in dataType
     */
    public static Date stringToDateTime(String dateFromDb) {

        DateFormat formatter;
        Date date = null;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = formatter.parse(dateFromDb);
        } catch (ParseException parseException) {
            System.err.println("parseException" + parseException);
        }
        return date;

    }

    public static String dateToStringToDisplay(java.util.Date in) {
        if (in == null) {
            throw new IllegalArgumentException("NOT NULL CONSTRAINT DATE HELPER 'dateToStringToDisplay' INPUT DATE CAN NOT TO BE NULL");
        }
        return new java.sql.Date(in.getTime()).toString();
    }
}
