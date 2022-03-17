//    ______      __    __    __
//   / ____/___  / /_  / /_  / /__
//  / /   / __ \/ __ \/ __ \/ / _ \
// / /___/ /_/ / /_/ / /_/ / /  __/
// \____/\____/_.___/_.___/_/\___/

public  class ApplicationException  extends Exception {
   
    public ApplicationException (String s) {
       super(s) ;
    }

    public String toString() {
        return "NUMBER NOT IN THE LIMIT";
    }
}
