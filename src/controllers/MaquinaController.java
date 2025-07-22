package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import models.Maquina;


public class MaquinaController {

    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas, int umbral) {
        Stack<Maquina> pila = new Stack<>();
        for(Maquina m : maquinas) {
            if(m.getSubred() > umbral) {
                pila.push(m);
            }
        }
        return pila;

    }

    public Set<Maquina> ordenarPorSubred(Stack<Maquina> pila) {
        List<Maquina> lista = new ArrayList<>();
        lista.sort(Comparator.comparingInt(Maquina::getSubred));
        return new LinkedHashSet<>(lista);
        
    }

    public Map<Integer, Queue<Maquina>> agruparPorRiesgo(List<Maquina> maquinas) {
        Map<Integer , Queue<Maquina>> mapa = new HashMap<>();
        for(Maquina m : maquinas) {
            int riesgo = m.getRiesgo();

            mapa.computeIfAbsent(riesgo, k -> new LinkedList<>()).add(m);
        }
        return mapa;
    }

    
    public Stack<Maquina> explotarGrupo(Map<Integer, Queue<Maquina>> mapa) {
        Stack<Maquina> pila = new Stack<>();
        for(Queue<Maquina> grupo : mapa.values()) {
            while(!grupo.isEmpty()) {
                pila.push(grupo.poll());
            }
        }
        return pila;
    }
}
