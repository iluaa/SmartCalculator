public class Hashing {
    //String log = LoginWindow.login.getText();
    //String password = new String (LoginWindow.pass.getPassword());
    //Cipher cipher = Cipher.getInstance("AES");
    //SecretKey key = KeyGenerator.getInstance("AES").generateKey();



    public static String hashLogin () {
        String log = LoginWindow.login.getText();
        int hashLogin = 0;
        byte[] logByte = log.getBytes();
        for (int i=0; i<logByte.length; i++){
            hashLogin = logByte[i]*10;
            //System.out.print(logByte[i]);
            //System.out.print(hashLogin);
        }

        return String.valueOf(hashLogin);

    }

    public static String hashPassword () {
        String password = new String (LoginWindow.pass.getPassword());
        int hashPass = 0;
        byte[] passByte = password.getBytes();

        for (int i=0; i<passByte.length; i++){
            hashPass = passByte[i]*10;
            //System.out.print(passByte[i]);
            //System.out.print(hashPass);
        }
        return String.valueOf(hashPass);

    }

}
