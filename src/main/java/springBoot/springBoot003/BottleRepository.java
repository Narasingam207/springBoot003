package springBoot.springBoot003;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BottleRepository implements BottleImpl {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public int saveBottle(Bottle bottle) {
        return jdbcTemplate.update("insert into bottle (colour,capacity,price,weight,product) values (?,?,?,?,?)",new Object[]{
                bottle.getColour(),bottle.getCapacity(),bottle.getPrice(),bottle.getWeight(),bottle.getProduct()
        });
    }

    @Override
    public List<Bottle> getAllBottles() {
        try {
            return jdbcTemplate.query("select * from bottle", new BeanPropertyRowMapper<>(Bottle.class));
        } catch (Exception e)
        {

            return null;
        }
    }

    @Override
    public Bottle getBottleById(int id) {
        try {
            return jdbcTemplate.queryForObject("select * from bottle where id=?", new BeanPropertyRowMapper<>(Bottle.class), id);
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public String updateBottle(Bottle bottle, int id) {
        return jdbcTemplate.update("update bottle set colour=?,capacity=?,price=?,weight=?,product=? where id=? ",new Object[]{
                bottle.getColour(),bottle.getCapacity(),bottle.getPrice(),bottle.getWeight(),bottle.getProduct(),id
        })+" Bottle Updated Successfully";
    }

    @Override
    public String deleteById(int id) {
        return jdbcTemplate.update("delete from bottle where id=?",id)+" Bottle deleted Successfully";
    }

    @Override
    public List<Bottle> getByBottleName(String product) {
        try {
            return jdbcTemplate.query("select * from bottle where product=?", new BeanPropertyRowMapper<>(Bottle.class), product);
        }catch (Exception e)
        {
            return  null;
        }
    }

    @Override
    public int saveDetails(Details details) {
        return jdbcTemplate.update("insert into details (certified,no_of_users,re_usable,safety) values(?,?,?,?)",new Object[]{
                details.getCertified(),details.getNoOfUsers(),details.getReUsable(),details.getSafety()
        }) ;
    }

    @Override
    public List<Details> getAllDetails() {
        try {
            return jdbcTemplate.query("select * from details", new BeanPropertyRowMapper<>(Details.class));
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Details getDetailsById(int dId) {
        try {
            return jdbcTemplate.queryForObject("select * from details where d_id=?", new BeanPropertyRowMapper<>(Details.class), dId);
        } catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public String updateDetails(Details details,int dId) {
        return jdbcTemplate.update("update details set certified=?,no_of_users=?,re_usable=?,safety=? where d_id=?",new Object[]{
                details.getCertified(),details.getNoOfUsers(),details.getReUsable(),details.getSafety(),dId
        } )+" Details updated successfully";
    }

    @Override
    public String deleteDetails(int dId) {
        return jdbcTemplate.update("delete from details where d_id=?",dId)+" Deleted Successfully";
    }

    @Override
    public List<Bottle> getByCapacity() {
        try {
            return jdbcTemplate.query("select * from bottle join details on bottle.id=details.d_id order by capacity desc", new RowMapper<Bottle>() {
                @Override
                public Bottle mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Bottle bottle = new Bottle();
                    bottle.setId(rs.getInt("id"));
                    bottle.setColour(rs.getString("colour"));
                    bottle.setCapacity(rs.getString("capacity"));
                    bottle.setPrice(rs.getInt("price"));
                    bottle.setProduct(rs.getString("product"));
                    bottle.setWeight(rs.getString("weight"));
                    Details details = new Details();
                    details.setDId(rs.getInt("d_id"));
                    details.setSafety(rs.getString("safety"));
                    details.setCertified(rs.getString("certified"));
                    details.setReUsable(rs.getString("re_usable"));
                    details.setNoOfUsers(rs.getString("no_of_users"));
                    bottle.setDetails(details);
                    return bottle;
                }
            });
        } catch (Exception e)
        {
            return null;
        }
    }



}
