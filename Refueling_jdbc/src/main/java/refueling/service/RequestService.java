package refueling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import refueling.component.FuelGetterRowMapper;
import refueling.model.Car;
import refueling.model.FuelGetter;
import refueling.model.Request;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

@Service
@Scope("prototype")
public class RequestService {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private FuelGetterRowMapper fuelGetterRowMapper;
    @Autowired
    private Car car;
    @Autowired
    private List<FuelGetter> fuelGetterList;

    public String start(){
        Random rnd = new Random();
        FuelGetter nowFG;
        nowFG = fuelGetterList.get(rnd.nextInt(fuelGetterList.size()));
        while (!nowFG.getState()) {
            nowFG = fuelGetterList.get(rnd.nextInt(fuelGetterList.size()));
        }
        Request request = new Request(car,nowFG,car.toFull());
        nowFG.setState(false);
        return request.toString();
    }

    public void Test() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from fuelGetter");
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + " " + name + ";");
            }
        }
    }
    public void TestWithTemplate() throws SQLException {
        List<FuelGetter> listFuelGetters = jdbcTemplate.query("select * from fuelGetter", fuelGetterRowMapper);
        listFuelGetters.forEach(System.out::println);
    }
}
