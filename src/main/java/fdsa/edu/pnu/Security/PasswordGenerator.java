package fdsa.edu.pnu.Security;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Course: Platforme Numerique Universitaire - FDSA
 * @Author Name: Girbson Bijou
 * @Assignment Name: fdsa.edu.pnu.Security
 * @Date: Sep 26, 2021
 * @Subclass PasswordGenerator Description:
 */
//Imports
//Begin Subclass PasswordGenerator
@Service
public class PasswordGenerator {

    public String randomPassword() {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String SpecialCaracter = "!#$%&*?@";

        //Instanciate Random Object
        Random random = new Random();
        int randUpperNumber = random.nextInt(6 - 2) + 2;
        int randlowerAlphabet = random.nextInt(6 - 2) + 2;
        int randNumberOfNumbers = random.nextInt(6 - 2) + 2;
        int randSpecialCaracterNumber = random.nextInt(6 - 2) + 2;

        char arrStr[] = new char[randUpperNumber];
        char arrStrLower[] = new char[randlowerAlphabet];
        char arrStrNumber[] = new char[randNumberOfNumbers];
        char arrStrSpecialChar[] = new char[randSpecialCaracterNumber];

        String finalRandom = null;
        String upperAlphabetPart = null;
        String lowerAlphabetPart = null;
        String randNumberOfNumbersPart = null;
        String randSpecialCaracterNumberPart = null;

        for (int i = 0; i < randUpperNumber; i++) {
            int randIndex = random.nextInt(upperAlphabet.length() - 1) + 1;
            arrStr[i] = upperAlphabet.charAt(randIndex);
        }

        upperAlphabetPart = String.valueOf(arrStr);

        for (int i = 0; i < randlowerAlphabet; i++) {
            int randIndexlower = random.nextInt(lowerAlphabet.length() - 1) + 1;
            arrStrLower[i] = lowerAlphabet.charAt(randIndexlower);
        }

        lowerAlphabetPart = String.valueOf(arrStrLower);

        for (int i = 0; i < randNumberOfNumbers; i++) {
            int randIndexNumber = random.nextInt(numbers.length() - 1) + 1;
            arrStrNumber[i] = numbers.charAt(randIndexNumber);

        }

        randNumberOfNumbersPart = String.valueOf(arrStrNumber);

        for (int i = 0; i < randSpecialCaracterNumber; i++) {
            int randIndexSpecial = random.nextInt(SpecialCaracter.length() - 1) + 1;
            arrStrSpecialChar[i] = SpecialCaracter.charAt(randIndexSpecial);
        }

        randSpecialCaracterNumberPart = String.valueOf(arrStrSpecialChar);

        return finalRandom = upperAlphabetPart + randSpecialCaracterNumberPart + lowerAlphabetPart
                + randNumberOfNumbersPart;

    }

} //End Subclass PasswordGenerator
