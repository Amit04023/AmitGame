import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Character character1 = new Character("Player 1");
        character1.addWeapon(new Sword());

        Character character2 = new Character("Player 2");
        character2.addWeapon(new Fireball());

        game.addCharacter(character1);
        game.addCharacter(character2);

        game.battle(character1, character2);
    }
}

class Character {
    private String name;
    private List<Weapon> weapons;

    public Character(String name) {
        this.name = name;
        this.weapons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public Weapon getStrongestWeapon() {
        Weapon strongestWeapon = null;
        int maxDamage = Integer.MIN_VALUE;

        for (Weapon weapon : weapons) {
            if (weapon.getDamage() > maxDamage) {
                strongestWeapon = weapon;
                maxDamage = weapon.getDamage();
            }
        }

        return strongestWeapon;
    }
}

class Characters {
    private List<Character> characters;

    public Characters() {
        this.characters = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public List<Character> getCharacters() {
        return characters;
    }
}

abstract class Weapon {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}

   class Sword extends Weapon {
       public Sword() {
        super("Sword", 20);
    }
}

   class Fireball extends Weapon {
    public Fireball() {
     super("Fireball", 30);
    }
}

   class Game {
    private Characters characters;

    public Game() {
        this.characters = new Characters();
    }

    public void addCharacter(Character character) {
        characters.addCharacter(character);
    }

     public void battle(Character character1, Character character2) {
        Weapon weapon1 = character1.getStrongestWeapon();
          Weapon weapon2 = character2.getStrongestWeapon();

             System.out.println(character1.getName() + " attacks with " + weapon1.getName() +
                " causing " + weapon1.getDamage() + " damage");
               System.out.println(character2.getName() + " attacks with " + weapon2.getName() +
                " causing " + weapon2.getDamage() + " damage");


    }
}
