package org.example.individual.Pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.IMessage;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BooksPojo {
    private Integer id;

    @NotNull(message="name is required")
    private  String name;

    @NotNull(message="genre is required")
    private  String genre;

    @NotNull(message="donor id is required")
    private Integer donor_id;
}
