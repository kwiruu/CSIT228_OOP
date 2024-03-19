public class BruteForceRunnable implements Runnable {
    int position, id;
    char start;
    static String pass;

    public static boolean isCracked = false;
    public BruteForceRunnable(int id, char start, int position) {
        this.id = id;
        this.start = start;
        this.position = position;
    }

    private String newATK(String atk) {
        return atk.substring(0, position) + start + atk.substring(position);
    }

    @Override
    public void run() {
        int i ;
        int len = pass.length();
        String atk = "a".repeat(len - 1);

        while( !newATK(atk).equals(pass) && !isCracked) {
            System.out.println("#" + id + " = " + newATK(atk));

            for(i = atk.length() - 1; i >= 0 && atk.charAt(i) == 'z'; i-- );

            if (i < 0) {
                return;
            }


            String first = atk.substring(0, i);
            char next = (char) (atk.charAt(i) + 1);

            String after = "a".repeat(len - i - 2);
            atk = first + next + after;
        }

        if(newATK(atk).equals(pass)) {

            isCracked = true;
            System.out.println("Found: " + newATK(atk));
            System.out.println("Cracked ://");
        }
    }
}