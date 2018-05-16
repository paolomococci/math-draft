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
public class ImagTests {
    
    @Test
    public void testDefaultContructor() {
        Imag i = new Imag();
        assertEquals(0.0, i.getValue().doubleValue());
    }
    
    @Test
    public void testConstructorWithValue() 
            throws Exception {
        Imag i1 = new Imag();
        i1.setValue(2.0D);
        Imag i2 = new Imag(i1.getValue());
        assertEquals(2.0, i2.getValue().doubleValue());
    }
    
    /*
    * Setters
    */
    
    @Test
    public void testSetValueWithDouble() 
            throws Exception {
        Imag i = new Imag();
        i.setValue(1.0D);
        assertTrue(i.getValue().compareTo(new BigDecimal("1.0")) == 0);
    }
    
    @Test
    public void testSetValueWithLong() 
            throws Exception {
        Imag i = new Imag();
        i.setValue(1L);
        assertTrue(i.getValue().compareTo(new BigDecimal("1.0")) == 0);
    }
    
    @Test
    public void testSetScale() 
            throws Exception {
        Imag i = new Imag();
        i.setScale(32);
        assertTrue(32 == i.getValue().scale());
    }
    
    @Test
    public void testScale() 
            throws Exception {
        Imag i = new Imag();
        i.setScale(32);
        assertTrue(32 == i.scale());
    }
    /*
    /*
    * Operations
    */
    
    @Test
    public void testSum() 
            throws Exception {
        Imag i1 = new Imag();
        Imag i2 = new Imag();
        Imag result = new Imag();
        i1.setValue(0.99999999999999999999999999999999);
        i2.setValue(0.00000000000000000000000000000001);
        result.sum(i1, i2);
        assertTrue(result.getValue().compareTo(new BigDecimal("1.0")) == 0);
    }
    
    @Test
    public void testSub() 
            throws Exception {
        Imag i1 = new Imag();
        Imag i2 = new Imag();
        Imag result = new Imag();
        i1.setValue(1.0);
        i2.setValue(0.00000000000000000000000000000001);
        result.sub(i1, i2);
        assertTrue(result.getValue()
                 .compareTo(new BigDecimal("0.99999999999999999999999999999999")) == 0);
    }
    
    @Test
    public void testProduct1() 
            throws Exception {
        Imag i1 = new Imag();
        Imag i2 = new Imag();
        Real result = new Real();
        i1.setValue(3.0);
        i2.setValue(5.0);
        result.product(i1, i2);
        assertTrue(result.getValue().compareTo(new BigDecimal("-15.0")) == 0);
    }
    
    @Test
    public void testProduct2() 
            throws Exception {
        Imag i = new Imag();
        Real r = new Real();
        Imag result = new Imag();
        i.setValue(3.0);
        r.setValue(5.0);
        result.product(i, r);
        assertTrue(result.getValue().compareTo(new BigDecimal("15.0")) == 0);
    }
    
    @Test
    public void testQuotient() 
            throws Exception {
        Imag i = new Imag();
        Real r = new Real();
        Imag result = new Imag();
        i.setValue(1.0);
        r.setValue(3.0);
        result.quotient(i, r);
        assertEquals(0, result.getValue()
                .compareTo(new BigDecimal("0.33333333333333333333333333333334")));
    }
    
    @Test
    public void testQuotientScaled() 
            throws Exception {
        Imag i = new Imag();
        Real r = new Real();
        Imag result = new Imag();
        i.setValue(1.0);
        r.setValue(3.0);
        result.quotient(i, r);
        int scale = result.scale();
        result.setScale(scale-1);
        assertEquals(0, result.getValue()
                .compareTo(new BigDecimal("0.3333333333333333333333333333333")));
    }
    
    @Test
    public void testSquare() 
            throws Exception {
        Imag i = new Imag();
        i.setValue(3.0);
        Real r;
        r = i.square();
        assertEquals(0, r.getValue().compareTo(new BigDecimal("-9.0")));
    }
    
    @Test
    public void testSquareOfImaginaryCoefficient() 
            throws Exception {
        Imag i = new Imag();
        i.setValue(3.0);
        Real r;
        r = i.squareOfImaginaryCoefficient();
        assertEquals(0, r.getValue().compareTo(new BigDecimal("9.0")));
    }
    
    @Test
    public void testNegate() 
            throws Exception {
        Imag i1, i2;
        i1 = new Imag();
        i1.setValue(1.0);
        i2 = i1.negate();
        assertEquals(1.0, i1.getValue().doubleValue());
        assertEquals(-1.0, i2.getValue().doubleValue());
    }
}
