package br.edu.ufrn.fidelity.service;

import br.edu.ufrn.fidelity.dto.BonusRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BonusService {

    private static final Logger log = LoggerFactory.getLogger(BonusService.class);

    private final Random random = new Random();

    private long failureStartTime = 0;

    public void processBonus(BonusRequest bonusRequest) throws InterruptedException {

        if(generateRandomNumber(0.1) && !isActiveFailure()) {
            failureStartTime = System.currentTimeMillis();
            Thread.sleep(2000);
        }

        if(isActiveFailure()) {
            Thread.sleep(2000);
        }

        if(bonusRequest.getUser() == null || bonusRequest.getBonus() == 0) {
            log.error("Bonus request is null");
            return;
        }

        log.info("User id " + bonusRequest.getUser() + " has " + (bonusRequest.getBonus() * 0.5) + " bonus");
    }

    private boolean isActiveFailure() {
        if (failureStartTime == 0) {
            return false;
        }
        long duration = System.currentTimeMillis() - failureStartTime;
        return duration < 30000;
    }

    public boolean generateRandomNumber(double percentage)  {
        double result = random.nextDouble();
        return result <= percentage;
    }
}
