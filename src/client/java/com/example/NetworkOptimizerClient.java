package com.example;

import net.fabricmc.api.ClientModInitializer;

public class NetworkOptimizerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("NetworkOptimizer: Inicializando lógica de filtrado de cliente...");
    }
}
