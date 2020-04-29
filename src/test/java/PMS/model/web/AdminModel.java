package PMS.model.web;

public class AdminModel {
    private Integer budget;
    private int startDate;
    private int endDate;
    private String definitiveBudget;

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public String getDefinitiveBudget() {
        return definitiveBudget;
    }

    public void setDefinitiveBudget(String definitiveBudget) {
        this.definitiveBudget = definitiveBudget;
    }
}
