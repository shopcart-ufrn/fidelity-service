package br.edu.ufrn.fidelity.controller;

import br.edu.ufrn.fidelity.dto.BonusRequest;
import br.edu.ufrn.fidelity.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bonus")
public class BonusController {

    @Autowired
    private BonusService bonusService;

    @PostMapping
    public ResponseEntity<Integer> bonus(@RequestBody BonusRequest bonusRequest) throws InterruptedException {
        bonusService.processBonus(bonusRequest);
        return ResponseEntity.ok(200);
    }
}
