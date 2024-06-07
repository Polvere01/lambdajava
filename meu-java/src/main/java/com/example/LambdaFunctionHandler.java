package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        long startTime = System.nanoTime();  // Tempo inicial em nanossegundos
        int n = 39; // Ajuste este valor conforme necessário para calcular o Fibonacci

        // Calcula o Fibonacci
        int result = Fibonacci.fibonacci(n);

        long endTime = System.nanoTime();  // Tempo final em nanossegundos
        double duration = (endTime - startTime) / 1_000_000_000.0; // Convertendo para segundos

        return "Resultado: " + result + ", Tempo de execução: " + duration + " segundos";
    }
}
