package p495_teemo_attacking;

class SolutionVariants {

    interface Solver {
        int findPoisonedDuration(int[] timeSeries, int duration);
    }

    // If the next attack happens after poison ended, add full duration.
    // If it happens during poisoning, add only the extra uncovered part.
    static class IntervalEndSolver implements Solver {
        @Override
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            if (timeSeries.length == 0 || duration == 0) {
                return 0;
            }

            int total = 0;
            int poisonEnd = 0;

            for (int attackTime : timeSeries) {
                if (attackTime >= poisonEnd) {
                    total += duration;
                } else {
                    total += attackTime + duration - poisonEnd;
                }
                poisonEnd = attackTime + duration;
            }

            return total;
        }
    }

    // Avoids the final total += duration.
    // Starts with the last interval already counted.
    static class GapSolver implements Solver {
        @Override
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            if (timeSeries.length == 0 || duration == 0) {
                return 0;
            }

            int total = duration;

            for (int i = 1; i < timeSeries.length; i++) {
                total += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
            }

            return total;
        }
    }
}
