package fr.uvsq.doosa.gradletuto

import org.junit.Test

class MainTest {
    @Test
    void shouldReturnHello() {
        Main m = new Main()
        assert 'Hello' == m.returnHello()
    }
}
