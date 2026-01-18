package p374_guess_number_higher_or_lower;

class GuessGame {

    private int num;

    GuessGame(int num) {
        this.num = num;
    }

    int guess(int num) {
        if (num > this.num) {
            return -1;
        } else if (num < this.num) {
            return 1;
        } else {
            return 0;
        }
    }
}
