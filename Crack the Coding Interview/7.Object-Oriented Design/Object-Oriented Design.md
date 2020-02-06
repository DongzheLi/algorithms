# Object Oriented Design

## Process

1. Handle Ambiguity
2. Define core objects
3. Analyze Relationship
4. Investigate Actions

## Design Patterns

### Singleton Class

Let's implement `Restaurant` such that it has exactly one instance of Restaurant.

```java
public class Restaurant {
    private static Restaurant instance = null;

    protected Restaurant() {...};

    public static Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant;
        }
        return instance;
    }
}
```

### Factory Method

```java
public class CardGame {
    public static CardGame createCardGame(GameType type) {
        if (type == GameType.Poker) {
            return new PokerGame();
        } else if (type == GameType.BlackJack) {
            return new BlackJackGame();
        }
        return null;
    }
}
```

## Questions

1. Deck of Cards
2. Call center
3. Parking lot
4. Chat server
5. Online book reader
6. Circular Array
7. File System
8. Hash Table