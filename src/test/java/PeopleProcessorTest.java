import com.cgi.boat.interview.PeopleProcessor;
import com.cgi.boat.interview.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleProcessorTest {

    @Test
    public void testLastnamesByFirstname() {
        List<Person> people = Arrays.asList(
                new Person("John","Doe"),
                new Person("John","Silver"),
                new Person("Peter","Doe")
        );
        Map<String,List<String>> expected = new HashMap<>();
        expected.put("John",Arrays.asList("Doe","Silver"));
        expected.put("Peter",Arrays.asList("Doe"));

        Map<String,List<String>> actual = PeopleProcessor.lastnamesByFirstname(people);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testFirstnamesByLastname() {
        List<Person> people = Arrays.asList(
                new Person("John","Doe"),
                new Person("John","Silver"),
                new Person("Peter","Doe")
        );
        Map<String,List<String>> expected = new HashMap<>();
        expected.put("Doe",Arrays.asList("John","Peter"));
        expected.put("Silver",Arrays.asList("John"));

        Map<String,List<String>> actual = PeopleProcessor.firstnamesByLastname(people);

        Assertions.assertEquals(expected,actual);
    }
}
