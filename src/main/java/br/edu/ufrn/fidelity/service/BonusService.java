package br.edu.ufrn.fidelity.service;

import br.edu.ufrn.fidelity.dto.BonusRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BonusService {

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
