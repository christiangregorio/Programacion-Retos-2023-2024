package models

abstract class Ferrari: Equipos() {

    var isMalaEstrategia=false
    var isProblemasDeFiabilidad=false
    var tiempoMalaEstrategia=0
    fun malaEstrategia():Boolean{
        if ((0..100).random()<2)return true
        return false
    }

    fun problemasFiabilidad():Boolean{
        if ((0..100).random()<3)return true
        return false
    }

    /**
     * mientras que el piloto haya terminado la carrera y que no este en mala estrategia
     * hacemos la probabilidad de que sea mala estrategia que es una funcion que es de herencia
     * @param piloto
     *
     */
    fun accionesFerrari() {
        if (!((this as Piloto).acabada())&&!this.isMalaEstrategia ){
            this.isMalaEstrategia=this.malaEstrategia()
            if (this.isMalaEstrategia){
                println("${this.nombre} A SUFRIDO UNA MALA ESTRATEGIA")
                this.tiempoMalaEstrategia=2
            }
        }
        if (!((this as Piloto).acabada())&& !this.isProblemasDeFiabilidad){
            this.isProblemasDeFiabilidad=this.problemasFiabilidad()
            if (this.isProblemasDeFiabilidad)this.isDnf=true
        }
    }

    fun moverFerrari(){
        if (this.tiempoMalaEstrategia!=0){
            this.tiempoMalaEstrategia--
        }else if (this.tiempoMalaEstrategia==0) {
            this.isMalaEstrategia = false
            (this as Piloto).mover()
        }
    }
}