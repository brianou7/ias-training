package co.edu.ff.orders;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        List<Pizza> pizzaList = Arrays.asList(
                new Pizza("Básica", Size.SMALL, 600),
                new Pizza("Familiar", Size.LARGE, 1800),
                new Pizza("Vegetariana", Size.LARGE, 860),
                new Pizza("Solo queso", Size.MEDIUM, 1000),
                new Pizza("Hawaiana", Size.SMALL, 1200),
                new Pizza("Extra carnes", Size.LARGE, 2100),
                new Pizza("Pollo", Size.SMALL, 900),
                new Pizza("Pollo + tocineta", Size.MEDIUM, 1500),
                new Pizza("Pollo + Jamon", Size.MEDIUM, 1300)
        );

        /*
         * 1. Obtener todas las pizzas de tamaño "MEDIUM"
         */
        List<Pizza> mediumPizzas = pizzaList.stream()
                .filter(pizza -> pizza.getSize().equals(Size.MEDIUM))
                .collect(Collectors.toList());
        System.out.println(String.format("-- Filtered by size (MEDIUM): %n %s %n", mediumPizzas.toString()));

        /*
         * 2. Obtener todas las pizzas que las calorias esten entre 700 y 1500
         */
        List<Pizza> byCalories = pizzaList.stream()
                .filter(pizza -> {
                    return pizza.getCalories() >= 700 &&
                            pizza.getCalories() <= 1500;
                })
                .collect(Collectors.toList());
        System.out.println(String.format("-- Filtered by calories (700 < calories < 1500): %n %s %n", byCalories.toString()));

        /*
         * 3. Obtener las 3 pizzas con más calorias
         */
        List<Pizza> threeWithMostCalories = pizzaList.stream()
                .sorted(Comparator.comparing(Pizza::getCalories).reversed())
                .limit(3L)
                .collect(Collectors.toList());
        System.out.println(String.format("-- Three pizzas with more calories: %n %s %n", threeWithMostCalories.toString()));

        /*
         * 4. Obtener las 2 pizzas con menos calorias
         */
        List<Pizza> twoWithLessCalories = pizzaList.stream()
                .sorted(Comparator.comparing(Pizza::getCalories))
                .limit(2L)
                .collect(Collectors.toList());
        System.out.println(String.format("-- Two pizzas with less calories: %n %s %n", twoWithLessCalories));

        /*
         * 5. Del numeral 2 obtener las 2 pizzas con mas calorias
         */
        List<Pizza> othersByCalories = byCalories.stream()
                .sorted(Comparator.comparing(Pizza::getCalories))
                .limit(2L)
                .collect(Collectors.toList());
        System.out.println(String.format("-- Two pizzas with less calories (from 2: Filtered by calories ): %n %s %n", othersByCalories));

        /*
         * 5. Agrupar las pizzas por tamaño
         */
        Map<Size, List<Pizza>> pizzasBySize =  pizzaList.stream()
                .collect(Collectors.groupingBy(Pizza::getSize));
        System.out.println(String.format("-- Grouped by size: %n %s %n", pizzasBySize));

        /*
         * 6. Agrupar las pizzas por los siguientes grupos:
         * de 0 a 1000 calorias
         * de 1001 a 2000 calorias
         * de 2001 a 3000 calorias
         */
        Map<String, List<Pizza>> groupedByCalories = pizzaList.stream()
                .collect(Collectors.groupingBy(pizza -> {
                    Integer calories = pizza.getCalories();

                    if(calories >= 0 && calories <= 1000) {
                        return "One thousand";
                    } else if(calories > 1000 && calories <= 2000) {
                        return "Two thousand";
                    } else if (calories > 2000 && calories <= 3000) {
                        return "Three thousand";
                    }

                    return "Uncategorized";
                }));
        System.out.println(String.format("-- Grouped by calories: %n %s %n", groupedByCalories));

    }

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    public static class Pizza {
        private final String name;
        private final Size size;
        private final Integer calories;

        public Pizza(String name, Size size, Integer calories) {
            this.name = name;
            this.size = size;
            this.calories = calories;
        }

        public Size getSize() {
            return size;
        }

        public String getName() {
            return name;
        }

        public Integer getCalories() {
            return calories;
        }

        @Override
        public String toString() {
            return String.format("Pizza{%s, %s, %s}", name, size, calories);
        }
    }
}