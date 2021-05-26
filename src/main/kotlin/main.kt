fun main() {
    println("Bem vindo ao Bytebank!");
    //variaveis()
    //fluxoDeRepeticao()
    //entendendoDiferencaEntreCopiaEReferencia()

    //Usando Label no patâmetos do construtor!
    val contaRodrigo = Conta(numero = 1000, titular = "Rodrigo")

    contaRodrigo.deposita(2000.0)

    val contaFran = Conta("Franco", 1001)

    contaFran.deposita(300.0)

    println(contaRodrigo.titular)
    println(contaRodrigo.numero)
    println(contaFran.titular)
    println(contaFran.numero)


    println("Depositando na conta do ${contaRodrigo.titular}")
    contaRodrigo.deposita(50.0)
    println("Saldo da conta Rodrigo é de: ${contaRodrigo.saldo}")

    println("Saque na conta do ${contaRodrigo.titular}")
    contaRodrigo.saca(200.0)
    println("Saldo da conta Rodrigo é de: ${contaRodrigo.saldo}")

    println("Transferencia da conta do ${contaRodrigo.titular} para a conta da ${contaFran.titular}")
    if(contaRodrigo.transfere(50.00, contaFran)){
        println("Transferencia Ok!")
    }else{
        println("Falha na Transferencia!")
    }
    println("Saldo da conta Fran é de: ${contaFran.saldo}")

}

//Criando a classe Conta - Vamos melhorar no futuro
class Conta(var titular: String, var numero: Int){
     var saldo = 0.0
         private set

    /* --Construtor Secundário

    constructor(titular: String, numero: Int){
        this.titular = titular
        this.numero = numero
    }
    */


    /*
    - Caso eu quisesse colocar uma regra de négocio, no set padrao da propertie saldo:
    - valor é de fato o valor que eu estou passando para a propertie
    - field é de fato a atribuição do valor para a propertie, é ele que injeta o valor!
        var saldo = 0.0
        set(valor){
            if(valor > 1000){
                field = valor
            }
        }
     */

    fun deposita(valor: Double){
        if(valor > 0){
            this.saldo += valor
        }
    }

    fun saca(valor: Double){
        if(this.saldo >= valor){
            this.saldo -= valor
        }else{
            println("Saldo insuficiente!")
        }
    }

    fun transfere(valor: Double, destino: Conta) : Boolean{
        if(this.saldo >= valor){
            this.saldo -= valor
            destino.deposita(valor)
            return true
        }
            return false
    }
/*
    -- Não usamos getter e setter em Kotlin
    fun getSaldo() : Double{
        return this.saldo
    }

    fun getTitular() : String{
        return this.titular
    }

    fun getNumero() : Int{
        return this.numero
    }

    fun setSaldo(saldo: Double){
        this.saldo = saldo
    }

    fun setTitular(titular: String){
        this.titular = titular
    }

    fun setNumero(numero: Int){
        this.numero = numero
    }

 */
}





fun variaveis() {
    println("Bem vindo ao Bytebank!");

    //val é a variaável que não pode mudar de valor e é uma boa prática usá-la!
    //No kotlin não precisamos tipar as variaveis,
    // mas o valor dado a variavel vai tipificar ela! Como deu dei texto, o seu tipo será String.
    //Caso eu queria tipar explicitamente a variavel, ficaria -> val titular: String = "Rodrigo"
    val titular = "Rodrigo"
    val numeroConta = 1000

    // o trecho titular = "Rodrigo Franco" vai dar erro, pois usamos val, para mudar usamos o var:
    var titularMutavel = "Rodrigo"
    titularMutavel = "Rodrigo Franco"
    var saldo = 0.0
    saldo += 100.00

    //Exemplos com concatenação
    //println("Titular " + titular)

    //Exemplos do Template - O mais utilizado!
    println("Titular $titular")
    println("Número da Conta $numeroConta")
    println("Saldo $saldo")
}

fun fluxoDeRepeticao() {
    var saldo = 0.0

    //Quando fazemos esse IF a IDE sugere utilizarmos o When, ilustrado a seguir:
    if (saldo > 0.0) {
        println("Saldo é positivo")
    } else if (saldo == 0.0) {
        println("Saldo é neutro")
    } else {
        println("Saldo é negativo")
    }

    //Fazendo a mesma coisa que o if anterior
    when {
        saldo > 0.0 -> {
            println("Saldo é positivo")
        }
        saldo == 0.0 -> {
            println("Saldo é neutro")
        }
        else -> {
            println("Saldo é negativo")
        }
    }
    //Quando a condicional faz apenas uma coisa, no nosso caso apenas um print, podemos deixar o when assim
    when {
        saldo > 0.0 -> println("Saldo é positivo")
        saldo == 0.0 -> println("Saldo é neutro")
        else -> println("Saldo é negativo")
    }

    //Loopings:

    //O for abaixo, para percorrer uma collection, mas nao aprendemos collection ainda
    //for(item in collection) println(item)

    //O for abaixo, para percorrer uma collection, mas nao aprendemos collection ainda
    //for(item: int in ints) {

    // }

    //Passando por todos elementos de 1 a 5
    for (i in 1..5) {
        println(i)
    }

    //Passando por todos elementos de 1 a 5, mas pulando de 2 em 2
    //Começa passando pelo 1, depois vai para o 3 e 5, pois (1+2=3) e (3+2=5)
    for (i in 1..5 step 2) {
        println(i)
    }

    //Passando por todos elementos de 5 a 1, ou seja, ordem inversa
    for (i in 5 downTo 1) {
        println(i)
    }

    //Temos uma laço de repetição. O laço se repete enquanto  a condicional for verdadeira
    //Ñ podemos de esquecer de iniciar a variavel e de incrementá-la dentro do código
    var i = 0
    while (i < 5) {
        println(i)
        i++
    }

    //Outra forma de usar o while
    var t=0
    do{
        println("Do while $t")
        t++
    }while(t<5)
}


fun entendendoDiferencaEntreCopiaEReferencia(){
    //É igual no java
    //contaRodrigo é uma referencia para o objeto do tipo Conta

    val contaRodrigo = Conta("Rodrigo", 1000)
   // Nao funciona mais, pois o set de saldo agora é private contaRodrigo.saldo = 200.0

    val contaFran = Conta("Fran", 1001)
    // Nao funciona mais, pois o set de saldo agora é private contaFran.saldo = 300.0

    println(contaRodrigo.titular)
    println(contaRodrigo.numero)
    println(contaRodrigo.saldo)

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    // Inicio do: Entendo copia e referencia:

    // --Variaveis com tipo Primitivo:

    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    //Apenas o numeroY foi alterado! Pois com número primitivo ocorre a Copia!

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    // --Variaveis que são referencia de um objeto

    val contaJoao = Conta("Joao", 2000)


    val contaMaria = contaJoao;
    contaMaria.titular = "Maria"

    //Ambas as contas foram alteradas! Pois a variável que aponta para objeto é sempre uma referencia!
    //Apontam para o mesmo endereço de memoria!

    println("Titular de contaJoao é ${contaJoao.titular}")
    println("Titular de contaMaria é ${contaMaria.titular}")

    //Fim do: Entendendo copia e referencia.
}