package feature.java;

import org.junit.jupiter.api.Test;

public class SealedClassesTest {

    @Test
    void testSealedClasses() {
        var leftHand = new LeftHand();
        var rightHand = new RightHand();

        Hand hand = leftHand;

        if (hand instanceof LeftHand) {
            System.out.println("It is a left hand!");
        } else {
            rightHand = (RightHand) hand;
        }

    }
}

sealed class Hand permits LeftHand, RightHand {

}

non-sealed class LeftHand extends Hand {
}

final class RightHand extends Hand {
    void writeSomething(String something) {
        System.out.println(something);
    }
}
