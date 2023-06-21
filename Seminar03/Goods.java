package Seminar03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Goods {
    private String name;
    private String country;
    private Integer weight;
    private Double price;
    private String grade;
}
