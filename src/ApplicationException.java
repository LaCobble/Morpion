public  class ApplicationException  extends Exception {
   
    public ApplicationException (String s) {
       super(s) ;
    }

    public String toString() {
        return "NUMBER NOT IN THE LIMIT";
    }
}