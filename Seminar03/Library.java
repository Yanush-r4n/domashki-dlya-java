package Seminar03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Library {
    private String name;
    private String authorsLastName;
    private Integer price;
    private Integer year;
    private Integer pages;
}
