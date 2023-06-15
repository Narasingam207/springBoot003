package springBoot.springBoot003;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BottleService {

    @Autowired
    BottleRepository bottleRepository;

    public int saveBottle(Bottle bottle) {
        return bottleRepository.saveBottle(bottle);
    }

    public List<Bottle> getAllBottles() {
        return bottleRepository.getAllBottles();
    }

    public Bottle getBottleById(int id) {
        return bottleRepository.getBottleById(id);
    }

    public String updateBottle(Bottle bottle, int id) {

        return bottleRepository.updateBottle(bottle,id);
    }

    public String deleteById(int id) {

        return bottleRepository.deleteById(id);
    }

    public List<Bottle> getByBottleName(String product) {
        return bottleRepository.getByBottleName(product);
    }

    public int saveDetails(Details details) {
        return bottleRepository.saveDetails(details);
    }

    public List<Details> getAllDetails() {
        return bottleRepository.getAllDetails();
    }

    public Details getDetailsById(int dId)
    {
        return bottleRepository.getDetailsById(dId);
    }

    public String updateDetails(Details details, int dId) {
        return bottleRepository.updateDetails(details,dId);
    }

    public String deleteDetailsById(int dId) {
        return bottleRepository.deleteDetails(dId);
    }

    public List<Bottle> getByCapacity() {
        return bottleRepository.getByCapacity();
    }
}
