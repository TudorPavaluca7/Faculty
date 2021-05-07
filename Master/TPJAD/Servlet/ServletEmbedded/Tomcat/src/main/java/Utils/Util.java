package Utils;

public class Util {

    public static boolean isStringInteger(String number ){
        try{
            Integer.parseInt(number);
        }catch(Exception e ){
            return false;
        }
        return true;
    }

    public static String validateStartInput(String minRange, String maxRange,String nrOfAttempts)
    {
        if (minRange.isEmpty() || maxRange.isEmpty() || nrOfAttempts.isEmpty())
            return "All the fields must be filled";

        if (!Util.isStringInteger(minRange) || !Util.isStringInteger(maxRange) || !Util.isStringInteger(nrOfAttempts))
            return "The input value must be an integer";

        int min=Integer.parseInt(minRange);
        int max=Integer.parseInt(maxRange);
        int nrAttempts=Integer.parseInt(nrOfAttempts);

        if (max-min<3)
            return "The maximum range must be greater than the minimum range with at least 2 units";
        if ( nrAttempts > max-min-1)
            return "The number of attempts must be greater with at least 1 unit than the difference between the maxRange and the minRange";
        return "";

    }

    public static String validateGameInput(String userInput)
    {

        if (userInput.isEmpty())
            return "You must enter a value";
        if (!Util.isStringInteger(userInput))
            return "The input value must be an integer";
        return "";
    }
}
