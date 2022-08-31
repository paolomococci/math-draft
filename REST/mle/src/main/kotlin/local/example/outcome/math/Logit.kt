package local.example.outcome.math

import Jama.Matrix
import kotlin.math.exp

class Logit : Derivative {
    override fun firstDerivative(
        x: Matrix?,
        y: Matrix?,
        parameters: Matrix?
    ): Matrix {
        val n = x!!.rowDimension
        val k = parameters!!.rowDimension
        val fstDerivative = Array(k) { DoubleArray(1) }
        for (i in 0 until n) {
            val row = x.array[i]
            val one = 1.0 - y!![i, 0] - pPlus(row, parameters)
            for (j in 0 until k) {
                fstDerivative[j][0] += -one * row[j]
            }
        }
        return Matrix(fstDerivative)
    }

    override fun secondDerivative(
        x: Matrix?,
        y: Matrix?,
        parameters: Matrix?
    ): Matrix {
        val n = x!!.rowDimension
        val k = parameters!!.rowDimension
        val secDerivative = Array(k) { DoubleArray(k) }
        for (i in 0 until n) {
            val row = x.array[i]
            val p = pMinus(row, parameters)
            for (j in 0 until k) {
                for (l in row.indices) {
                    secDerivative[j][l] += -p * (1.0 - p) * row[j] * row[l]
                }
            }
        }
        return Matrix(secDerivative)
    }

    private fun pMinus(
        x: DoubleArray,
        beta: Matrix?
    ): Double {
        var xtb = 0.0
        for (i in x.indices) {
            xtb += x[i] * beta!![i, 0]
        }
        return 1.0 / (1.0 + exp(-xtb))
    }

    private fun pPlus(
        x: DoubleArray,
        beta: Matrix?
    ): Double {
        var xtb = 0.0
        for (i in x.indices) {
            xtb += x[i] * beta!![i, 0]
        }
        return 1.0 / (1.0 + exp(xtb))
    }
}
