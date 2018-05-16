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
import java.math.RoundingMode;

/**
 *
 * @author paolo mococci
 */

public class Imag 
        implements Serializable {
    
    private static final long serialVersionUID = -5105608673271408431L;
    
    public static final BigDecimal I_SQUARE = BigDecimal.ONE.negate();
    public static final BigDecimal I_FOURTH = BigDecimal.ONE;
    
    private BigDecimal value;

    public Imag() {
        super();
        this.value = BigDecimal.valueOf(0.0D);
    }

    public Imag(BigDecimal value) {
        super();
        this.value = value;
    }

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
     * @return imaginary number coefficient scale
     * Do not must be call getScale(),
     * because this class implement java.io.Serializable interface
     */
    public int scale() {
        return this.value.scale();
    }

    public void sum(Imag i1, Imag i2) {
        this.value = i1.getValue().add(i2.getValue(), Real.HALF_EVEN32);
    }

    public void sub(Imag i1, Imag i2) {
        this.value = i1.getValue().subtract(i2.getValue(), Real.HALF_EVEN32);
    }

    public void product(Imag i, Real r) {
        this.value = i.getValue().multiply(r.getValue(), Real.HALF_EVEN32);
    }

    public void quotient(Imag i, Real r) {
        this.value = i.getValue().divide(r.getValue(), Real.CEILING32);
    }
    
    /**
     *
     * @return value * value or if prefer pow(value, 2)
     * Do not must be call getSquare(),
     * because this class implement java.io.Serializable interface
     */
    public Real square() {
        return new Real(this.value.multiply(this.value, Real.HALF_EVEN32).negate());
    }
    
    public Real squareOfImaginaryCoefficient() {
        return new Real(this.value.multiply(this.value, Real.HALF_EVEN32));
    }

    Imag negate() {
        Imag temp = new Imag();
        temp.value = this.value.multiply(I_SQUARE, Real.HALF_EVEN32);
        return temp;
    }
    
    /*
     * Overrides
     */

    @Override
    public String toString() {
        return this.getValue().toPlainString();
    }
}
