package agh.ii.prinjava.lab02.lst02_04;

public class Main {
    private static Actor acteurPrincipal(TroisCouleurs film) {
        return switch (film) {
            case BLEU -> new Actor("Juliette", "Binoche");
            case BLANC -> new Actor("Zbigniew", "Zamachowski");
            case ROUGE -> new Actor("Irene", "Jacob");
        };
    }

    private static String movieDesc(String movie, Actor leadActor) {
        return "The leadingActor in " + movie + " is " + leadActor.toString();
    }

    public static void demo1() {
        for (ThreeColors cl : ThreeColors.values()) {
            System.out.println(movieDesc(cl.name(), cl.getLeadingActor()));
        }
    }

    public static void demo2() {
        for (ThreeColorsEnumLike cl : ThreeColorsEnumLike.values()) {
            System.out.println(movieDesc(cl.name(), cl.getLeadingActor()));
        }
    }

    public static void demo3() {
        for (TroisCouleurs cl : TroisCouleurs.values()) {
            System.out.println(movieDesc(cl.name(), acteurPrincipal(cl)));
        }
    }

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }
}

