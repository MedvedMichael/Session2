package com.company;

public class TextEncoder {


    // коды: А - 1040, Я - 1071, а - 1072, я - 1103
    String encryptText(String text) {
        String encodedText = "";
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol >= 1040 && symbol <= 1103) {
                symbol++;
                if (symbol == 1104)
                    symbol = 1072;

                else if (symbol == 1072)
                    symbol = 1040;
            }
            encodedText += symbol;
        }
        return encodedText;
    }

    String decryptText(String text) {
        String decoded = "";
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol >= 1040 && symbol <= 1103) {
                symbol--;
                if (symbol == 1039)
                    symbol = 1071;
                else if (symbol == 1071)
                    symbol = 1103;
            }
            decoded += symbol;
        }
        return decoded;
    }

}
