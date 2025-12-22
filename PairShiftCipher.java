public class PairShiftCipher implements Cipherable {
    private boolean useUppercase;

    public PairShiftCipher(boolean useUppercase) {
        this.useUppercase = useUppercase;
    }

    public boolean getUseUppercase() {
        return useUppercase;
    }

    public void setUseUppercase(boolean useUppercase) {
        this.useUppercase = useUppercase;
    }

    @Override
    public String toString() {
        return getDescription();
    }

    @Override
    public String getDescription() {
        return "Pair Shift Cipher, a keyless encryption method | Currently using " + (useUppercase ? "uppercase" : "lowercase") + " letters";
    }

    @Override
    public String encode(String plaintext) {
        plaintext = plaintext.toLowerCase();
        StringBuilder encodedText = new StringBuilder();

        int letterIndex = 0;
        char previousLetter = 0;

        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);

            if (currentChar < 'a' || currentChar > 'z') {
                encodedText.append(currentChar);
                continue;
            }

            if (letterIndex % 2 == 1) {
                int shiftAmount = previousLetter - 'a';
                char shiftedChar =
                        (char) ((currentChar - 'a' + shiftAmount) % 26 + 'a');
                encodedText.append(shiftedChar);
            } else {
                encodedText.append(currentChar);
            }

            previousLetter = currentChar;
            letterIndex++;
        }
        
        if (useUppercase) {
            return encodedText.toString().toUpperCase();
        } else {
            return encodedText.toString();
        }
    }



    @Override
    public String decode(String ciphertext) {
        ciphertext = ciphertext.toLowerCase();
        StringBuilder decodedText = new StringBuilder();

        int letterIndex = 0;
        char previousLetter = 0;

        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);

            if (currentChar < 'a' || currentChar > 'z') {
                decodedText.append(currentChar);
                continue;
            }

            char decodedChar;

            if (letterIndex % 2 == 1) {
                int shiftAmount = previousLetter - 'a';
                decodedChar =
                        (char) ((currentChar - 'a' - shiftAmount + 26) % 26 + 'a');
            } else {
                decodedChar = currentChar;
            }

            decodedText.append(decodedChar);
            previousLetter = decodedChar;
            letterIndex++;
        }

        if (useUppercase) {
            return decodedText.toString().toUpperCase();
        } else {
            return decodedText.toString();
        }
    }
}
