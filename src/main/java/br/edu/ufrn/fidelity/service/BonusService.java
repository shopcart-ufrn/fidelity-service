package br.edu.ufrn.fidelity.service;

import br.edu.ufrn.fidelity.dto.BonusRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BonusService {

    private static final Logger log = LoggerFactory.getLogger(BonusService.class);

    public void processBonus(BonusRequest bonusRequest) {
        if(bonusRequest.getUser() == null || bonusRequest.getBonus() == 0) {
            log.error("Bonus request is null");
            return;
        }
        log.info("User id " + bonusRequest.getUser() + " has " + (bonusRequest.getBonus() * 0.5) + " bonus");    }
}
