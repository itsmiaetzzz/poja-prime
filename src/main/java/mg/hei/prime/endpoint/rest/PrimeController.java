package mg.hei.prime.endpoint.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Random;

@RestController
public class PrimeController {

    @GetMapping("new-prime")
    public String generateNewPrime() {
        BigInteger primeNumber = BigInteger.probablePrime(10000, new Random());
        return primeNumber.toString();
    }
}
