package ru.kimdo;

/**
 * @author Pavel Petrikovskiy
 * @version 23.05.17.
 */

class J1HW6 {

    public static void main(String[] args) {

        System.out.println("Создаётся некое существо:");
        System.out.println();

        Creature creature = new Creature("Нечто",
                'i',
                50,
                500,
                50,
                130,
                2,
                100,
                1,
                "перламутровое",
                "совершенно непонятное!");

        creature.lookAt();
        creature.toHide();
        creature.toRoar();
        creature.toAttak();
        creature.toGrab();
        creature.toGo("север");
        creature.toFlee(1000);
        creature.toSwim(500);
        creature.toJump(10);

        System.out.println();
        System.out.println("Создаётся обычная собака:");
        System.out.println();

        Dog dog = new Dog("Пес",
                'm',
                0.5,
                30,
                50,
                30,
                10,
                10,
                50,
                "серый",
                "виляет хвостом.");

        dog.lookAt();
        dog.toHide();
        dog.toRoar();
        dog.toAttak();
        dog.toGrab();
        dog.toGo("юг");
        dog.toFlee(1000);
        dog.toSwim(500);
        dog.toJump(10);

        System.out.println();
        System.out.println("Создаётся котик:");
        System.out.println();

        Cat cat = new Cat("Кошак",
                'm',
                0.2,
                5,
                20,
                10,
                50,
                8,
                100,
                "рыжий",
                "няшка.");

        cat.lookAt();
        cat.toHide();
        cat.toRoar();
        cat.toAttak();
        cat.toGrab();
        cat.toGo("восток");
        cat.toFlee(1000);
        cat.toSwim(500);
        cat.toJump(10);

        System.out.println();
        System.out.println("На основе класса собаки создается вервульф:");
        System.out.println();

        Dog werewolf = new Dog("Вервульф",
                'm',
                5,
                200,
                100,
                50,
                10,
                50,
                20,
                "чёрный",
                "смотрит на тебя и облизывается.");

        werewolf.lookAt();
        werewolf.toHide();
        werewolf.toRoar();
        werewolf.toAttak();
        werewolf.toGrab();
        werewolf.toGo("юг");
        werewolf.toFlee(1000);
        werewolf.toSwim(500);
        werewolf.toJump(10);

        System.out.println();
        System.out.println("На основе кота создаётся тигрица:");
        System.out.println();

        Cat tiger = new Cat("Тигрица",
                'f',
                1.5,
                100,
                50,
                45,
                40,
                50,
                90,
                "полосатая",
                "тихонько рычит.");

        tiger.lookAt();
        tiger.toHide();
        tiger.toRoar();
        tiger.toAttak();
        tiger.toGrab();
        tiger.toGo("восток");
        tiger.toFlee(1000);
        tiger.toSwim(500);
        tiger.toJump(10);
    }
}

class Creature {

    double height;
    double weight;
    double speed;
    double roar;
    double hide;
    double damage;
    double dodge;

    char gender; // Только три значения: m, f, i
    char genderEnd;

    String description;
    String description2;
    String type;
    String color;
    String name;

    double hp 	    = height * weight;
    double attack   = speed * damage;
    double grab 	= speed * height - weight;

    Creature(String type,
             char   gender,
             double height,
             double weight,
             double speed,
             double roar,
             double hide,
             double damage,
             double dodge,
             String color,
             String description2) {

        this.type	    = type;
        this.gender	    = gender;
        this.height     = height;
        this.weight     = weight;
        this.speed 	    = speed;
        this.roar	    = roar;
        this.hide	    = hide;
        this.damage	    = damage;
        this.dodge	    = dodge;
        this.color	    = color;
        this.genderEnd  = genderEnd(gender);
        this.description2 = description2;

        this.description = "Это " + color + " " + type + ", " + description2;
    }

    Creature(String type,
             char   gender,
             double height,
             double weight,
             double speed,
             double roar,
             double hide,
             double damage,
             double dodge,
             String color,
             String description2,
             String name) {

        this.type	    = type;
        this.gender	    = gender;
        this.height     = height * 1.5;
        this.weight     = weight * 1.5;
        this.speed 	    = speed * 1.5;
        this.roar	    = roar * 2;
        this.hide	    = hide * 0.75;
        this.damage	    = damage * 1.5;
        this.dodge	    = dodge * 0.75;
        this.color	    = color;
        this.name 	    = name;
        this.genderEnd  = genderEnd(gender);

        this.description = "Это " + color + " " + type +
                " по имени " + name + ", " + description2;
    }

    void lookAt(){
        System.out.println(description);
    }

    double toFlee(double difficulty) {
        System.out.printf("%s побежал%s со скоростью %.0f", type,
                genderEnd, speed);
        System.out.print(" км/ч в неизвестном направлении!\n");
        System.out.printf("%s отбежал%s на %.0f метров!\n", type,
                genderEnd, difficulty);
        return speed;
    }                               

    double toSwim(double difficulty) {
        System.out.printf("%s поплыл%s со скоростью %.0f", type,
                genderEnd, speed/3);
        System.out.print(" узлов куда-то в даль!\n");
        System.out.printf("И отплыл%s на %.0f метров!\n", genderEnd,
                difficulty);
        return speed;
    }

