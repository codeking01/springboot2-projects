package com.codeking.admin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.util.Strings.isEmpty;
import static org.junit.jupiter.api.Assertions.*;


/**
 * @author : codeking
 * @create : 2022/12/18 19:28
 */
@SpringBootTest
public class Junit5Test {

    @DisplayName("测试displayName注解")
    @Test
    void testDisplayName() {
        System.out.println(1);
    }


    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void palindromes(String candidate) {
        //assertTrue(StringUtils.isPalindrome(candidate));
        assertTrue(!isEmpty(candidate));
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    void test2() {
        System.out.println(2);
    }

    @RepeatedTest(5)
    @Test
    void test3() {
        System.out.println(5);
    }

    /**
     * 规定方法超时时间。超出时间测试出异常
     *
     * @throws InterruptedException
     */
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(500);
    }



    @Test
    @DisplayName("simple assertion")
    public void simple() {
        assertEquals(3, 1 + 2, "simple math");
        assertNotEquals(3, 1 + 1);

        assertNotSame(new Object(), new Object());
        Object obj = new Object();
        assertSame(obj, obj);

        assertFalse(1 > 2);
        assertTrue(1 < 2);

        assertNull(null);
        assertNotNull(new Object());
    }


    @Test
    @DisplayName("array assertion")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
    }
    // assertAll()`方法接受多个 org.junit.jupiter.api.Executable
    // 函数式接口的实例作为要验证的断言，可以通过 lambda 表达式很容易的提供这些断言。
    @Test
    @DisplayName("assert all")
    public void all() {
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));
    }

    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    @Test
    @DisplayName("fail")
    public void shouldFail() {
        fail("This should fail");
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始了...");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束了...");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了...");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试以及结束了...");

    }

}
