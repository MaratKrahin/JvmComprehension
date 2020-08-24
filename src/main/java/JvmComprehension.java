public class JvmComprehension {

    public static void main(String[] args) { // в момент загрузки main в StackMemory создается фрейм

        int i = 1;                      // 1  в StackMemory загружается примитив во фрейм

        Object o = new Object();        // 2 Так как это "Object" о нем уже есть инфо в Metaspace, в Heap создается объект,
        // а в StackMemory кладется ссылка на этот объект(в фрейм)

        Integer ii = 2;                 // 3  в Heap создается объект,
        // а в StackMemory кладется ссылка на этот объект(в фрейм)

        printAll(o, i, ii);             // 4  создается фрейм на верху стека, число кладется в StackMemory
        // далее создаётся 2 объекта ссылки кладутся в стек.

        System.out.println("finished"); // 7   в StackMemory новый фрейм, далее фрейм удаляется из памяти.

    }

    private static void printAll(Object o, int i, Integer ii) {

        Integer uselessVar = 700;                   // 5  Данные об Объекте есть в Metaspace(потому что Integer),
        // в Heap создается объект,
        // а в StackM кладется ссылка на этот объект(в виде фрейма)

        System.out.println(o.toString() + i + ii);  // 6  в StackMemory создаётся новый фрейм передается ссылка ii,
        // метод выполнился и удаляется из фрейма.
    }
}

/*
GarbageCollector (GC)
GC работает heap, при создании большого кол-ва объектов в eden заканчивается место и  GC проводит сборку мусора на минималках
 - очищает eden и объекыт которые не были удалены кладет в survivor 0. Прив повторном переполнении eden,
 происходит тоже самое и с survivor 0, объекты которые не были удалены кладутся в survivor 1, далее если и тут остаются
 уцелевшие объекты, то они попадают в tenured. Как только tenured переполнистя GC проведет чистку уже на "макисмалках" (полная сборка мусора)

 */