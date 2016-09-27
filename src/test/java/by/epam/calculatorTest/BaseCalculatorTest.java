package by.epam.calculatorTest;

//import com.epam.tat.module4.Calculator;

import by.epam.calculatorTest.src.Calculator;
import org.testng.annotations.*;

/* ) Написать юнит-тесты на предоставленную jar-библиотеку, содержащую в себе калькулятор.
Юнит тесты должны быть написаны с помощью TestNG, тесты должны быть разбиты по функциональности и организованы в сьюты.
В тестах должны использоваться Before* и After* методы.
Запуск сьютов должен быть реализован с помощью кастомного раннера
    (должна быть возможность запускать тесты параллельном режиме).
Один из тестовых классов должен иметь в себе упорядоченный порядок тестов с помощью dependsOn или priority.
Приветствуется применение листенеров в кастомном раннере.
Выполнено:
Каждый тест должен что-то проверять и содержать в себе Assert.
Реализовать параметризованные тесты, для проверки различных наборов данных использовать Factory и DataProvider.
    positiveNegativeTest


*/

//функция mult с типом double работает неправильно - округляет
//double div не обработывает деление на ноль
//double pow не позволяет возвести в дробную степень
//double sin вычиляет косинус
//double sqrt берёт abs числа - из отицательного числа нельзя извлечь корень, соответсвенно нужна обработка
//double tg  из-за неправильного вычисления синуиса - баг
// double ctg высчитывает гиперболический котангенс угла, а не котангенс.
//feature request - вычисление через так
//return this.cos(a) / this.sin(a);


public class BaseCalculatorTest {
    protected Calculator calculator;


    @BeforeSuite
    public void suiteSetUp() {
        System.out.println("Before Suite");
    }

    @BeforeTest()
    public void setUpTest() {
        System.out.println("Before Test");
    }

    @BeforeClass()
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Before Class");
    }

    @AfterClass()
    public void tearDown() {
        System.out.println("After Class");
    }

    @AfterTest()
    public void cleanUpTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void cleanupSuite() {
        System.out.println("After Suite");
    }


}
