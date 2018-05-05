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
public class RealTests {
    
    /*
    * Constructor
    */
    
    @Test
    public void testDefaltConstructor() 
            throws Exception {
        Real r = new Real();
        assertEquals(0.0, r.getValue().doubleValue());
    }
    
    /*
    * Setters
    */
    
    @Test
    public void testSetValueWithDouble() 
            throws Exception {
        Real r = new Real();
        r.setValue(1.0D);
        assertTrue(r.getValue().compareTo(new BigDecimal("1.0")) == 0);
    }
    
    @Test
    public void testSetValueWithLong() 
            throws Exception {
        Real r = new Real();
        r.setValue(1L);
        assertTrue(r.getValue().compareTo(new BigDecimal("1.0")) == 0);
    }
    
    @Test
    public void testSetScale() 
            throws Exception {
        Real r = new Real();
        r.setScale(32);
        assertTrue(32 == r.getValue().scale());
    }
    
    @Test
    public void testScale() 
            throws Exception {
        Real r = new Real();
        r.setScale(32);
        assertTrue(32 == r.scale());
    }
    
    /*
    * Operations
    */
    
    @Test
    public void testSum() 
            throws Exception {
        Real r1 = new Real();
        Real r2 = new Real();
        Real result = new Real();
        r1.setValue(0.999999999999);
        r2.setValue(0.000000000001);
        result.sum(r1, r2);
        assertTrue(result.getValue().compareTo(new BigDecimal("1.0")) == 0);
    }
    
    @Test
    public void testSub() 
            throws Exception {
        Real r1 = new Real();
        Real r2 = new Real();
        Real result = new Real();
        r1.setValue(0.999999999999);
        r2.setValue(0.000000000001);
        result.sub(r1, r2);
        assertTrue(result.getValue().compareTo(new BigDecimal("0.999999999998")) == 0);
    }
    
    @Test
    public void testProduct() 
            throws Exception {
        Real r1 = new Real();
        Real r2 = new Real();
        Real result = new Real();
        r1.setValue(0.9999999999999);
        r2.setValue(0.0000000000001);
        result.product(r1, r2);
        assertTrue(result.getValue().compareTo(new BigDecimal("0.00000000000009999999999999")) == 0);
    }
    
    @Test
    public void testQuotient() 
            throws Exception {
        Real r1 = new Real();
        Real r2 = new Real();
        Real result = new Real();
        r1.setValue(1.0);
        r2.setValue(3.0);
        result.quotient(r1, r2);
        assertEquals(0, result.getValue().compareTo(new BigDecimal("0.33333333333333333333333333333334")));
    }
    
    @Test
    public void testQuotientScaled() 
            throws Exception {
        Real r1 = new Real();
        Real r2 = new Real();
        Real result = new Real();
        r1.setValue(1.0);
        r2.setValue(3.0);
        result.quotient(r1, r2);
        int scale = result.scale();
        result.setScale(scale-1);
        assertEquals(0, result.getValue().compareTo(new BigDecimal("0.3333333333333333333333333333333")));
    }
    
    @Test
    public void testProductAfterQuotient() 
            throws Exception {
        Real r1 = new Real();
        Real r2 = new Real();
        Real result1 = new Real();
        Real result2 = new Real();
        r1.setValue(1.0);
        r2.setValue(3.0);
        result1.quotient(r1, r2);
        result2.product(result1, r2);
        assertEquals(0, result2.getValue().compareTo(new BigDecimal("1.0")));
    }
    
    @Test
    public void testSetSquare() 
            throws Exception {
        Real r = new Real();
        Real square = new Real();
        r.setValue(2.0);
        square.setSquare(r);
        assertEquals(0, square.getValue().compareTo(new BigDecimal("4.0")));
    }
    
    @Test
    public void testSquare() 
            throws Exception {
        Real r = new Real();
        r.setValue(2.0);
        BigDecimal bd = r.square();
        assertEquals(0, bd.compareTo(new BigDecimal("4.0")));
    }
}

