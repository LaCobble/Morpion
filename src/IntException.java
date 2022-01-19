public  class IntException  extends Exception {
   
    public IntException (String s) {
       super(s) ;
    }

    public String toString() {
        return "NOT A INTEGER";
    }
}