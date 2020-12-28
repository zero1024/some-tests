package feature.kotlin

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MockkTest {

    @Test
    internal fun testMock() {
        val map = mockk<HashMap<String, Int>>()
        every { map["one"] } returns 1
        assertThat(map["one"]).isEqualTo(1)
    }
}