package local.example.outcome.algorithm

import Jama.Matrix

import local.example.outcome.math.Derivative

import kotlin.math.abs

class NewtonRaphson(private val derivative: Derivative) {
    fun run(
        x: Matrix?,
        y: Matrix?,
        startValues: Matrix
    ): Matrix {
        val maxNumberOfIterations = 100
        val epsilon = 0.01
        var counter = 0
        var parameters = startValues.copy()
        do {
            val hessianMatrix = derivative.secondDerivative(x, y, parameters)
            if (abs(hessianMatrix!!.det()) < epsilon) {
                println("--- Hessian turns out to be singular ---")
                hessianMatrix.print(2, 2)
                counter = -1
                break
            }
            val hessianInverseMatrix = hessianMatrix.inverse()
            val fstDerivativeMatrix = derivative.firstDerivative(x, y, parameters)
            parameters = parameters.minus(hessianInverseMatrix.times(fstDerivativeMatrix))
            counter++
        } while (counter < maxNumberOfIterations)
        println("counter: $counter")
        return parameters
    }
}
