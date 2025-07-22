package models;

import java.util.List;

public class Maquina {
    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred;
    private int riesgo;

    

    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
        this.subred = subred;
        this.riesgo = riesgo;
    }


    public String getNombre() {
        return nombre;
    }    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getIp() {
        return ip;
    } 
    
    public void setIp(String ip) {
        this.ip = ip;
    } 
    
    public List<Integer> getCodigos() {
        return codigos;
    }  
    
    public void setCodigos(List<Integer> codigos) {
        this.codigos = codigos;
    }
  
    public int getSubred() {
        return subred;
    }
     
    public void setSubred(int subred) {
        this.subred = subred;
    }
     
    public int getRiesgo() {
        return riesgo;
    }
     
    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }
    
    private int calcularSubred() {
        String[] partes = ip.split("\\.");
        if(partes.length >= 2) {
            try {
                int p1 = Integer.parseInt(partes[0]);
                int p2 = Integer.parseInt(partes[1]);
                return (p1 << 8) + p2;
                } catch (NumberFormatException e) {
                    return 0;
                }
        }
        return 0;
    }
        
        
    private int calcularRiesgo() {

        return codigos.stream().mapToInt(Integer::intValue).sum();
    }
    
    @Override
    public String toString() {
        return "Maquina [nombre=" + nombre + ", ip=" + ip + ", codigos=" + codigos + ", subred=" + subred + ", riesgo="
                + riesgo + "]";
            }

    
    
    
}
