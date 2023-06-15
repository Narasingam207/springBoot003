package springBoot.springBoot003;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="details")
public class Details {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "dId")
    private int dId;

    private String  noOfUsers;

    private String certified;

    private String safety;

    private String reUsable;

}
