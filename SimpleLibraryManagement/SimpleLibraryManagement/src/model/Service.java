package model;

import java.io.Serializable;
import java.util.Date;

public abstract class Service implements Serializable{
    private static final long serialVersionUID = 1L;
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
