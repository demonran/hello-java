package io.github.lura.etl.flight;

import io.github.lura.etl.core.AbstractEtl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ description: FlightEtl
 * @ author: Liu Ran
 * @ data: 7/7/23 12:47
 */
public class FlightEtl extends AbstractEtl<OldFlight, NewFlight> {


    @Override
    public OldFlight extract(ResultSet resultSet) throws SQLException {
        OldFlight oldFlight = new OldFlight();
        oldFlight.setUsername(resultSet.getString("username"));
        oldFlight.setId(resultSet.getLong("id"));
        return oldFlight;
    }

    @Override
    public void load(NewFlight obj, PreparedStatement ps) throws SQLException {
        ps.setLong(1, obj.getId());
        ps.setString(2, obj.getUsername());
    }

    @Override
    public NewFlight transform(OldFlight oldObj) {
        NewFlight newFlight = new NewFlight();
        newFlight.setId(oldObj.getId());
        newFlight.setUsername(oldObj.getUsername());
        return newFlight;
    }
}
