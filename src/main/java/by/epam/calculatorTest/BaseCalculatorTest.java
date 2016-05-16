package main.java.by.epam.calculatorTest;

import main.java.by.epam.calculatorTest.src.Calculator;
import org.testng.annotations.BeforeClass;

/* ) Написать юнит-тесты на предоставленную jar-библиотеку, содержащую в себе калькулятор. Необходимо протестировать калькулятор на наличие проблем. Желательно найти все баги.
Юнит тесты должны быть написаны с помощью TestNG, тесты должны быть разбиты по функциональности и организованы в сьюты.
В тестах должны использоваться Before* и After* методы.
Запуск сьютов должен быть реализован с помощью кастомного раннера (должна быть возможность запускать тесты параллельном режиме).
Реализовать параметризованные тесты, для проверки различных наборов данных использовать Factory и DataProvider.
Каждый тест должен что-то проверять и содержать в себе Assert.
Один из тестовых классов должен иметь в себе упорядоченный порядок тестов с помощью dependsOn или priority.
Приветствуется применение листенеров в кастомном раннере.
*/

public class BaseCalculatorTest {
    protected Calculator calculator;

    @BeforeClass()
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Create instance of calc");
    }
}
