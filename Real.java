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
    public static final BigDecimal PI_GREEK32 = new BigDecimal("3.14159265358979323846264338327950");
    private static final BigDecimal EPSILON32 = new BigDecimal("0.00000000000000000000000000000001");
    
    private BigDecimal value;
    
    /*
     * Constructor
     */

    public Real() {
        super();
        this.value = BigDecimal.ZERO;
    }

    public Real(BigDecimal value) {
        super();
        this.value = value;
    }

    public Real(double value) {
        super();
        this.value = BigDecimal.valueOf(value);
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
        this.value = this.value.setScale(scale, RoundingMode.DOWN);
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
    
    public boolean itCannotBeDivisor() {
        try {
            double temp = 1.0/this.getValue().doubleValue();
            if (Double.isInfinite(temp) || Double.isNaN(temp)) {
                return true;
            }
        } catch (ArithmeticException ae) {
            ae.getMessage();
        }
        return false;
    }
    
    public void quotient(Real r1, Real r2) {
        if (r2.itCannotBeDivisor()) {
            this.value = null;
            //throw new ArithmeticException("Must not be divisor!");
        } else {
            this.value = r1.getValue().divide(r2.getValue(), CEILING32);
        }
    }
    
    public void setSquare(Real r) {
        this.product(r, r);
    }

    public void setSquareRoot() {
        /*
         * Implements the Newton method
         */
        boolean loop = true;
        Real temp = new Real(this.getValue());
        while (loop) {
            Real q = new Real();
            q.quotient(this, temp);
            temp.sum(q, temp);
            temp.quotient(temp, (new Real(2.0D)));
            loop = Math.abs(
                    temp.getValue().doubleValue() - 
                            this.getValue().doubleValue()/temp.getValue().doubleValue()
            ) > EPSILON32.doubleValue() * temp.getValue().doubleValue();
        }
        this.setValue(temp.getValue());
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

