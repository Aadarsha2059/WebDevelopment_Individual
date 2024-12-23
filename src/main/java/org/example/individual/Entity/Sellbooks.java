package org.example.individual.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sellbook")
@Setter
@Getter

public class Sellbooks {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_gen")
    @SequenceGenerator(name = "book_seq_genn", sequenceName = "book_seq", allocationSize = 1, initialValue = 1)

    @Id
    private Integer id;

    @Column(name="bookname", length = 255)
    private String bookname;

    @Column(name="genre",length = 255)
    private String genre;

    @Column(name="bookprice", length = 255)
    private String bookprice;

    @Column(name="bookcondition", length = 255)
    private String bookcondition;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "books_user_id"))
    private User user;

    public void setImage(String imageBase64) {
    }

    public String getImage() {

        return "";
    }
}
