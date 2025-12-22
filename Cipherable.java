/*
* Requires an encode and decode method, alongside a getDescription method.
* */
public interface Cipherable {
    public String encode(String plaintext);
    public String decode(String ciphertext);

    public String getDescription();
}