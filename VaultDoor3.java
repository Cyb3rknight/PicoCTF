
//Intro : A ciphertext is encrypted text that is transformed from plaintext using an encryption algorithm. Lucky us, we have the reversePassword method, which is used to decrypt the password and recover the original plaintext.

class VaultDoor3 {
    static String CipheString = "jU5t_a_sna_3lpm18g947_u_4_m9r54f";
    public static void main(String args[]) {
        //Prints the cipher password CipheString to the console.
        System.out.println("Cipher password: " + CipheString);
        //It calls the reversePassword method, passing CipheString as an argument, and stores the result in pass.Check the reversePassword method below
        String pass = reversePassword(CipheString);
        // It creates a new string userInput by concatenating "picoCTF{" with pass and "}"
        String userInput = "picoCTF{" + pass + "}";
        //It prints "Enter vault password: " followed by userInput to the console. This is 
        System.out.print("Enter vault password: " + userInput);

    // ------------------------  NOT IMPORTANT PART ---------------    
    //  VaultDoor3 vaultDoor = new VaultDoor3();
    //     System.out.print("Enter vault password: "+userInput);
    //     String input = userInput.substring("picoCTF{".length(),userInput.length()-1);
	// if (vaultDoor.checkPassword(input)) {
	//     System.out.println("Access granted.");
	// } else {
	//     System.out.println("Access denied!");
    //     }
    }
    // ------------------------  NOT IMPORTANT PART ---------------   


    // Our security monitoring team has noticed some intrusions on some of the
    // less secure doors. Dr. Evil has asked me specifically to build a stronger
    // vault door to protect his Doomsday plans. I just *know* this door will
    // keep all of those nosy agents out of our business. Mwa ha!
    //
    // -Minion #2671


    // The 'checkPassword' method takes a string 'password' as an argument and returns a boolean value indicating whether the password is valid or not.
    // If you want to try you can, but i used picoctf to check if my answer is right (it's with the not important section that you 'checkPassword')
    public boolean checkPassword(String password) {
        //checks the length of 'password' is not equal to 32 if so,it returns 'false'
        if (password.length() != 32) {
            return false;
        }
        //It creates a new character array buffer with a length of 32
        char[] buffer = new char[32];
        //It uses four loops to populate buffer with characters from password in a specific order
        int i;
        //The first 8 characters are copied from password to buffer in the same order
        for (i=0; i<8; i++) {
            buffer[i] = password.charAt(i);
        }
         //The next 8 characters are copied from password to buffer in reverse order, starting from the 23rd character
        for (; i<16; i++) {
            buffer[i] = password.charAt(23-i);
        }
        // The next 8 characters are copied from password to buffer in reverse order, starting from the 46th character
        for (; i<32; i+=2) {
            buffer[i] = password.charAt(46-i);
        }

        // The last 8 characters are copied from password to buffer in the same order, starting from the 17th character
        for (i=31; i>=17; i-=2) {
            buffer[i] = password.charAt(i);
        }
         // Create a new string s from the character array buffer
        String s = new String(buffer);

         // Check if the decrypted password s is equal to the original cipher password
        return s.equals("jU5t_a_sna_3lpm18g947_u_4_m9r54f");
    }


    //The method takes a String parameter password and returns a new String value
    public static String reversePassword(String password) {

//         The method declares two local variables:

  // buffer: a character array with a length of 32
        char[] buffer = new char[32];
  // i: an integer variable used as an index
        int i;
    
        //The first loop iterates from i = 0 to i < 8. It copies the first 8 characters of the password string to the buffer array in the same order
        for (i = 0; i < 8; i++) {
          buffer[i] = password.charAt(i);
        }

        //The second loop iterates from i = 8 to i < 16. It copies the next 8 characters of the password string to the buffer array in reverse order, starting from the 23rd character
        for (; i < 16; i++) {
          buffer[i] = password.charAt(23 - i);
        }

        //The third loop iterates from i = 16 to i < 32 in increments of 2. It copies the next 8 characters of the password string to the buffer array in reverse order, starting from the 46th character
        for (; i < 32; i += 2) {
          buffer[i] = password.charAt(46 - i);

          //The fourth loop iterates from i = 31 to i >= 17 in decrements of 2. It copies the last 8 characters of the password string to the buffer array in the same order
        }
        for (i = 31; i >= 17; i -= 2) {
          buffer[i] = password.charAt(i);
        }
    
        //Finally, the method returns a new String object created from the buffer character array.
        return new String(buffer);
      }
}
