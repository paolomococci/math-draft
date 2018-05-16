/**
 * 
 * Copyright 2018 paolo mococci
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package local.example.draft.number;

import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author paolo mococci
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplexTests {
    
    @Test
    public void testDefaultConstructor() 
            throws Exception {
        Complex z = new Complex();
        z.setRealValue(1.0);
        z.setImagValue(1.0);
        assertTrue(z.getReal().getValue()
                .compareTo(new BigDecimal("1.0")) == 0);
        assertTrue(z.getImag().getValue()
                .compareTo(new BigDecimal("1.0")) == 0);
    }
    
    @Test
    public void testConstructorWithArgumentsDouble() 
            throws Exception {
        Complex z;
        z = new Complex(1.0, 1.0);
        assertTrue(z.getReal().getValue()
                .compareTo(new BigDecimal("1.0")) == 0);
        assertTrue(z.getImag().getValue()
                .compareTo(new BigDecimal("1.0")) == 0);
    }
    
    @Test
    public void testContructorWithArguments() 
            throws Exception {
        Complex z;
        Real a;
        Imag b;
        a = new Real(BigDecimal.ONE);
        b = new Imag(BigDecimal.ONE);
        z = new Complex(a, b);
        assertTrue(z.getReal().getValue()
                .compareTo(new BigDecimal("1.0")) == 0);
        assertTrue(z.getImag().getValue()
                .compareTo(new BigDecimal("1.0")) == 0);
    }
    
    @Test
    public void testConstructorFromComplex() 
            throws Exception {
        Complex z1, z2;
        z1 = new Complex(1.0, 1.0);
        z2 = new Complex(z1);
        assertTrue(z2.getReal().getValue()
                .compareTo(new BigDecimal("1.0")) == 0);
        assertTrue(z2.getImag().getValue()
                .compareTo(new BigDecimal("1.0")) == 0);
    }
    
    @Test
    public void testSum() 
            throws Exception {
        Complex z1, z2, result;
        z1 = new Complex(1.0987, -3.8765);
        z2 = new Complex(4.9871, 2.0987);
        result = new Complex();
        result.sum(z1, z2);
        assertEquals(6.0858, result.getReal().getValue().doubleValue());
        assertEquals(-1.7778, result.getImag().getValue().doubleValue());
    }
    
    @Test
    public void testSub() 
            throws Exception {
        Complex z1, z2, result;
        z1 = new Complex(1.0987, -3.8765);
        z2 = new Complex(4.9871, 2.0987);
        result = new Complex();
        result.sub(z1, z2);
        assertEquals(-3.8884, result.getReal().getValue().doubleValue());
        assertEquals(-5.9752, result.getImag().getValue().doubleValue());
    }
    
    @Test
    public void testProduct() 
            throws Exception {
        Complex z1, z2, result;
        z1 = new Complex(3.0, -1.0);
        z2 = new Complex(2.0, 3.0);
        result = new Complex();
        result.product(z1, z2);
        assertEquals(9.0, result.getReal().getValue().doubleValue());
        assertEquals(7.0, result.getImag().getValue().doubleValue());
    }
    
    @Test
    public void testConjugate() 
            throws Exception {
        Complex z1, z2;
        z1 = new Complex(3.0, -1.0);
        z2 = new Complex(z1.conjugate());
        assertEquals(3.0, z2.getReal().getValue().doubleValue());
        assertEquals(1.0, z2.getImag().getValue().doubleValue());
    }
    
    @Test
    public void testQuotient1() 
            throws Exception {
        Complex z1, z2, result;
        z1 = new Complex(3.0, -1.0);
        z2 = new Complex(2.0, 3.0);
        result = new Complex();
        result.quotient(z1, z2);
        result.getReal().setScale(12);
        result.getImag().setScale(12);
        assertEquals(0.230769230769, 
                result.getReal().getValue().doubleValue());
        assertEquals(-0.846153846153, 
                result.getImag().getValue().doubleValue());
    }
    
    @Test
    public void testQuotient2() 
            throws Exception {
        Complex z1, z2, result;
        z1 = new Complex(3.0, -1.0);
        z2 = new Complex(2.0, 3.0);
        result = new Complex();
        result.quotient(z1, z2);
        result.getReal().setScale(31);
        result.getImag().setScale(31);
        assertTrue(result.getReal().getValue()
                .compareTo(new BigDecimal("0.2307692307692307692307692307692")) == 0);
        assertTrue(result.getImag().getValue()
                .compareTo(new BigDecimal("-0.8461538461538461538461538461538")) == 0);
    }
}
