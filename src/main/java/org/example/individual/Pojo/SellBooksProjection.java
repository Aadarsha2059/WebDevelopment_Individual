package org.example.individual.Pojo;

public interface SellBooksProjection {

    Integer getId();
    Integer getBookId();
    String getBookName();
    String getGenre();
    Integer getBookPrice();
    String getBookCondition();
    Integer getSeekerId();
    Integer getUserId();

    String getImage();
}
