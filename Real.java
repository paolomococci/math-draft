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

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author paolo mococci
 */

public class Real 
        implements Serializable {

    private static final long serialVersionUID = 2442512031915526935L;
    
    public static final MathContext HALF_EVEN32 = new MathContext(32, RoundingMode.HALF_EVEN);
    public static final MathContext CEILING32 = new MathContext(32, RoundingMode.CEILING);
    
    private BigDecimal value;
    
    /*
     * Constructor
     */

    public Real() {
        super();
        this.value = BigDecimal.valueOf(0.0D);
    }

    public Real(BigDecimal real) {
        super();
        this.value = real;
    }
    
    /*
     * Getters and setters 
     */

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = BigDecimal.valueOf(value);
    }
    
    public void setValue(long value) {
        this.value = BigDecimal.valueOf(value);
    }

    public void setScale(int scale) {
        this.value = this.value.setScale(scale, RoundingMode.HALF_EVEN);
    }

    /**
     *
     * @return scale of real number
     * Do not must be call getScale(),
     * because this class implement java.io.Serializable interface
     */
    public int scale() {
        return this.value.scale();
    }
    
    /*
     * Arithmetic operations
     */

    public void sum(Real r1, Real r2) {
        this.value = r1.getValue().add(r2.getValue(), HALF_EVEN32);
    }

    public void sub(Real r1, Real r2) {
        this.value = r1.getValue().subtract(r2.getValue(), HALF_EVEN32);
    }

    public void product(Real r1, Real r2) {
        this.value = r1.getValue().multiply(r2.getValue(), HALF_EVEN32);
    }

    public void product(Imag i1, Imag i2) {
        this.value = i1.getValue().multiply(i2.getValue(), CEILING32);
        this.value = this.value.multiply(Imag.I_SQUARE, CEILING32);
    }
    
    public void quotient(Real r1, Real r2) {
        this.value = r1.getValue().divide(r2.getValue(), CEILING32);
    }
    
    public void setSquare(Real r) {
        this.product(r, r);
    }
    
    /**
     *
     * @return value * value or if prefer pow(value, 2)
     * Do not must be call getSquare(),
     * because this class implement java.io.Serializable interface
     */
    public BigDecimal square() {
        return new Real(this.value.multiply(this.value, HALF_EVEN32));
    }
    
    /*
     * Overrides
     */
    
    @Override
    public String toString() {
        return this.getValue().toPlainString();
    }
    
}

