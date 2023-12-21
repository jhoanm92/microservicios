package com.user.service.feing;

import com.user.model.Movement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "account-services", url = "http://localhost:5001/movements")
public interface MovementServiceFeint {

    @GetMapping()
    List<Movement> getAll();

    @PostMapping()
    Movement register(@RequestBody Movement movement);

    @PutMapping()
    Movement update(@RequestBody Movement movement);

    @GetMapping("/{id}")
    Movement getById(@PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);

    @GetMapping("/report")
    List<Movement> reports(@RequestParam LocalDateTime initDate, @RequestParam LocalDateTime endDate, @RequestParam Integer idClient);

}
