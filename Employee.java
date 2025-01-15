public class Employee {
    int _vacationDaysTaken;
    int _sickLeaveDaysTaken;
   
    public double computeDueTerminationPayment(int startYear) {
    double vacationValue;
    double payment = 0.0;
    double salary = 0.0;
    int vacationDays;
    double bonusDays = 0.0;
    int years;
   
    years = getYears(startYear);  
    
    vacationValue = calculateVacationValue(years);
   
    for (int i = 0; i < years; i++)
    payment += profit(payment, startYear + i);
   
    for(int i = startYear; i < startYear + years; i++)
    salary += getAvgYearPayment(i) * (1.0 - getTaxRate(i));
   
    return salary + payment + vacationValue;
    }

    //Task 1A
    private double calculateVacationValue(int years) {
    double vacationDays;
    double bonusDays = 0.0;

    if (years < 5)
        vacationDays = 12 * years - _vacationDaysTaken;
    else
        vacationDays = 60+(years-5)*(12+(years-5)*2)-_vacationDaysTaken;

    if (_sickLeaveDaysTaken < years * 2)
        bonusDays = years * 0.5;

    return (vacationDays + bonusDays) * dayOffPayRate();
}

private int getYears(int startYear) {
    int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    return currentYear - startYear;
}
}
