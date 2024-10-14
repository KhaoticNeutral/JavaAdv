package examples.DateFormatExample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormatTest {
    public static void main(String[] args) {

        LocalDateTime today = LocalDateTime.now();
        Locale loc = Locale.FRANCE;

        DateTimeFormatter df =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                        .withLocale(loc);
        System.out.println("Date: " + today.format(df)
                + " Locale: " + loc.toString());
    }
}

//This code demonstrates how to:
//
//Obtain the current date and time using LocalDateTime.now().
//Set a specific locale using Locale.
//Create a DateTimeFormatter to format dates according to the locale using DateTimeFormatter.ofLocalizedDate and withLocale.
//Format a LocalDateTime object using the formatter and print the result.
//The output will be a date formatted according to French conventions, along with the locale information.