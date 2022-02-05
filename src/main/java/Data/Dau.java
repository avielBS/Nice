package Data;

import java.util.Objects;

public class Dau {

    private int userId;
    private String date;
    private String hour;

    public Dau(int userId, String date, String hour){
        this.userId = userId;
        this.date =date;
        this.hour = hour;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dau dau = (Dau) o;
        return userId == dau.userId &&
                date.equals(dau.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, date);
    }
}
