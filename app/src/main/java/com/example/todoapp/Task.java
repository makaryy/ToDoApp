package com.example.todoapp;

import java.util.Date;

public class Task {

    private String tytulZadania;
    private String trescZadania;
    private String dataZadania;

public Task (String tytulZadania, String dataZadania, String trescZadania){
    this.tytulZadania = tytulZadania;
    this.dataZadania = dataZadania;
    this.trescZadania = trescZadania;

}


    public String getTytulZadania(){
    return (this.tytulZadania);
}

public void setTytulZadania(String tytulZadania){
    this.tytulZadania = tytulZadania;
}

public String getDataZadania(){
    return (this.dataZadania);
}

public void setDataZadania(String dataZadania) {
    this.dataZadania = dataZadania;
}

    public String getTrescZadania(){
    return (this.trescZadania);
}

public void setTrescZadania(String trescZadania){
    this.trescZadania = trescZadania;
}

}
