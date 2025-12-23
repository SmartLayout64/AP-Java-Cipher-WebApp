public class CaesarCipher implements Cipherable {
    private int key;

    public CaesarCipher(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }

    @Override
    public String getDescription() {
        return "Caesar Cipher with shift key " + key + " | A -> " + this.encode("A");
    }

    @Override
    public String encode(String text) {
        int shift = ((this.key % 26) + 26) % 26;
        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encodedText.append((char) ((c - base + shift) % 26 + base));
            } else {
                encodedText.append(c);
            }
        }
        return encodedText.toString();
    }

    @Override
    public String decode(String text) {
        int shift = ((this.key % 26) + 26) % 26;
        StringBuilder decodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                decodedText.append((char) ((c - base - shift + 26) % 26 + base));
            } else {
                decodedText.append(c);
            }
        }
        return decodedText.toString();
    }

    public static int generateRandomKey() {
        return (int) (Math.random() * 25) + 1;
    }

    public static String getGenericDescription() {
        return "Shifts each character by a key";
    }
}
