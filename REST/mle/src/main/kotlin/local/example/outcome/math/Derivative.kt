package local.example.outcome.math

import Jama.Matrix

interface Derivative {
    fun firstDerivative(
        x: Matrix?,
        y: Matrix?,
        parameters: Matrix?
    ): Matrix?

    fun secondDerivative(
        x: Matrix?,
        y: Matrix?,
        parameters: Matrix?
    ): Matrix?
}
