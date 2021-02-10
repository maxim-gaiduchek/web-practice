package app.model;

import java.util.Collection;

public class ResultsCalculator {

    private final Collection<UserRecord> records;

    public ResultsCalculator(Collection<UserRecord> records) {
        this.records = records;
    }

    public int count() {
        return records.size();
    }

    public int getMalesCount() {
        return (int) records.stream()
                .filter(r -> r.getSex().equals("male"))
                .count();
    }

    public int getFemalesCount() {
        return records.size() - getMalesCount();
    }

    public int getMalesPercentage() {
        return (int) Math.round((double) getMalesCount() / records.size() * 100);
    }

    public int getFemalesPercentage() {
        return 100 - getMalesPercentage();
    }

    public int getOperatorCount(String operator) {
        return (int) records.stream()
                .filter(r -> r.getOperators().contains(operator))
                .count();
    }

    public int getOperatorPercentage(String operator) {
        return (int) Math.round((double) getOperatorCount(operator) / records.size() * 100);
    }
}
