package dominio;

import java.time.LocalDate;

public class Mentoring extends Content{
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public double calculateExp() {
        return DEFAULT_EXP * 10d;
    }

    @Override
    public String toString() {
        return "Mentoring {" + "\n" +
                "title = " + getTitle() + "\n" +
                "description = " + getDescription() + "\n" +
                "date = " + date +
                '}';
    }
}
