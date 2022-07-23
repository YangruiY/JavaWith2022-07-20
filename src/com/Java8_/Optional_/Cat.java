package com.Java8_.Optional_;

import java.util.Objects;

public class Cat {
    private Dog dog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(dog, cat.dog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dog);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "dog=" + dog +
                '}';
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat() {
    }

    public Cat(Dog dog) {
        this.dog = dog;
    }
}
