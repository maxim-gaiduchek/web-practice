package app.model;

import app.datasource.Service;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private final int count;
    private final int maleCount;
    private final Map<String, Integer> operators = new HashMap<>();

    public Statistics(Service service) {
        count = service.countAnswers();
        maleCount = service.countMaleAnswers();

        operators.put("K", service.countOperators("K"));
        operators.put("M", service.countOperators("M"));
        operators.put("L", service.countOperators("L"));
        operators.put("P", service.countOperators("P"));
        operators.put("U", service.countOperators("U"));
    }

    public int getCount() {
        return count;
    }

    public int getMalesCount() {
        return maleCount;
    }

    public int getFemalesCount() {
        return count - maleCount;
    }

    public int getMalesPercentage() {
        return (int) Math.round((double) maleCount / count * 100);
    }

    public int getFemalesPercentage() {
        return 100 - getMalesPercentage();
    }

    public int getOperatorCount(String operator) {
        return operators.get(operator);
    }

    public int getOperatorPercentage(String operator) {
        return (int) Math.round((double) getOperatorCount(operator) / count * 100);
    }
}
