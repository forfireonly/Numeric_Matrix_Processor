
class BigIntegerConverter {

    /**
     * @param number string representing the number
     * @return BigInteger instance
     */
    java.math.BigInteger number;
    public static Number getBigInteger(String number) {
        return  new java.math.BigInteger(number); // create BigIntegere instance here
    }
}