    double toJump(double difficulty) {
        System.out.printf("%s прыгнул%s вверх на %.0f", type,
                genderEnd, speed/10);
        System.out.print(" метров, вот это да!\n");
        if (speed/10 > difficulty)
            System.out.printf("И перепрыгнул%s препятствие" +
                    " высотой %.0f метров!\n", genderEnd, difficulty);
        else
            System.out.printf("Но не удалось перепрыгнуть препятствие" +
                    " высотой %.0f метров и он%s больно упал%s!\n",
                    difficulty, genderEnd, genderEnd);
        return speed;
    }

    double toGo(String direction) {
        System.out.printf("%s пошел%s на %s.\n", type, genderEnd,
                direction);
        return speed;
    }

    double toRoar() {
        System.out.printf("%s издал%s рык громкостью %.0f дБ!\n", type,
                genderEnd, roar);
        if (roar >= 50)
            System.out.println("Жудкий рёв от которого стынет кровь в жилах!!!");
        if (roar < 50 && roar >= 40)
            System.out.println("Страшный рык, аж поджилки затряслись!");
        if (roar < 40 && roar >= 30)
            System.out.println("Мощный рык!");
        if (roar < 30 && roar >= 10)
            System.out.println("Ух, разозлили зверя!");
        if (roar < 10 && roar >= 1)
            System.out.println("Похоже на кошачьи песни мартовской ночью)");
        if (roar < 1)
            System.out.println("Жалкий писк!");
        return roar;
    }

    double toHide() {
        System.out.printf("%s попробовал%s спрятаться!\n", type, genderEnd);
        return hide;
    }

    double toAttak() {
        System.out.printf("%s попробовал%s напасть!\n", type, genderEnd);
        return attack;
    }

    double toGrab() {
        System.out.printf("%s попробовал%s сграбастать вас!\n", type, genderEnd);
        return grab;
    }

    private char genderEnd(char gender) {
        switch (gender) {
            case 'm':
                return ' ';
            case 'f':
                return 'а';
            case 'i':
                return 'о';
            default:
                return 'о';
        }
    }
}

class Dog extends Creature {

    Dog(String type,
        char   gender,
        double height,
        double weight,
        double speed,
        double roar,
        double hide,
        double damage,
        double dodge,
        String color,
        String description2) {

        super(type, gender, height, weight, speed, roar, hide,
                damage, dodge, color, description2);
    }

    @Override
    double toGrab() {
        System.out.printf("%s попробовал%s вцепиться зубами!\n", type, genderEnd);
        return grab;
    }

    @Override
    double toFlee(double difficulty) {
        System.out.printf("%s побежал%s со скоростью %.0f", type,
                genderEnd, speed);
        System.out.print(" км/ч в неизвестном направлении!\n");
        if (difficulty <= speed*10)
            System.out.printf("%s отбежал%s на %.0f метров!\n", type,
                genderEnd, difficulty);
        else
            System.out.printf("%s отбежал%s на %.0f метров!\n", type,
                    genderEnd, speed*10);
        return speed;
    }

    @Override
    double toJump(double difficulty) {
        System.out.printf("%s прыгнул%s вверх на %.2f", type,
                genderEnd, speed/100);
        System.out.print(" метров, вот это да!\n");
        if (speed/100 > difficulty)
            System.out.printf("И перепрыгнул%s препятствие" +
                    " высотой %.0f метров!\n", genderEnd, difficulty);
        else
            System.out.printf("Но не удалось перепрыгнуть препятствие" +
                            " высотой %.0f метров и он%s больно упал%s!\n",
                    difficulty, genderEnd, genderEnd);
        return speed;
    }

    @Override
    double toSwim(double difficulty) {
        System.out.printf("%s поплыл%s со скоростью %.0f", type,
                genderEnd, speed/3);
        System.out.print(" узлов куда-то в даль!\n");
        if (difficulty <= speed/3)
            System.out.printf("И отплыл%s на %.0f метров!\n", genderEnd,
                difficulty);
        else
            System.out.printf("И отплыл%s на %.0f метров!\n", genderEnd, speed/3);
        return speed;
    }

}

class Cat extends Creature {

    Cat(String type,
        char   gender,
        double height,
        double weight,
        double speed,
        double roar,
        double hide,
        double damage,
        double dodge,
        String color,
        String description2) {

        super(type, gender, height, weight, speed, roar, hide,
                damage, dodge, color, description2);
    }

    @Override
    double toGrab() {
        System.out.printf("%s попробовал%s вцепиться когтями!\n", type, genderEnd);
        return grab;
    }

    @Override
    double toFlee(double difficulty) {
        System.out.printf("%s побежал%s со скоростью %.0f", type,
                genderEnd, speed);
        System.out.print(" км/ч в неизвестном направлении!\n");
        if (difficulty <= speed*10)
            System.out.printf("%s отбежал%s на %.0f метров!\n", type,
                    genderEnd, difficulty);
        else
            System.out.printf("%s отбежал%s на %.0f метров!\n", type,
                    genderEnd, speed*10);
        return speed;
    }

    @Override
    double toJump(double difficulty) {
        System.out.printf("%s прыгнул%s вверх на %.0f", type,
                genderEnd, speed/10);
        System.out.print(" метра, вот это да!\n");
        if (speed/10 > difficulty)
            System.out.printf("И перепрыгнул%s препятствие" +
                    " высотой %.0f метров!\n", genderEnd, difficulty);
        else
            System.out.printf("Но не удалось перепрыгнуть препятствие" +
                            " высотой %.0f метров и он%s больно упал%s!\n",
                    difficulty, genderEnd, genderEnd);
        return speed;
    }

    @Override
    double toSwim(double difficulty) {
        System.out.printf("%s на пушечный выстрел не подойдет к воде!\n", type);
        return -1;
    }
}
