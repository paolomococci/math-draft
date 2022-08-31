package local.example.outcome.math

import Jama.Matrix

class Normal : Derivative {
    override fun firstDerivative(
        x: Matrix?,
        y: Matrix?,
        parameters: Matrix?
    ): Matrix {
        val n = x!!.rowDimension
        val k = x.columnDimension
        val beta = Matrix(k, 1)
        for (i in 0 until k) {
            beta[i, 0] = parameters!![i, 0]
        }
        val sigma2 = parameters!![k, 0]
        val xBeta = x.times(beta)
        val yMinusXBeta = y!!.minus(xBeta)
        val sigma4 = sigma2 * sigma2
        val xte = x.transpose().times(yMinusXBeta)
        val ete = yMinusXBeta.transpose().times(yMinusXBeta)
        val fstDerivative = Matrix(parameters.rowDimension, 1)
        for (i in 0 until k) {
            fstDerivative[i, 0] = xte[i, 0] / sigma2
        }
        fstDerivative[k, 0] = ete[0, 0] / (2.0 * sigma4) - n / (2.0 * sigma2)
        return fstDerivative
    }

    override fun secondDerivative(
        x: Matrix?,
        y: Matrix?,
        parameters: Matrix?
    ): Matrix? {
        val n = x!!.rowDimension
        val k = x.columnDimension
        val beta = Matrix(k, 1)
        for (i in 0 until k) {
            beta[i, 0] = parameters!![i, 0]
        }
        val sigma2 = parameters!![k, 0]
        val xBeta = x.times(beta)
        val yMinusXBeta = y!!.minus(xBeta)
        val xtx = x.transpose().times(x)
        val ete = yMinusXBeta.transpose().times(yMinusXBeta)
        val xte = x.transpose().times(yMinusXBeta)
        val sigma4 = sigma2 * sigma2
        val sigma6 = sigma2 * sigma2 * sigma2
        val secDerivative = Matrix(
            parameters.rowDimension,
            parameters.rowDimension
        )
        for (i in 0 until k) {
            for (j in 0 until k) {
                secDerivative[i, j] = -xtx[i, j] / sigma2
            }
        }
        for (i in 0 until k) {
            secDerivative[i, k] = -xte[i, 0] / sigma4
            secDerivative[k, i] = -xte[i, 0] / sigma4
        }
        secDerivative[k, k] = n / (2.0 * sigma4) - ete[0, 0] / sigma6
        return secDerivative
    }

    companion object {
        fun performsOrdinaryLeastSquares(y: Matrix, x: Matrix): Matrix {
            val n = x.rowDimension
            val k = x.columnDimension
            val xtx = x.transpose().times(x)
            val xty = x.transpose().times(y)
            val beta = xtx.inverse().times(xty)
            val e = y.minus(x.times(beta))
            val ete = e.transpose().times(e)
            val parameters = Matrix(k + 1, 1)
            for (i in 0 until k) {
                parameters[i, 0] = beta[i, 0]
            }
            parameters[k, 0] = ete[0, 0] / (n - k)
            return parameters
        }
    }
}
