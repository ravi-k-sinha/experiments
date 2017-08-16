package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSample {

    private List<Person> roster;
    private List<Album> albums;

    private void commonInit() {
        roster = new ArrayList<>();
        roster.add(new Person("Ram", Person.Sex.MALE, 42));
        roster.add(new Person("Sita", Person.Sex.FEMALE, 35));
        roster.add(new Person("Laxman", Person.Sex.MALE, 40));
        roster.add(new Person("Gandhari", Person.Sex.FEMALE, 56));
        roster.add(new Person("Yudhisthir", Person.Sex.MALE, 140));
        roster.add(new Person("Kaikai", Person.Sex.FEMALE, 88));

        albums = new ArrayList<>();

        List<Track> trackSet1 = new ArrayList<>();
        trackSet1.add(new Track(3));
        trackSet1.add(new Track(2));

        albums.add(new Album("Pink Floyd", trackSet1));

        List<Track> trackSet2 = new ArrayList<>();
        trackSet2.add(new Track(4));
        trackSet2.add(new Track(5));

        albums.add(new Album("Bee Gees", trackSet2));

        List<Track> trackSet3 = new ArrayList<>();
        trackSet3.add(new Track(2));
        trackSet3.add(new Track(2));
        trackSet3.add(new Track(4));

        albums.add(new Album("A R Rahman", trackSet3));

        List<Track> trackSet4 = new ArrayList<>();
        trackSet4.add(new Track(1));

        albums.add(new Album("Abhijeet", trackSet4));
    }

    private void normalFunction() {
        commonInit();
        for (Person p : roster) {
            if (p.getGender() == Person.Sex.MALE) {
                System.out.println(p.getName());
            }
        }
    }

    private void lambdaFunction() {
        commonInit();
        roster
            .stream()
            .filter(p -> p.getGender() == Person.Sex.MALE)
            .forEach(p -> System.out.println(p.getName()));
    }

    private void normalFunction2() {
        commonInit();

        List<Album> favs = new ArrayList<>();
        for (Album a : albums) {
            boolean hasFavorite = false;
            for (Track t : a.getTracks()) {
                if (t.getRating() >= 4) {
                    hasFavorite = true;
                }
            }

            if (hasFavorite) {
                favs.add(a);
            }
        }

        Collections.sort(favs, new Comparator<Album>() {
            @Override
            public int compare(Album o1, Album o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(Album a : favs) {
            System.out.println(a.getName());
        }
    }

    private void lambdaFunction2() {
        commonInit();

        List<Album> sortedFavs =
                albums
                    .stream()
                    .filter(a -> a.getTracks().stream().anyMatch(t -> t.getRating() >= 4))
                    .sorted(Comparator.comparing(Album::getName))
                    .collect(Collectors.toList())
                    ;

        sortedFavs.forEach(s -> System.out.println(s.getName()));
    }

    public static void main(String[] args) {
        StreamSample ss = new StreamSample();
        ss.normalFunction2();

        ss.lambdaFunction2();
    }
}

class Person {
    public enum Sex {MALE, FEMALE}

    private String name;
    private Sex gender;
    private int age;

    Person(String name, Sex gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }


    String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    Sex getGender() {
        return gender;
    }
}

class Album {
    private String name;
    private List<Track> tracks;

    Album(String name, List<Track> tracks) {
        this.name = name;
        this.tracks = tracks;
    }

    String getName() {
        return name;
    }

    List<Track> getTracks() {
        return tracks;
    }
}

class Track {
    private int rating;

    Track(int rating) {
        this.rating = rating;
    }

    int getRating() {
        return rating;
    }
}