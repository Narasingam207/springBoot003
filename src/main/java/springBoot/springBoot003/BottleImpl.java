package springBoot.springBoot003;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface BottleImpl {


    int saveBottle(Bottle bottle);

    List<Bottle> getAllBottles();

    Bottle getBottleById(int id);

    String updateBottle(Bottle bottle, int id);

    String deleteById(int id);

    List<Bottle> getByBottleName(String product);

    int saveDetails(Details details);

    List<Details> getAllDetails();

    Details getDetailsById(int dId);

    String updateDetails( Details details,int dId);


    String deleteDetails(int dId);

    List<Bottle> getByCapacity();
}
