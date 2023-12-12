import java.math.BigInteger;

public class PrimeController {
    @GetMapping("new-prime"){
        public BigInteger primeNumber = BigInteger.probablePrime(10000, new Random());
        return primeNumber
    }
}
/*Implémentez puis déployez en preprod GET /new-prime, qui retourne un nombre probablement premier à 10_000 bits grâce à BigInteger::probablePrime. */