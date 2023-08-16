import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TriplesTest {

    @Test
    public void test3Triples() {
        int[] array = {1, 2, 4, 5, 6, 7};
        assertThat(Triples.countTriples(array)).isEqualTo(2);
    }

    @Test
    public void test0Triples() {
        int[] array = {1, 4, 7, 5, 4, 3};
        assertThat(Triples.countTriples(array)).isEqualTo(0);
    }

    @Test
    public void test4Triples() {
        int[] array = {1, 2, 3, 4, 5, 6};
        assertThat(Triples.countTriples(array)).isEqualTo(4);
    }

    @Test
    public void test3TriplesMinus() {
        int[] array = {1, 2, 4, 5, 6, 7};
        assertThat(Triples.countTripleMinus(array)).isEqualTo(2);
    }

    @Test
    public void test0TriplesMinus() {
        int[] array = {1, 4, 7, 5, 4, 3};
        assertThat(Triples.countTripleMinus(array)).isEqualTo(0);
    }

}
