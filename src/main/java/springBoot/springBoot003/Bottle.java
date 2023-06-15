package springBoot.springBoot003;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bottle")
public class Bottle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String colour;
    private String capacity;
    private int price;
    private String weight;
    private String product;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "dId")
    private Details details;
}
