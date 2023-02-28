# Gilded Rose starting position in Java

## Run the Text Fixture from Command-Line

```
./gradlew -q text
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew -q text --args 10
```

---

## Comments

- This is a repo extracted from [Emily Bache github](https://github.com/emilybache/GildedRose-Refactoring-Kata)
  which I will be using for practising refactoring with Java and testing.

- Video for helping -> [YT official creator](https://www.youtube.com/watch?v=zyM2Ep28ED8&ab_channel=EficodePraqma)

### Testing
how well we can test our code?
1. **coverage tests** (try to have a full coverage on our business logic or use cases)
2. **mutation tests** (change code after tests to check if fails which means they are ok before a refactoring)
    - We create a "mutation" on a specific line of code to check if we break our test
    - We create a "mutation" on a specific line of code to check if we break our test
