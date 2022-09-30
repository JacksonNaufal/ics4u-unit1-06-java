
/*
* This is a program that calculates mean, median and mode
* after reading in a text file into an array.
*
* @author  Jackson Naufal
* @version 1.0
* @since   2020-09-30
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* This is the statistics program.
*/
final class Statistics {

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Statistics() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The mean() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @return the mean of the integers
    */
    public static float mean(final Integer[] arrayOfIntegers,
       final float quantity) {
        float meanCalc = 0;

        for (int counter : arrayOfIntegers) {
                meanCalc += counter;
        }
        meanCalc = meanCalc / quantity;

        return meanCalc;
    }

    /**
    * The median() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @return the median of the integers
    */
    public static float median(final Integer[] arrayOfIntegers, 
                    final float quantity) {
       float medianCalc = 0;
       final double extra = 0.5;
       Arrays.sort(arrayOfIntegers);

       if (quantity % 2 == 0) {
               medianCalc = arrayOfIntegers[(int) (quantity / 2 - extra)];
        } else {
                medianCalc = (arrayOfIntegers[(int) (quantity / 2 - extra)] 
                            + arrayOfIntegers[(int) (quantity / 2 + extra)]) / 2;
        }
       return medianCalc;
    }


    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {

        Integer tempNumber;
        final float meanCalc;
        final float medianCalc;
        final Integer[] arrayOfIntegers;
        final ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        final Path filePath = Paths.get("./", args[0]);
        final Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(
                                     filePath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                tempNumber = Integer.parseInt(line);
                listOfNumbers.add(tempNumber);
            }
        } catch (IOException errorCode) {
            System.err.println(errorCode);
        }

        arrayOfIntegers = listOfNumbers.toArray(new Integer[0]);
        final float quantity = arrayOfIntegers.length;

        System.out.println("\nCalculating stats...");
        meanCalc = mean(arrayOfIntegers, quantity);
        medianCalc = median(arrayOfIntegers, quantity);

        System.out.println("The mean is: " + meanCalc);
        System.out.println("The median is: " + medianCalc);

        System.out.println("\nDone.");
    }
}
