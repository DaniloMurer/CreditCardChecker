package sample;

public class Controller {

    /* Methode die die Kartennummer prüft */
    public boolean validateCardNumber(String cardNumber) {
        char[] cardNumberArr = new char[cardNumber.length()];
        cardNumberArr = cardNumber.toCharArray();
        int sum = 0;
        for (int i = 0; i < cardNumberArr.length; i++) {
            int temp = 0;
            String tempString = "";
            char[] tempArr = new char[2];
            int pickedNumber = Character.getNumericValue(cardNumberArr[i]);
            if ( i == 0) {
                temp = pickedNumber * 2;
                if (temp > 9) {
                    tempString = String.valueOf(temp);
                    tempArr = tempString.toCharArray();
                    temp = (Character.getNumericValue(tempArr[0]) + (Character.getNumericValue(tempArr[1])));
                    sum += temp;
                }
                else {
                    sum += pickedNumber * 2;
                }
            }
            else if ((i % 2) == 0) {
                temp = pickedNumber * 2;
                if (temp > 9) {
                    tempString = String.valueOf(temp);
                    tempArr = tempString.toCharArray();
                    temp = (Character.getNumericValue(tempArr[0]) + (Character.getNumericValue(tempArr[1])));
                    sum += temp;
                }
                else {
                    sum += pickedNumber * 2;
                }
            }
            else {
                sum += pickedNumber;
            }
        }

        if (sum % 10 == 0) {
            return true;
        }
        else {
            return false;
        }

    }
}
