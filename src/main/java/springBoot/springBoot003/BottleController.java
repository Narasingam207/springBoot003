package springBoot.springBoot003;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/bottle")
public class BottleController {

    @Autowired
    BottleService bottleService;

    @Autowired
    RestTemplate restTemplate;
@PostMapping()
public ResponseEntity<Integer> saveBottle(@RequestBody Bottle bottle)
{
    int bottle1 = bottleService.saveBottle(bottle);

    return new ResponseEntity<>(bottle1, HttpStatus.OK);
}
@GetMapping()
public ResponseEntity<Object> getAllBottles()
{
    List<Bottle> bottle1 = bottleService.getAllBottles();

    if(bottle1.size()==0)
    {
        ErrorMessage message=new ErrorMessage("There are no Bottles in this table");
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(bottle1,HttpStatus.OK);
}
@GetMapping("{id}")
public ResponseEntity<Object> getBottleById(@PathVariable("id") int id)
{
    Bottle bottle1 = bottleService.getBottleById(id);

    if(bottle1==null)
    {
        ErrorMessage message=new ErrorMessage("Bottle With id "+id+" doesn't exist");
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(bottle1,HttpStatus.OK);
}


@PutMapping("{id}")
public ResponseEntity<Object> updateBottle(@PathVariable ("id") int id,@RequestBody Bottle bottle)
{
    Bottle bottle1=bottleService.getBottleById(id);
    if(bottle1==null)
    {
        ErrorMessage message=new ErrorMessage("Bottle with id "+id+" doesn't exist");
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
    String bottle2 = bottleService.updateBottle(bottle, id);
    return new ResponseEntity<>(bottle2,HttpStatus.OK);
}
@DeleteMapping("{id}")
public ResponseEntity<Object> deleteBottleById(@PathVariable("id") int id)
{
    Bottle bottle3=bottleService.getBottleById(id);
    if(bottle3==null)
    {
        ErrorMessage message=new ErrorMessage("Bottle with id "+id+" doesn't exist");
        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
    String bottle1 = bottleService.deleteById(id);
    return new ResponseEntity<>(bottle1,HttpStatus.OK);
}


@GetMapping("/product/{product}")
public ResponseEntity<Object> getByBottleName(@PathVariable ("product") String product)
{
    List<Bottle> bottles=bottleService.getByBottleName(product);

    if(bottles.size()==0)
    {
        ErrorMessage errorMessage=new ErrorMessage("There is no Bottle with the product name "+product+" in the Bottle table");
        return  new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(bottles,HttpStatus.OK);

}

@PostMapping("/details")
public ResponseEntity<Integer> saveDetails(@RequestBody Details details)
{
    int details1 = bottleService.saveDetails(details);
    return new ResponseEntity<>(details1,HttpStatus.OK);
}
@GetMapping("/details")
public ResponseEntity<Object> getAllDetails()
{
    List<Details> details=bottleService.getAllDetails();

    if(details.size()==0)
    {
        ErrorMessage errorMessage=new ErrorMessage("They don't have any details in details table");

        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(details,HttpStatus.OK);
}
@GetMapping("/details/{dId}")
public ResponseEntity<Object> getDetailsById(@PathVariable ("dId") int dId)
{
    Details details1 = bottleService.getDetailsById(dId);

    if(details1==null)
    {
        ErrorMessage errorMessage=new ErrorMessage("There are no details with id "+dId+" in the details table");
        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(details1,HttpStatus.OK);
}

@PutMapping("/details/{dId}")
public ResponseEntity<Object> updateDetails(@RequestBody Details details,@PathVariable ("dId") int dId)
{

    Details details3=bottleService.getDetailsById(dId);
    if(details3==null)
    {
        ErrorMessage errorMessage=new ErrorMessage("Details with id "+dId+" doesn't exist to update");
        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
    String details1 = bottleService.updateDetails(details,dId);

    return new ResponseEntity<>(details1,HttpStatus.OK);

}

@DeleteMapping("/details/{dId}")
public ResponseEntity<Object> deleteDetailsById(@PathVariable("dId") int dId)
{
    Details details=bottleService.getDetailsById(dId);
    if(details==null)
    {
        ErrorMessage errorMessage=new ErrorMessage("Details with id "+dId+" doesn't exist");
        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }

    String details1 = bottleService.deleteDetailsById(dId);
    return new ResponseEntity<>(details1,HttpStatus.OK);
}
@GetMapping("/all")
public ResponseEntity<Object> getByCapacity()
{

    List<Bottle> capacity = bottleService.getByCapacity();

    if(capacity.size()==0)
    {
        ErrorMessage errorMessage=new ErrorMessage("There is no content in the table please try after some time");
        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(capacity,HttpStatus.OK);
}

@GetMapping("call")
    public ResponseEntity<Object> getAnotherApi()
{
    ResponseEntity<Object> response = restTemplate.getForEntity("http://localhost:8082/employee/emp/{id}", Object.class,1);
   return response;

}













}
