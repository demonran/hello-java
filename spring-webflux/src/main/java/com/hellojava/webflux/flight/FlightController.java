package com.hellojava.webflux.flight;

import com.hellojava.webflux.flight.vo.FimsFlightVo;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * FlightController
 *
 * @author Liu Ran
 */


@RestController
@RequiredArgsConstructor
@RequestMapping("flight")
public class FlightController {

    private final DatabaseClient databaseClient;

//    private final JdbcTemplate jdbcTemplate;

    @GetMapping("r2dbc")
    public Flux<FimsFlightVo> listR2dbc() {
        LocalDateTime baseTime = LocalDateTime.now().minus(24, ChronoUnit.HOURS);
        return databaseClient.sql("select f.id, f.airline_icao_code, f.airline_iata_code, f.flight_no, f.direction , f.route_type, f.fly_task_code, f.operation_date, f.sche_date, f.sche_time , f.eldt, f.etot, f.aldt, f.atot, f.normal_status , f.int_normal_status, f.abnormal_status, f.adjust_sche_time_reason, f.share_flight_nos, f.fpl_alt_airports , f.air_corridor, f.vip_level, f.runway_code, f.reg_no, f.aerocraft_type_icao_code , f.terminal_code, f.int_terminal_code, f.flowed, f.efs_status, f.publish_time , f.update_time, f.lock_eldt, f.sche_transit_time from fmc_d_flight f where ((f.end_time is not null and f.end_time >=(:baseTime)) or f.end_time is null) and f.flight_type = 'PUBLISHED' and f.airport = 'XIY' order by f.id")
                             .bind("baseTime", baseTime)
                             .map(it -> {
                                 FimsFlightVo vo = new FimsFlightVo();
                                 vo.setFlightId(it.get("id", Long.class));
                                 return vo;
                             })
                             .all();
    }

//    @GetMapping("jdbc")
//    public List<Flight> listJdbc() {
//        return jdbcTemplate.queryForList("", Flight.class);
//    }
}
