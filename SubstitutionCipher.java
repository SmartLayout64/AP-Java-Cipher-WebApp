public class SubstitutionCipher implements Cipherable {
    private String key;

    public SubstitutionCipher(String key) {
        if (key.length() != 26) {
            System.out.println("Error: Key must be 26 characters long, defaulting to QWERTY key.");
            this.key = "QWERTYUIOPASDFGHJKLZXCVBNM";
        } else {
            this.key = key;
        }
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        if (key.length() != 26) {
            System.out.println("Error: Key must be 26 characters long, defaulting to QWERTY key.");
            this.key = "QWERTYUIOPASDFGHJKLZXCVBNM";
        } else {
            this.key = key;
        }
    }

    @Override
    public String toString() {
        return this.getDescription();
    }

    @Override
    public String getDescription() {
        return "Substitution Cipher with key: " + this.key;
    }

    @Override
    public String encode(String plaintext) {
        StringBuilder encoded = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int index = c - base;
                encoded.append(this.key.charAt(index));
            } else {
                encoded.append(c);
            }
        }
        return encoded.toString();
    }

    @Override
    public String decode(String ciphertext) {
        StringBuilder decoded = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int index = this.key.indexOf(c);
                decoded.append((char) (base + index));
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }
}
