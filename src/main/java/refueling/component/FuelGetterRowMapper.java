package refueling.component;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import refueling.model.FuelGetter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FuelGetterRowMapper implements RowMapper<FuelGetter> {


    @Override
    public FuelGetter mapRow(ResultSet resultSet, int i) throws SQLException {
        FuelGetter fuelGetter = new FuelGetter();
        fuelGetter.standartInit(resultSet.getString("name"));
        return fuelGetter;
    }
}
