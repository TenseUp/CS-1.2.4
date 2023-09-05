public class WordMatch {
    private String secret;

    public WordMatch(String secret) {
        this.secret = secret;
    }

    public int scoreGuess(String guess) throws IllegalArgumentException{
        if(guess.length()==0) throw new IllegalArgumentException("Your guess cannot be an empty String!");
        if(guess.length()>secret.length()) throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        int count = 0;
        int guessLength = guess.length();
        int secretLength = secret.length();

        for (int i = 0; i <= secretLength - guessLength; i++) {
            if (secret.substring(i, i + guessLength).equals(guess)) {
                count++;
            }
        }

        return count * (guessLength * guessLength);
    }

    public String findBetterGuess(String guess1, String guess2) {
        int score1 = scoreGuess(guess1);
        int score2 = scoreGuess(guess2);

        if (score1 != score2) {
            if (score1 > score2) return guess1;
            else return guess2;
        } else {
            if (guess1.compareTo(guess2) > 0) return guess1;
            else return guess2;
        }
    }
}