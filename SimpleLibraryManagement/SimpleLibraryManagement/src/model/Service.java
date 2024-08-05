package model;

import java.util.Date;

public class Service {
    private Date dueDate;
    private boolean isAvailable;
    public Date getDueDate(){
        return dueDate;
    }
    void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }
    public void setIsAvailable(boolean value){
        this.isAvailable = value;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    
    
} 
