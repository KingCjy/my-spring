package org.myspring.beans;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.myspring.beans.BeanInstantiationException;
import org.myspring.beans.BeanUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BeanUtilsTest {

    @Test
    @DisplayName("인스턴스 생성 테스트")
    public void instantiateClassTest() throws Exception {
        String message = "Hello World";
        TestClass testClass = BeanUtils.instantiateClass(TestClass.class.getDeclaredConstructor(String.class), message);
        assertThat(testClass.getMessage()).isEqualTo(message);
    }

    @Test
    public void instantiateInterfaceTest() {
        assertThatThrownBy(() -> {
            BeanUtils.instantiateClass(List.class);
        }).isInstanceOf(BeanInstantiationException.class);
    }

    public static class TestClass {

        private final String message;

        public TestClass(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}