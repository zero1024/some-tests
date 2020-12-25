package concurrent.java;

import org.junit.jupiter.api.Test;

public class CompilerTests {

    interface FunAction {
        void doSome();
    }

    void callFunAction(FunAction action) {
        action.doSome();
    }

    @Test
    public void testFunInterfaceCompilation() {
        callFunAction(() -> System.out.println("Hello"));
    }
}
