package ru.kimdo;

/**
 * @author Pavel Petrikovskiy
 * @version 23.05.17.
 */

class J1HW6 {

    public static void main(String[] args) {

        Creature creature = new Creature("Нечто",
                'i',
                50,
                50,
                50,
                50,
                2,
                100,
                1,
                "перламутровое");

        creature.lookAt();
        creature.toHide();
        creature.toRoar();
        creature.toAttak();
        creature.toGrab();
        creature.toGo("север");
        creature.toFlee();

    }
}

class Creature {

    private double height;
    private double weight;
    private double speed;
    private double roar;
    private double hide;
    private double damage;
    private double dodge;
    private String colore;
    private String name;
    private char gender; // Только три значения: m, f, i
    private char genderEnd;
    private String description;

    private String tipe;

    private double hp 		= height * weight;
    private double attack 	= speed * damage;
    private double grab 		= speed * height - weight;

    Creature(String tipe,
             char gender,
             double height,
             double weight,
             double speed,
             double roar,
             double hide,
             double damage,
             double dodge,
             String colore) {

        this.tipe	= tipe;
        this.gender	= gender;
        this.height = height;
        this.weight = weight;
        this.speed 	= speed;
        this.roar	= roar;
        this.hide	= hide;
        this.damage	= damage;
        this.dodge	= dodge;
        this.colore	= colore;
        this.genderEnd = genderEnd(gender);

        this.description = "Это " + colore + " " + tipe +
                ", совершенно непонятное!";
    }

    Creature(String tipe,
             char gender,
             double height,
             double weight,
             double speed,
             double roar,
             double hide,
             double damage,
             double dodge,
             String colore,
             String name) {

        this.tipe	= tipe;
        this.gender	= gender;
        this.height = height * 1.5;
        this.weight = weight * 1.5;
        this.speed 	= speed * 1.5;
        this.roar	= roar * 2;
        this.hide	= hide * 0.75;
        this.damage	= damage * 1.5;
        this.dodge	= dodge * 0.75;
        this.colore	= colore;
        this.name 	= name;
        this.genderEnd = genderEnd(gender);

        this.description = "Это огромное " + colore + " " + tipe +
                " " + name + ", совершенно непонятное!";
    }

    void lookAt(){
        System.out.println(description);
    }

    double toFlee() {
        System.out.printf("%s побежал%s со скоростью %.0f", tipe,
                genderEnd, speed);
        System.out.print(" км/ч в неизвестном направлении!\n");
        return speed;
    }

    double toGo(String direction) {
        System.out.printf("%s пошел%s на %s\n", tipe, genderEnd,
                direction);
        return speed;
    }

    double toRoar() {
        System.out.printf("%s издал%s рык громкостью %.0f дБ!\n", tipe,
                genderEnd, roar);
        return roar;
    }

    double toHide() {
        System.out.printf("%s попробовал%s спрятаться!\n", tipe, genderEnd);
        return hide;
    }

    double toAttak() {
        System.out.printf("%s попробовал%s напасть!\n", tipe, genderEnd);
        return attack;
    }

    double toGrab() {
        System.out.printf("%s попробовал%s сграбастать вас!\n", tipe, genderEnd);
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

