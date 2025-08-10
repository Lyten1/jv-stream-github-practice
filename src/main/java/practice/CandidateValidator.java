package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final int YEARS_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getYearsInUkr(candidate.getPeriodsInUkr()) >= YEARS_IN_UKR;
    }

    private int getYearsInUkr(String period) {
        String[] data = period.split("-");
        return Integer.parseInt(data[1]) - Integer.parseInt(data[0]);
    }
}
