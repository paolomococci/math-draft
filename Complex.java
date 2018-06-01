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

/**
 *
 * @author paolo mococci
 */

public class Complex 
        implements Serializable {
    
    private static final long serialVersionUID = 296851441553469442L;
    
    private final Real real;
    private final Imag imag;

    public Complex() {
        super();
        this.real = new Real(BigDecimal.ZERO);
        this.imag = new Imag(BigDecimal.ZERO);
    }

    Complex(double real, double imag) {
        super();
        this.real = new Real(BigDecimal.valueOf(real));
        this.imag = new Imag(BigDecimal.valueOf(imag));
    }

    Complex(Real real, Imag imag) {
        super();
        this.real = real;
        this.imag = imag;
    }

    Complex(Complex z) {
        super();
        this.real = z.getReal();
        this.imag = z.getImag();
    }

    public Real getReal() {
        return this.real;
    }

    public Imag getImag() {
        return this.imag;
    }

    public Real getRho() {
        Real temp;
        temp = this.getReal().square();
        temp.sum(temp, this.getImag().squareOfImaginaryCoefficient());
        temp.setSquareRoot();
        temp.setScale(11);
        return temp;
    }

    public Real getTheta() {
        if (this.getReal().itCannotBeDivisor()) {
            if (this.getImag().itCannotBeDivisor()) {
                throw new ArithmeticException("Theta not defined.");
            } else if (this.getImag().getValue().compareTo(BigDecimal.ZERO) > 0) {
                Real temp = new Real(Real.PI_GREEK32);
                temp.quotient(temp, (new Real(2.0)));
                return temp;
            } else {
                Real temp = new Real(Real.PI_GREEK32);
                temp.quotient(temp, (new Real(2.0)));
                temp.setValue(temp.getValue().negate());
                return temp;
            }
        } else if (this.getReal().getValue().compareTo(BigDecimal.ZERO) > 0) {
            Real temp = new Real();
            temp.thetaService(real, imag);
            return temp;
        } else {
            if (this.getImag().getValue().compareTo(BigDecimal.ZERO) >= 0) {
                Real temp = new Real();
                temp.thetaService(real, imag);
                temp.sum(temp, (new Real(Real.PI_GREEK32)));
                return temp;
            } else {
                Real temp = new Real();
                temp.thetaService(real, imag);
                temp.sub(temp, (new Real(Real.PI_GREEK32)));
                return temp;
            }
        }
    }

    void setRealValue(double value) {
        this.real.setValue(BigDecimal.valueOf(value));
    }

    void setImagValue(double value) {
        this.imag.setValue(BigDecimal.valueOf(value));
    }

    void sum(Complex z1, Complex z2) {
        this.real.sum(z1.getReal(), z2.getReal());
        this.imag.sum(z1.getImag(), z2.getImag());
    }

    void sub(Complex z1, Complex z2) {
        this.real.sub(z1.getReal(), z2.getReal());
        this.imag.sub(z1.getImag(), z2.getImag());
    }

    void product(Complex z1, Complex z2) {
        Real temp1;
        Imag temp2;
        temp1 = new Real();
        temp2 = new Imag();
        this.real.product(z1.getReal(), z2.getReal());
        temp1.product(z1.getImag(), z2.getImag());
        this.real.sum(this.real, temp1);
        this.imag.product(z2.getImag(), z1.getReal());
        temp2.product(z1.getImag(), z2.getReal());
        this.imag.sum(this.imag, temp2);
    }

    Complex conjugate() {
        return new Complex(this.real, this.imag.negate());
    }

    Real sumOfSquares() {
        Real temp;
        temp = this.real.square();
        temp.sum(temp, this.imag.squareOfImaginaryCoefficient());
        return temp;
    }

    void quotient(Complex z1, Complex z2) {
        if (z2.getReal().itCannotBeDivisor() && z2.getImag().itCannotBeDivisor()) {
            throw new ArithmeticException("It cannot be divisor!");
        } else {
            Complex temp;
            temp = new Complex(z2.conjugate());
            Real divisor;
            divisor = temp.sumOfSquares();
            this.product(z1, temp);
            this.real.quotient(this.real, divisor);
            this.imag.quotient(this.imag, divisor);
        }
    }
}
