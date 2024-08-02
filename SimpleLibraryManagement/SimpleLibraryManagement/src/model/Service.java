package model;

import java.util.Date;

public interface Service {
    Date getDueDate();
    void setDueDate();
    boolean isAvailable();
    void setIsAvailable(boolean value);
}
