package basics.elementary;

import java.lang.annotation.Repeatable;

public class Annotation {
}

@interface Persons {
    Person[] value();
}

@Repeatable(Persons.class)
@interface Person {
    String role();
}

@Person(role = "artist")
@Person(role = "coder")
@Person(role = "PM")
class SuperMan {
}